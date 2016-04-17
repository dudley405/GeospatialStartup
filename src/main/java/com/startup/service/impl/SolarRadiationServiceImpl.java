package com.startup.service.impl;

import com.startup.entity.SolarRadiationLatilt;
import com.startup.repository.SolarRadiationRepository;
import com.startup.service.FeatureService;
import com.startup.service.SolarRadiationService;
import org.geojson.Feature;
import org.geojson.FeatureCollection;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

/**
 * Created by Justin on 3/30/2016.
 */
@Service
@Transactional
public class SolarRadiationServiceImpl implements SolarRadiationService {

    @Resource
    SolarRadiationRepository solarRadiationRepository;

    @Resource
    FeatureService featureService;

    @Override
    public FeatureCollection getAllData() throws IOException {
        FeatureCollection features = new FeatureCollection();

        for (SolarRadiationLatilt dataPoint : solarRadiationRepository.findByPotential("Excellent")) {
            Feature feature = featureService.buildEntityFeature(dataPoint);
            features.add(feature);
        }

        return features;
    }
}
