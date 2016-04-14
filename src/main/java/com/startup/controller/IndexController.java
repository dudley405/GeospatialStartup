package com.startup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Justin on 4/11/2016.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String getHome() {
        return "index";
    }
}
