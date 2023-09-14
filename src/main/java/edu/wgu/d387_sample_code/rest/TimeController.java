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

  @GetMapping("/time")

  public String time() {
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
    String easternTime = formatTime(zonedDateTimeEastern, "Eastern Time (ET)");

    // Convert to Mountain Time
    ZonedDateTime zonedDateTimeMountain = zonedDateTime.withZoneSameInstant(zMountain);
    LocalDateTime localDateTimeMountain = zonedDateTimeMountain.toLocalDateTime();
    String mountainTime = formatTime(zonedDateTimeMountain, "Mountain Time (MT)");

    // Convert to Coordinated Universal Time (UTC)

    ZonedDateTime zonedDateTimeUTC = zonedDateTime.withZoneSameInstant(zUTC);
    LocalDateTime localDateTimeUTC = zonedDateTimeUTC.toLocalDateTime();
    String utcTime = formatTime(zonedDateTimeUTC, "Coordinated Universal Time (UTC)");

    // Construct a single string containing all times
    String result = "Online Live Presentation Time:\n" +
        "ET: " + easternTime + "\n" +
        "MT: " + mountainTime + "\n" +
        "UTC: " + utcTime;
    System.out.println(result);
    return result;
  }

  private String formatTime(ZonedDateTime zonedDateTimeEastern, String timeZone) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    return zonedDateTime.format(formatter) + " " + timeZone;
  }
}
