package com.startup.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.startup.service.SolarRadiationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Justin on 3/26/2016.
 */
@Controller
public class IndexController {

    @Resource
    SolarRadiationService solarRadiationService;

    @RequestMapping("/")
    @ResponseBody
    public ResponseEntity<String> home() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return ResponseEntity.ok().body(mapper.writeValueAsString(solarRadiationService.getAllData()));
    }
}
