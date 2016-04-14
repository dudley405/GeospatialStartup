package com.startup;

import com.startup.service.ElasticLoadingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class GeospatialApplication {


	public static void main(String[] args) throws IOException {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(GeospatialApplication.class, args);

		ElasticLoadingService loadingService = (ElasticLoadingService)applicationContext.getBean("loadingService");

		//loadingService.initElasticSearch();
	}
}
