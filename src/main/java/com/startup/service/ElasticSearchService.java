package com.startup.service;

import com.startup.entity.BaseEntity;
import com.startup.entity.SolarRadiationLatilt;
import org.geojson.Feature;
import org.geojson.FeatureCollection;

import java.io.IOException;
import java.util.List;

/**
 * Created by Justin on 4/12/2016.
 */
public interface ElasticSearchService {

    void bulkLoad(List<SolarRadiationLatilt> featureCollection) throws IOException;

    List<SolarRadiationLatilt> getAll() throws IOException;
}
