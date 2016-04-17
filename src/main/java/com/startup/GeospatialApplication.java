package com.startup;

import com.google.code.ssm.config.DefaultAddressProvider;
import com.google.code.ssm.providers.CacheConfiguration;
import com.google.code.ssm.providers.elasticache.MemcacheClientFactoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@SpringBootApplication
@EnableCaching
@Configuration
public class GeospatialApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(GeospatialApplication.class);
	}

	@Bean
	MemcacheClientFactoryImpl memcacheClientFactory() {
		MemcacheClientFactoryImpl memCachedClientFactory = new MemcacheClientFactoryImpl();

		DefaultAddressProvider provider = new DefaultAddressProvider("solardata.xrwofb.0001.usw2.cache.amazonaws.com:11211");

		CacheConfiguration configuration = new CacheConfiguration();
		configuration.setConsistentHashing(true);

		try {
			memCachedClientFactory.create(provider.getAddresses(), configuration);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return memCachedClientFactory;
	}

	public static void main(String[] args) throws IOException {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(GeospatialApplication.class, args);
	}
}
