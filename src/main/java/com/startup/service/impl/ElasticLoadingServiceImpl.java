package com.startup.service.impl;

import com.google.common.collect.Lists;
import com.startup.repository.SolarRadiationRepository;
import com.startup.service.ElasticLoadingService;
import com.startup.service.ElasticSearchService;
import com.startup.service.SolarRadiationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.io.IOException;

/**
 * Created by Justin on 2/29/2016.
 *
 * Used to initialize database with data
 */
@Service("loadingService")
@Transactional
public class ElasticLoadingServiceImpl implements ElasticLoadingService {

    @Resource
    ElasticSearchService elasticSearchService;

    @Resource
    SolarRadiationRepository solarRadiationRepository;

    @Override
    public void initElasticSearch() throws IOException {
        elasticSearchService.bulkLoad(Lists.newArrayList(solarRadiationRepository.findAll()));
    }
}
