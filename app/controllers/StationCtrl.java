package controllers;

import Utils.LatestWeather;
import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;

public class StationCtrl extends Controller {
  public static void index(Long id) {
    Station station = Station.findById(id);
    Logger.info("Station id = " + id);

    Reading lastReading = LatestWeather.getLastReading(station.readings);

    station.tempC = lastReading.temperature;
    station.pressure = lastReading.pressure;

    Reading minTemp = LatestWeather.getMinTemp(station.readings);
    station.minTempValue = minTemp.temperature;
    Reading maxTemp = LatestWeather.getMaxTemp(station.readings);
    station.maxTempValue = maxTemp.temperature;

    Reading minPressure = LatestWeather.getMinPressure(station.readings);
    station.minPressureValue = minPressure.pressure;
    Reading maxPressure = LatestWeather.getMaxPressure(station.readings);
    station.maxPressureValue = maxPressure.pressure;

    Reading minWindSpeed = LatestWeather.getMinWindSpeed(station.readings);
    station.minWindSpeedValue = minWindSpeed.windSpeed;
    Reading maxWindSpeed = LatestWeather.getMaxWindSpeed(station.readings);
    station.maxWindSpeedValue = maxWindSpeed.windSpeed;

    station.convertTemp = LatestWeather.convertDegCtoF(lastReading.temperature);
    station.calculateWindChill = LatestWeather.calculateWindChill(lastReading.temperature, lastReading.windSpeed);
    station.convertWindSpeed = LatestWeather.convertWindSpeed(lastReading.windSpeed);
    station.convertWindDirection = LatestWeather.getCompassDirection(lastReading.windDirection);
    station.weatherCode = LatestWeather.weatherCondition(lastReading.code);

    render("station.html", station, lastReading);
  }

  public static void deletereading(Long id, Long readingid) {
    Station station = Station.findById(id);
    Reading reading = Reading.findById(readingid);
    station.readings.remove(reading);
    station.save();
    reading.delete();
    redirect("/stations/" + id);
  }

  public static void addReading(Long id, int code, double temperature, double windSpeed, int windDirection, int pressure) {
    Reading reading = new Reading(code, temperature, windSpeed, windDirection, pressure);
    Station station = Station.findById(id);
    station.readings.add(reading);
    station.save();
    redirect("/stations/" + id);
  }
}
