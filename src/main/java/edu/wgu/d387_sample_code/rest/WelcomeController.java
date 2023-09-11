package edu.wgu.d387_sample_code.rest;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

@CrossOrigin
@RestController
//todo: 1. add the correct path
@RequestMapping("/room/reservation/v1")
public class WelcomeController {

  private ExecutorService executor = newFixedThreadPool(2);

  @GetMapping("/welcome")
  public Properties welcome() {
    Properties properties = new Properties();
    executor.execute(() -> {
      try {
        InputStream stream = new ClassPathResource("welcome_en_US.properties").getInputStream();
        properties.load(stream);
//        stream = new ClassPathResource("welcome_en_US.properties").getInputStream();
//        properties.load(stream);
//        stream = new ClassPathResource("welcome_en_US.properties").getInputStream();
//        properties.load(stream);
        System.out.println(properties.getProperty("welcome"));
        System.out.println("WelcomeController.welcome.english");
      } catch (Exception e) {
        e.printStackTrace();
      }
    });

    executor.execute(() -> {
      try {
        InputStream stream = new ClassPathResource("welcome_fr_CA.properties").getInputStream();
        properties.load(stream);
//        stream = new ClassPathResource("welcome_fr_CA.properties").getInputStream();
//        properties.load(stream);
//        stream = new ClassPathResource("welcome_fr_CA.properties").getInputStream();
//        properties.load(stream);

        System.out.println(properties.getProperty("welcome"));
        System.out.println("WelcomeController.welcome.french");
      } catch (Exception e) {
        e.printStackTrace();
      }

    });

    return properties;

  }

}
