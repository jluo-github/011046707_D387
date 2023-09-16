package edu.wgu.d387_sample_code.rest;

// todo: readme

import edu.wgu.d387_sample_code.MyWelcomeMessage;
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

  private ExecutorService executor = Executors.newFixedThreadPool(2);
  private Properties enProperties = new Properties();
  private Properties frProperties = new Properties();

  MyWelcomeMessage message = new MyWelcomeMessage();

  public MyWelcomeMessage welcome() {

    executor.execute(() -> {
      try {
        InputStream stream = new ClassPathResource("welcome_en_US.properties").getInputStream();
        enProperties.load(stream);
        System.out.println(enProperties.getProperty("welcome") + " " + Thread.currentThread().getName());
        message.setEnglishMessage(enProperties.getProperty("welcome") + " " + Thread.currentThread().getName());
      } catch (Exception e) {
        e.printStackTrace();
      }
    });

    executor.execute(() -> {
      try {
        InputStream stream = new ClassPathResource("welcome_fr_CA.properties").getInputStream();
        frProperties.load(stream);
        System.out.println(frProperties.getProperty("welcome") + " " + Thread.currentThread().getName());
        message.setFrenchMessage(frProperties.getProperty("welcome") + " " + Thread.currentThread().getName());

      } catch (Exception e) {
        e.printStackTrace();
      }
    });

    return message;
  }


  @GetMapping("welcome/en")
  public String getMessage() {
    System.out.println("English message: " + welcome().getEnglishMessage());
    return welcome().getEnglishMessage();
  }

  @GetMapping("welcome/fr")
  public String getFrenchMessage() {
    System.out.println("French message: " + welcome().getFrenchMessage());
    return welcome().getFrenchMessage();
  }


}





