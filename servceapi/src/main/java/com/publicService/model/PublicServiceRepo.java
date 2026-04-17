package com.publicService.model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicServiceRepo extends JpaRepository<PublicService, Integer>{
	
}
