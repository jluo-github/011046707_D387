package edu.wgu.d387_sample_code.model;


import lombok.*;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.Properties;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MyWelcomeMessage {

  private String englishMessage;
  private String frenchMessage;

  public MyWelcomeMessage(String englishMessage, String frenchMessage) {
    this.englishMessage = englishMessage;
    this.frenchMessage = frenchMessage;
  }

  public void setEnglishMessage(String englishMessage) {
    this.englishMessage = englishMessage;
  }

  public String getEnglishMessage() {
    return englishMessage;
  }

  public void setFrenchMessage(String frenchMessage) {
    this.frenchMessage = frenchMessage;
  }

  public String getFrenchMessage() {
    return frenchMessage;
  }

  private Properties enProperties = new Properties();
  private Properties frProperties = new Properties();

  public MyWelcomeMessage welcome() {

    InputStream stream;
    try {
      stream = new ClassPathResource("welcome_en_US.properties").getInputStream();
      enProperties.load(stream);
      setEnglishMessage(enProperties.getProperty("welcome"));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    try {
      stream = new ClassPathResource("welcome_fr_CA.properties").getInputStream();
      frProperties.load(stream);
      setFrenchMessage(frProperties.getProperty("welcome"));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    return new MyWelcomeMessage(getEnglishMessage(), getFrenchMessage());
  }

}


