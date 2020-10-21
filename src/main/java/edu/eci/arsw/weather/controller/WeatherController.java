package edu.eci.arsw.weather.controller;

import edu.eci.arsw.weather.services.IWeatherServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @Autowired
    IWeatherServices weatherServices;

    @RequestMapping(value="/weather/{city}", method = RequestMethod.GET)
    public ResponseEntity<?> getWeatherByCity(@PathVariable(name="city") String city) {
        try {
            return new ResponseEntity<>(weatherServices.getWeatherByCity(city), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>("Ha ocurrido un error", HttpStatus.BAD_REQUEST);
        }
    }

}
