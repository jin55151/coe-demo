package com.coe.cloud.student.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class StudentController {

    @Value("${dataUrl}")
    String dataUrl;

    @RequestMapping("config")
    public String getConfig() {
        return dataUrl;
    }
}
