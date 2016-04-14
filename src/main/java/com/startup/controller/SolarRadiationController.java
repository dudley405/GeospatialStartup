package com.startup.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.startup.service.SolarRadiationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by Justin on 3/26/2016.
 */
@RestController
public class SolarRadiationController {

    @Resource
    SolarRadiationService solarRadiationService;

    @RequestMapping("/solarData/getAll")
    public ResponseEntity<String> home() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return ResponseEntity.ok().body(mapper.writeValueAsString(solarRadiationService.getAllData()));
    }
}
