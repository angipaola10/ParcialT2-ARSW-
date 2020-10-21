package edu.eci.arsw.weather.services.impl;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.weather.services.IHttpConectionServices;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class HttpConectionServices implements IHttpConectionServices {

    public HttpConectionServices(){}

    @Override
    public JSONObject getWeatherByCity(String city) throws UnirestException {
        HttpResponse<String> response = Unirest.get("http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=ea9c5a7d873963c1abb9207fc904db83")
                .asString();
        return new JSONObject(response.getBody());
    }

}
