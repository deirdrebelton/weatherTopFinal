package Utils;

import models.Reading;

import java.lang.Math;
import java.util.HashMap;
import java.util.List;

public class LatestWeather {

  public static Reading getLastReading(List<Reading> readings) {
    Reading lastReading = null;
    for (Reading reading : readings) {
      lastReading = readings.get(readings.size() - 1);
    }
    return lastReading;
  }

  public static String weatherCondition(int code) {
    HashMap<Integer, String> weatherCode = new HashMap<Integer, String>();
    weatherCode.put(100, "Clear");
    weatherCode.put(200, "Partial Clouds");
    weatherCode.put(300, "Cloudy");
    weatherCode.put(400, "Light Showers");
    weatherCode.put(500, "Heavy Shower");
    weatherCode.put(600, "Rain");
    weatherCode.put(700, "Snow");
    weatherCode.put(800, "Thunder");
    return weatherCode.get(code);
  }

  public static double convertDegCtoF(double temperature) {
    double degCtoF = 0;
    degCtoF = (temperature * (9.0 / 5.0)) + 32;
    return degCtoF;
  }

  public static double calculateWindChill(double temperature, double windSpeed) {
    double windChill = 0;
    windChill = Math.round((13.12 + (0.6215 * temperature) - (11.37 * (Math.pow(windSpeed, 0.16))) + (0.3965 * temperature * (Math.pow(windSpeed, 0.16)))) * (100d)) / 100d;
    return windChill;
  }

  public static String convertWindSpeed(double windSpeed) {
    String windBft = null;
    if (windSpeed > 1 && windSpeed <= 5) {
      windBft = "1";
    } else if (windSpeed >= 6 && windSpeed <= 11) {
      windBft = "2";
    } else if (windSpeed >= 12 && windSpeed <= 19) {
      windBft = "3";
    } else if (windSpeed >= 20 && windSpeed <= 28) {
      windBft = "4";
    } else if (windSpeed >= 29 && windSpeed <= 38) {
      windBft = "5";
    } else if (windSpeed >= 39 && windSpeed <= 49) {
      windBft = "6";
    } else if (windSpeed >= 50 && windSpeed <= 61) {
      windBft = "7";
    } else if (windSpeed >= 62 && windSpeed <= 74) {
      windBft = "8";
    } else if (windSpeed >= 75 && windSpeed <= 88) {
      windBft = "9";
    } else if (windSpeed >= 89 && windSpeed <= 102) {
      windBft = "10";
    } else if (windSpeed >= 103 && windSpeed <= 117) {
      windBft = "11";
    }
    return windBft;
  }

  public static String getCompassDirection(double windDirection) {
    String compassDirection;
    if (windDirection > 11.25 && windDirection < 33.75) {
      compassDirection = "NNE";
    } else if (windDirection > 33.75 && windDirection < 56.25) {
      compassDirection = "NE";
    } else if (windDirection > 56.25 && windDirection < 78.75) {
      compassDirection = "ENE";
    } else if (windDirection > 78.75 && windDirection < 101.25) {
      compassDirection = "E";
    } else if (windDirection > 101.25 && windDirection < 123.75) {
      compassDirection = "ESE";
    } else if (windDirection > 123.75 && windDirection < 146.25) {
      compassDirection = "SE";
    } else if (windDirection > 146.25 && windDirection < 168.75) {
      compassDirection = "SSE";
    } else if (windDirection > 168.75 && windDirection < 191.25) {
      compassDirection = "S";
    } else if (windDirection > 191.25 && windDirection < 213.75) {
      compassDirection = "SSW";
    } else if (windDirection > 213.75 && windDirection < 236.25) {
      compassDirection = "SW";
    } else if (windDirection > 236.25 && windDirection < 258.75) {
      compassDirection = "WSW";
    } else if (windDirection > 258.75 && windDirection < 281.25) {
      compassDirection = "W";
    } else if (windDirection > 281.25 && windDirection < 303.75) {
      compassDirection = "WNW";
    } else if (windDirection > 303.75 && windDirection < 326.25) {
      compassDirection = "NW";
    } else if (windDirection > 326.25 && windDirection < 348.75) {
      compassDirection = "NNW";
    } else {
      compassDirection = "N";
    }
    return compassDirection;
  }

  public static Reading getMinTemp(List<Reading> readings) {
    Reading minTemp = readings.get(0);
    for (Reading reading : readings) {
      if (reading.temperature < minTemp.temperature) {
        minTemp = reading;
      }
    }
    return minTemp;
  }

  public static Reading getMaxTemp(List<Reading> readings) {
    Reading maxTemp = readings.get(0);
    for (Reading reading : readings) {
      if (reading.temperature > maxTemp.temperature) {
        maxTemp = reading;
      }
    }
    return maxTemp;
  }

  public static Reading getMinPressure(List<Reading> readings) {
    Reading minPressure = readings.get(0);
    for (Reading reading : readings) {
      if (reading.pressure < minPressure.pressure) {
        minPressure = reading;
      }
    }
    return minPressure;
  }

  public static Reading getMaxPressure(List<Reading> readings) {
    Reading maxPressure = readings.get(0);
    for (Reading reading : readings) {
      if (reading.pressure > maxPressure.pressure) {
        maxPressure = reading;
      }
    }
    return maxPressure;
  }

  public static Reading getMinWindSpeed(List<Reading> readings) {
    Reading minWindSpeed = readings.get(0);
    for (Reading reading : readings) {
      if (reading.windSpeed < minWindSpeed.windSpeed) {
        minWindSpeed = reading;
      }
    }
    return minWindSpeed;
  }

  public static Reading getMaxWindSpeed(List<Reading> readings) {
    Reading maxWindSpeed = readings.get(0);
    for (Reading reading : readings) {
      if (reading.windSpeed > maxWindSpeed.windSpeed) {
        maxWindSpeed = reading;
      }
    }
    return maxWindSpeed;
  }


}
