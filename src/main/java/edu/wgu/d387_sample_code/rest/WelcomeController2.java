////package edu.wgu.d387_sample_code.rest;
////
////import lombok.Getter;
////import lombok.Setter;
////import org.springframework.core.io.ClassPathResource;
////import org.springframework.web.bind.annotation.CrossOrigin;
////import org.springframework.web.bind.annotation.GetMapping;
////import org.springframework.web.bind.annotation.RequestMapping;
////import org.springframework.web.bind.annotation.RestController;
////
////import java.io.IOException;
////import java.io.InputStream;
////import java.util.Properties;
////import java.util.concurrent.ExecutorService;
////import java.util.concurrent.Executors;
////
////@CrossOrigin
////@RestController
////@RequestMapping("/room/reservation/v1")
////public class WelcomeController2 {
////
////  private ExecutorService executor = Executors.newFixedThreadPool(2);
////
////  private Properties enProperties = new Properties();
////  private Properties frProperties = new Properties();
//
////  private void welcomeBundle(String name, Properties properties) {
////    try {
////      InputStream stream = new ClassPathResource(name).getInputStream();
////      properties.load(stream);
////    } catch (IOException e) {
////      e.printStackTrace();
////    }
////  }
////
////  public WelcomeController2() {
////    welcomeBundle("welcome_en_US.properties", enProperties);
////    welcomeBundle("welcome_fr_CA.properties", frProperties);
////  }
////
////  @Setter
////  @Getter
////  public static class Message {
////    private String englishMessage;
////    private String frenchMessage;
////  }
////
////  @GetMapping("/welcome")
////
////  public Message welcome() {
////    Message message = new Message();
////
////    executor.execute(() -> {
////      message.setEnglishMessage(enProperties.getProperty("welcome"));
////    });
////
////    executor.execute(() -> {
////      message.setFrenchMessage(frProperties.getProperty("welcome"));
////    });
////
////    return message;
////  }
////
////} // class WelcomeController2

