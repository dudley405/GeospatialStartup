package com.startup.service.impl;

import com.fasterxml.jackson.databind.deser.Deserializers;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.startup.entity.BaseEntity;
import com.startup.entity.SolarRadiationLatilt;
import com.startup.helper.JsonToPolygonDeserializer;
import com.startup.service.ElasticSearchService;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.JestResult;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.*;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.geojson.Feature;
import org.geojson.FeatureCollection;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Justin on 4/12/2016.
 */
@Service
public class ElasticSearchServiceImpl implements ElasticSearchService {

    private JestClient client;

    public ElasticSearchServiceImpl() {
        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(new HttpClientConfig.Builder("http://search-solardata-nafnad27dlip7qhttlxuoe4eli.us-west-2.es.amazonaws.com:80").multiThreaded(true).build());
        client = factory.getObject();
    }


    public void bulkLoad(List<SolarRadiationLatilt> featureCollection) throws IOException {
        List<Index> indexes = new ArrayList<Index>();
        for (SolarRadiationLatilt feature : featureCollection) {
            Index index = new Index.Builder(feature).build();
            indexes.add(index);
        }

        Bulk bulk = new Bulk.Builder()
                .defaultIndex("solar_data")
                .defaultType("solar_data_latilt")
                .addAction(indexes)
                .build();

        client.execute(bulk);
    }

    public List<SolarRadiationLatilt> getAll() throws IOException {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(
                QueryBuilders.matchAllQuery());
        Search search = new Search.Builder(searchSourceBuilder.toString())
                .addIndex("solar_data")
                .build();

        JestResult result = client.execute(search);

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(SolarRadiationLatilt.class, new JsonToPolygonDeserializer());
        Gson gson = gsonBuilder.create();


        SolarRadiationLatilt dataPoints = gson.fromJson(result.getJsonString(), SolarRadiationLatilt.class);

        return new ArrayList<>();
    }
}
