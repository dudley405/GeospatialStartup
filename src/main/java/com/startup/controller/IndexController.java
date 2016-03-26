package com.startup.controller;

import com.startup.service.AirportService;
import com.startup.vo.GeometryDataVO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Justin on 3/26/2016.
 */
@Controller
public class IndexController {

    @Resource
    AirportService airportService;

    @RequestMapping("/")
    @ResponseBody
    public ResponseEntity<List<GeometryDataVO>> home() {
        List<GeometryDataVO> airports = airportService.getAllAirports();
        return ResponseEntity.ok().body(airports);
    }
}
