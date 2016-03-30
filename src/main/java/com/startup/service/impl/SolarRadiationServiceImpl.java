package com.startup.service.impl;

import com.startup.entity.SolarRadiationLatilt;
import com.startup.repository.SolarRadiationRepository;
import com.startup.service.SolarRadiationService;
import com.startup.vo.GeometryDataVO;
import org.elasticsearch.common.collect.Lists;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Justin on 3/30/2016.
 */
@Service
@Transactional
public class SolarRadiationServiceImpl implements SolarRadiationService {

    @Resource
    SolarRadiationRepository solarRadiationRepository;

    @Override
    public List<GeometryDataVO> getAllData() {
        List<GeometryDataVO> geometryDataVOs = new ArrayList<GeometryDataVO>();
        List<SolarRadiationLatilt> data = Lists.newArrayList(solarRadiationRepository.findAll());

        for (SolarRadiationLatilt dataPoint : data) {
            GeometryDataVO vo = new GeometryDataVO();
            vo.setGeometry(dataPoint.getGeom());
            vo.setProperties(dataPoint);
            geometryDataVOs.add(vo);
        }

        return geometryDataVOs;
    }
}
