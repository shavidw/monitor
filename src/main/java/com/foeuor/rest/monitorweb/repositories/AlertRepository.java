package com.foeuor.rest.monitorweb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foeuor.rest.monitorweb.entity.Alert;

@Repository
public interface AlertRepository extends JpaRepository<Alert, Long> {
	
}
