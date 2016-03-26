package com.startup.service.impl;

import com.startup.entity.AirportsUs;
import com.startup.repository.AirportRepository;
import com.startup.service.AirportService;
import org.elasticsearch.common.collect.Lists;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Justin on 3/26/2016.
 */
@Service
public class AiportServiceImpl implements AirportService {

    @Resource
    AirportRepository airportRepository;


    @Override
    public List<AirportsUs> getAllAirports() {
        return Lists.newArrayList(airportRepository.findAll());
    }
}
