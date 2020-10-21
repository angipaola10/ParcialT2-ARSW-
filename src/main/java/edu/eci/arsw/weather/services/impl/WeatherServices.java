package edu.eci.arsw.weather.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.weather.model.*;
import edu.eci.arsw.weather.services.IHttpConectionServices;
import edu.eci.arsw.weather.services.IWeatherServices;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

@Service
public class WeatherServices implements IWeatherServices {

    @Autowired
    IHttpConectionServices httpConectionServices;

    public WeatherServices() {}

    @Override
    public WeatherCity getWeatherByCity(String city) throws UnirestException, IOException {

        JSONObject rta = httpConectionServices.getWeatherByCity(city);

        JSONObject jsonObject = rta.getJSONObject("coord");
        ObjectMapper mapper = new ObjectMapper();
        Coord coord = mapper.readValue(jsonObject.toString(), Coord.class);

        jsonObject = rta.getJSONArray("weather").getJSONObject(0);
        Weather weather = mapper.readValue(jsonObject.toString(), Weather.class);

        String base = rta.getString("base");

        jsonObject = rta.getJSONObject("main");
        Main main = mapper.readValue(jsonObject.toString(), Main.class);

        int visibility = rta.getInt("visibility");

        jsonObject = rta.getJSONObject("wind");
        Wind wind = mapper.readValue(jsonObject.toString(), Wind.class);

        jsonObject = rta.getJSONObject("clouds");
        int clouds = rta.getJSONObject("clouds").getInt("all");

        Long dt = rta.getLong("dt");

        jsonObject = rta.getJSONObject("sys");
        Sys sys = mapper.readValue(jsonObject.toString(), Sys.class);

        int timezone = rta.getInt("timezone");

        int id = rta.getInt("id");

        String name = rta.getString("name");

        return new WeatherCity(coord, weather, base, main, visibility, wind, clouds, dt, sys, timezone, id, name);
    }
}
