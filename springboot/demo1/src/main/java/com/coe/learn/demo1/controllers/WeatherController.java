package com.coe.learn.demo1.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.coe.learn.demo1.models.Weather;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/w")
public class WeatherController {
    static String API_KEY = "cbc5a664c0098b7f71f091d52210c4b0";

    @RequestMapping(value = {"/current", "/current/{lat}", "/current/{long}", "/current/{long}/{lat}"})
    public String getCurrentData(
        // @RequestParam("long_param") double longParam,
        @PathVariable("long") Optional<Double> demLong,
        @PathVariable("lat") Optional<Double> demLat
    ) {

        // Call external service to get current weather data
        String restUrl = "https://api.openweathermap.org/data/2.5/weather?lat="+ demLat.get() + "&lon=" + demLong.get() + "&appid=" + API_KEY;
        RestTemplate rest = new RestTemplate();
        String result = rest.getForObject(restUrl, String.class);

        // Extract result data
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Weather weather = objectMapper.readValue(result, Weather.class);

            return weather.getWeather().get(0).toString();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // Response data
        return null;
    }
}
