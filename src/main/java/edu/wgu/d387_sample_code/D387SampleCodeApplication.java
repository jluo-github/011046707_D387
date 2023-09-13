package edu.wgu.d387_sample_code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

@SpringBootApplication
public class D387SampleCodeApplication {

  static ExecutorService messageExecutor = newFixedThreadPool(5);

  public static void main(String[] args) {

    SpringApplication.run(D387SampleCodeApplication.class, args);

    Properties properties = new Properties();
//    messageExecutor.execute(() -> {
//      try {
//        InputStream stream = new ClassPathResource("welcome_en_US.properties").getInputStream();
//        properties.load(stream);
//
//        System.out.println(properties.getProperty("welcome"));
//      } catch (Exception e) {
//        e.printStackTrace();
//      }
//    });
//
//    messageExecutor.execute(() -> {
//      try {
//        InputStream stream = new ClassPathResource("welcome_fr_CA.properties").getInputStream();
//        properties.load(stream);
//
//        System.out.println(properties.getProperty("welcome"));
//      } catch (Exception e) {
//        e.printStackTrace();
//      }
//    });


//    ZoneId zEastern = ZoneId.of("America/New_York");
//
//    ZoneId zPacific = ZoneId.of("America/Los_Angeles");
//    ZoneId zoneId = ZoneId.systemDefault();
//
//    LocalDateTime localDateTime = LocalDateTime.now();
//    System.out.println("local time now: " + localDateTime.toString());
//
//    ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
//
//    ZonedDateTime zonedDateTimeEastern = zonedDateTime.withZoneSameInstant(zEastern);
//    LocalDateTime localDateTimeEastern = zonedDateTimeEastern.toLocalDateTime();
//    System.out.println("local time now in Eastern: " + localDateTimeEastern.toString());
//
//    ZonedDateTime zonedDateTimePacific = zonedDateTime.withZoneSameInstant(zPacific);
//    LocalDateTime localDateTimePacific = zonedDateTimePacific.toLocalDateTime();
//    System.out.println("local time now in Pacific time " + localDateTimePacific.toString());

  }
}
