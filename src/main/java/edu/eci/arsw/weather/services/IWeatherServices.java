package edu.eci.arsw.weather.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.weather.model.WeatherCity;

import java.io.IOException;

public interface IWeatherServices {

    WeatherCity getWeatherByCity(String city) throws UnirestException, IOException;
}
