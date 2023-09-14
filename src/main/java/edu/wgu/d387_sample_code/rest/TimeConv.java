package edu.wgu.d387_sample_code.rest;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeConv {
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


  // Convert to Mountain Time
  ZonedDateTime zonedDateTimeMountain = zonedDateTime.withZoneSameInstant(zMountain);
  LocalDateTime localDateTimeMountain = zonedDateTimeMountain.toLocalDateTime();


  // Convert to Coordinated Universal Time (UTC)

  ZonedDateTime zonedDateTimeUTC = zonedDateTime.withZoneSameInstant(zUTC);
  LocalDateTime localDateTimeUTC = zonedDateTimeUTC.toLocalDateTime();

  private static String formatTime(ZonedDateTime zonedDateTime, String timeZone) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    return zonedDateTime.format(formatter) + " " + timeZone;
  }
  
}
