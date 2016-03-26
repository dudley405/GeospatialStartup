package com.startup.service.impl;

import com.startup.entity.AirportsUs;
import com.startup.repository.AirportRepository;
import com.startup.service.AirportService;
import com.startup.vo.GeometryDataVO;
import org.elasticsearch.common.collect.Lists;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Justin on 3/26/2016.
 */
@Service
public class AiportServiceImpl implements AirportService {

    @Resource
    AirportRepository airportRepository;


    @Override
    public List<GeometryDataVO> getAllAirports() {
        List<GeometryDataVO> vectors = new ArrayList<GeometryDataVO>();

        List<AirportsUs> airports =  Lists.newArrayList(airportRepository.findAll());

        if(airports != null && airports.size() > 0) {
            for (AirportsUs airport : airports) {
                GeometryDataVO vector = new GeometryDataVO();
                vector.setGeometry(airport.getGeom());
                vector.setProperties(airport);
                vectors.add(vector);
            }
        }

        return vectors;
    }
}
