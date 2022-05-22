package models;

import java.util.*;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Station extends Model {
  public String title;
  public double latitude;
  public double longitude;
  @OneToMany(cascade = CascadeType.ALL)
  public List<Reading> readings = new ArrayList<Reading>();

  public Station(String title, double latitude, double longitude) {
    this.title = title;
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public double convertTemp;
  public double calculateWindChill;
  public String convertWindSpeed;
  public String convertWindDirection;
  public String weatherCode;
  public double minTempValue;
  public double maxTempValue;
  public double minPressureValue;
  public double maxPressureValue;
  public double minWindSpeedValue;
  public double maxWindSpeedValue;

  public double tempC;
  public int pressure;


}
