package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Member;
import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;

public class Dashboard extends Controller {
  public static void index() {
    Logger.info("Rendering Dashboard");
    Member member = Accounts.getLoggedInMember();
    List<Station> stations = Station.findAll();

    render("dashboard.html", stations);
  }

  public static void deleteStation(Long id) {
    Logger.info("Deleting a Station");
    Member member = Accounts.getLoggedInMember();
    Station station = Station.findById(id);
    member.stations.remove(station);
    member.save();
    station.delete();
    redirect("/dashboard");
  }

  public static void addStation(String title, double latitude, double longitude) {
    Logger.info("Adding Station");
    Member member = Accounts.getLoggedInMember();
    Station station = new Station(title, latitude, longitude);
    member.stations.add(station);
    member.save();
    redirect("/dashboard");
  }
}
