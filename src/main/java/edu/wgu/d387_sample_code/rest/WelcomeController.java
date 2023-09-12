package edu.wgu.d387_sample_code.rest;

// todo: readme

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
  private Properties englishProperties = new Properties();
  private Properties frenchProperties = new Properties();

  public WelcomeController() {
    loadResourceBundle("welcome_en_US.properties", englishProperties);
    loadResourceBundle("welcome_fr_CA.properties", frenchProperties);
  }

  private void loadResourceBundle(String bundleName, Properties properties) {
    try {
      InputStream stream = new ClassPathResource(bundleName).getInputStream();
      properties.load(stream);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @GetMapping("/welcome")

  public WelcomeMessages welcome() {
    WelcomeMessages messages = new WelcomeMessages();

    executor.execute(() -> {
      messages.setEnglishMessage(englishProperties.getProperty("welcome"));
    });

    executor.execute(() -> {
      messages.setFrenchMessage(frenchProperties.getProperty("welcome"));
    });

    return messages;
  }

  public static class WelcomeMessages {
    private String englishMessage;
    private String frenchMessage;

    public String getEnglishMessage() {
      return englishMessage;
    }

    public void setEnglishMessage(String englishMessage) {
      this.englishMessage = englishMessage;
    }

    public String getFrenchMessage() {
      return frenchMessage;
    }

    public void setFrenchMessage(String frenchMessage) {
      this.frenchMessage = frenchMessage;
    }
  }
}





