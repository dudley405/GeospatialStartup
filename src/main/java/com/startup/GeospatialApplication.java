package com.startup;

import com.spatial4j.core.shape.Point;
import com.startup.entity.AirportsUs;
import com.startup.service.AirportService;
import org.hibernate.spatial.HibernateSpatialConfiguration;
import org.postgis.Geometry;
import org.postgis.GeometryCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class GeospatialApplication {

	@Autowired
	AirportService airportService;

	public static void main(String[] args) {
		SpringApplication.run(GeospatialApplication.class, args);
	}
}
