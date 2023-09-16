package edu.wgu.d387_sample_code.model;


import lombok.Data;

@Data
public class MyWelcomeMessage {

  private String englishMessage;
  private String frenchMessage;

  public MyWelcomeMessage() {
  }

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

}


