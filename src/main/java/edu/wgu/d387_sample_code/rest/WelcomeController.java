package edu.wgu.d387_sample_code.rest;

// todo: readme

import lombok.Getter;
import lombok.Setter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@CrossOrigin
@RestController
@RequestMapping("/room/reservation/v1")
public class WelcomeController {

  private ExecutorService executor = Executors.newFixedThreadPool(3);
  private Properties enProperties = new Properties();
  private Properties frProperties = new Properties();

  @Setter
  @Getter
  public static class Message {
    private String englishMessage;
    private String frenchMessage;
  }

  @GetMapping("/welcome")
  public Message welcome() {
    Message message = new Message();

    executor.execute(() -> {
      try {
        InputStream stream = new ClassPathResource("welcome_en_US.properties").getInputStream();
        enProperties.load(stream);
        message.setEnglishMessage(enProperties.getProperty("welcome") + " " + Thread.currentThread().getName());
      } catch (Exception e) {
        e.printStackTrace();
      }
    });

    executor.execute(() -> {
      try {
        InputStream stream = new ClassPathResource("welcome_fr_CA.properties").getInputStream();
        frProperties.load(stream);
        message.setFrenchMessage(frProperties.getProperty("welcome") + " " + Thread.currentThread().getName());

      } catch (Exception e) {
        e.printStackTrace();
      }
    });

    return message;
  }


}





