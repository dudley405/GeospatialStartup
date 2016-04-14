package com.startup.service;

import com.startup.entity.BaseEntity;
import org.geojson.Feature;

/**
 * Created by Justin on 4/8/2016.
 */
public interface FeatureService {

    Feature buildEntityFeature(BaseEntity entity);
}
