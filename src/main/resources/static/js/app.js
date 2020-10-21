app = (function (){

    var _module = "js/apiclient.js";

    function _updateData(data){
        $("#lblname").text("City: "+data.name);
        $("#lblid").text("Id: "+data.id);
        $("#lbltimezone").text("City: "+data.timezone);
        $("#lbldt").text("Dt: "+data.dt);
        $("#lblclouds").text("Clouds: "+data.clouds);
        $("#lblvisibility").text("Visibility: "+data.visibility);
        $("#lblbase").text("Base: "+data.base);
        $("#lbllat").text("Lat: "+data.coord.lat);
        $("#lbllon").text("Lon: "+data.coord.lon);
        $("#lblwid").text("Id: "+data.weather.id);
        $("#lblmain").text("Main: "+data.weather.main);
        $("#lbldescrp").text("Description: "+data.weather.description);
        $("#lblicon").text("Icon: "+data.weather.icon);
        $("#lbltemp").text("Temp: "+data.main.temp);
        $("#lblfeels").text("Feels like: "+data.main.feels_like);
        $("#lbltmpmin").text("Temp min: "+data.main.temp_min);
        $("#lbltmpmax").text("Temp max: "+data.main.temp_max);
        $("#lblpress").text("Pressure: "+data.main.pressure);
        $("#lblhumed").text("humidity: "+data.main.humidity);
        $("#lblspeed").text("Speed: "+data.sys.temp);
        $("#lbldeg").text("Deg: "+data.sys.id);
        $("#lbltype").text("Type: "+data.wind.speed);
        $("#lblSYSid").text("Id: "+data.wind.deg);
        $("#lblcountry").text("Country: "+data.sys.country);
        $("#lblsunrise").text("Sunrise: "+data.sys.sunrise);
        $("#lblsunset").text("Sunset: "+data.sys.sunset);
        document.getElementById("infow").style.visibility="visible";
    }

    return {

        getWeatherByCity: function (city) {
            $.getScript(_module, function () {
                api.getWeatherByCity(city, _updateData);
            });
        }
    }

})();