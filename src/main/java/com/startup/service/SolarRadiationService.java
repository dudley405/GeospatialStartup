package com.startup.service;

import org.geojson.FeatureCollection;

import java.io.IOException;

/**
 * Created by Justin on 3/30/2016.
 */
public interface SolarRadiationService {

    FeatureCollection getAllData() throws IOException;
}
