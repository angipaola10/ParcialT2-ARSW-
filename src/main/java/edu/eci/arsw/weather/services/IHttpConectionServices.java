package edu.eci.arsw.weather.services;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.weather.model.Weather;
import org.json.JSONObject;

public interface IHttpConectionServices {

     JSONObject getWeatherByCity(String city) throws UnirestException;

}
