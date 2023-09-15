package edu.wgu.d387_sample_code.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@CrossOrigin
@RestController
@RequestMapping("/room/reservation/v1")
public class TimeController {

  ZoneId zoneId = ZoneId.systemDefault();
  // Get the current time
  LocalDateTime localDateTime = LocalDateTime.now();

  ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);

  public String threeTimeZones() {
    // Define the time zones
    ZoneId zEastern = ZoneId.of("America/New_York");
    ZoneId zMountain = ZoneId.of("America/Denver");
    ZoneId zUTC = ZoneId.of("UTC");

    ZoneId zoneId = ZoneId.systemDefault();
    // Get the current time
    LocalDateTime localDateTime = LocalDateTime.now();

    ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);

    // Convert to Eastern Time
    ZonedDateTime zonedDateTimeEastern = zonedDateTime.withZoneSameInstant(zEastern);
    LocalDateTime localDateTimeEastern = zonedDateTimeEastern.toLocalDateTime();
    String easternTime = zonedDateTimeEastern.format(DateTimeFormatter.ofPattern("HH:mm a")) + " " + "Eastern Time " +
        "(ET)";

    // Convert to Mountain Time
    ZonedDateTime zonedDateTimeMountain = zonedDateTime.withZoneSameInstant(zMountain);
    LocalDateTime localDateTimeMountain = zonedDateTimeMountain.toLocalDateTime();

    String mountainTime = zonedDateTimeMountain.format(DateTimeFormatter.ofPattern("HH:mm a")) + " " + "Mountain " +
        "Time (MT)";
    // Convert to Coordinated Universal Time (UTC)

    ZonedDateTime zonedDateTimeUTC = zonedDateTime.withZoneSameInstant(zUTC);
    LocalDateTime localDateTimeUTC = zonedDateTimeUTC.toLocalDateTime();

    String utcTime = zonedDateTimeUTC.format(DateTimeFormatter.ofPattern("HH:mm a")) + " " + "Coordinated Universal " +
        "Time (UTC)";

    String result = "\n" +
        easternTime + "\n" +
        mountainTime + "\n" +
        utcTime;
    System.out.println(result);
    return result;
  }


  @GetMapping("/time")
  public String time() {
    return threeTimeZones();
  }


}
