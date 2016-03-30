package com.startup.service;

import com.startup.entity.SolarRadiationLatilt;
import com.startup.vo.GeometryDataVO;

import java.util.List;

/**
 * Created by Justin on 3/30/2016.
 */
public interface SolarRadiationService {

    List<GeometryDataVO> getAllData();
}
