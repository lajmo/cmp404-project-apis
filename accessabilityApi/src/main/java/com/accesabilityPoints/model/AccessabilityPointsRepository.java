package com.accesabilityPoints.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessabilityPointsRepository extends JpaRepository<AccessabilityPoint, Integer>{
	
}