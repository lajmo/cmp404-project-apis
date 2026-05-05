package com.routes.route_service;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class AzureMapsService {
	private final HttpClient httpClient = HttpClient.newHttpClient();
	private final ObjectMapper objectMapper = new ObjectMapper();

	@Value("${azure.maps.subscription-key}")
	private String subscriptionKey;

	public String search(String query) throws IOException, InterruptedException {
		String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8);
		String url = "https://atlas.microsoft.com/search/fuzzy/json?api-version=1.0&limit=5&query="
				+ encodedQuery
				+ "&subscription-key="
				+ URLEncoder.encode(subscriptionKey, StandardCharsets.UTF_8);

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(url))
				.GET()
				.build();

		return send(request);
	}

	public String route(RouteRequest routeRequest) throws IOException, InterruptedException {
		String query = String.format(
				Locale.US,
				"%f,%f:%f,%f",
				routeRequest.getStartLat(),
				routeRequest.getStartLon(),
				routeRequest.getEndLat(),
				routeRequest.getEndLon());
		String url = "https://atlas.microsoft.com/route/directions/json?api-version=1.0&routeRepresentation=polyline&travelMode=car&query="
				+ query
				+ "&subscription-key="
				+ URLEncoder.encode(subscriptionKey, StandardCharsets.UTF_8);

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(url))
				.GET()
				.build();

		return toGeoJson(send(request));
	}

	private String send(HttpRequest request) throws IOException, InterruptedException {
		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

		if (response.statusCode() < 200 || response.statusCode() >= 300) {
			throw new IllegalStateException("Azure Maps returned " + response.statusCode() + ": " + response.body());
		}

		return response.body();
	}

	private String toGeoJson(String azureRouteJson) throws IOException {
		JsonNode root = objectMapper.readTree(azureRouteJson);
		JsonNode routes = root.path("routes");

		if (!routes.isArray() || routes.isEmpty()) {
			throw new IllegalStateException("Azure Maps did not return any routes");
		}

		List<double[]> routePoints = new ArrayList<>();
		JsonNode legs = routes.get(0).path("legs");

		for (JsonNode leg : legs) {
			for (JsonNode point : leg.path("points")) {
				routePoints.add(new double[] { point.path("longitude").asDouble(), point.path("latitude").asDouble() });
			}
		}

		if (routePoints.isEmpty()) {
			throw new IllegalStateException("Azure Maps route did not include route points");
		}

		ObjectNode featureCollection = objectMapper.createObjectNode();
		featureCollection.put("type", "FeatureCollection");

		ArrayNode features = featureCollection.putArray("features");
		ObjectNode routeFeature = features.addObject();
		routeFeature.put("type", "Feature");
		routeFeature.set("properties", objectMapper.createObjectNode());

		ObjectNode geometry = routeFeature.putObject("geometry");
		geometry.put("type", "LineString");
		ArrayNode coordinates = geometry.putArray("coordinates");

		for (double[] point : routePoints) {
			ArrayNode coordinate = coordinates.addArray();
			coordinate.add(point[0]);
			coordinate.add(point[1]);
		}

		return objectMapper.writeValueAsString(featureCollection);
	}
}
