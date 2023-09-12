package edu.wgu.d387_sample_code.rest;

// todo: readme

import lombok.Getter;
import lombok.Setter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@CrossOrigin
@RestController
@RequestMapping("/room/reservation/v1")
public class WelcomeController {

  private ExecutorService executor = Executors.newFixedThreadPool(2);
  private Properties enProperties = new Properties();
  private Properties frProperties = new Properties();

  public WelcomeController() {
    loadResourceBundle("welcome_en_US.properties", enProperties);
    loadResourceBundle("welcome_fr_CA.properties", frProperties);
  }

  private void loadResourceBundle(String bundleName, Properties properties) {
    try {
      InputStream stream = new ClassPathResource(bundleName).getInputStream();
      properties.load(stream);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

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
      message.setEnglishMessage(enProperties.getProperty("welcome"));
    });

    executor.execute(() -> {
      message.setFrenchMessage(frProperties.getProperty("welcome"));
    });

    return message;
  }


}





