package com.startup.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.startup.entity.AirportsUs;
import com.startup.service.AirportService;
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
    public ResponseEntity<String> home() {
        List<AirportsUs> airports = airportService.getAllAirports();
        ObjectMapper mapper = new ObjectMapper();
        String response = "";
        try {
             response = mapper.writeValueAsString(airports);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().body(response);
    }
}
