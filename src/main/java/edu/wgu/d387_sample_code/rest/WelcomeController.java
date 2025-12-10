package edu.wgu.d387_sample_code.rest;

// todo: readme

import edu.wgu.d387_sample_code.model.MyWelcomeMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/room/reservation/v1")
public class WelcomeController {

  MyWelcomeMessage message = new MyWelcomeMessage();

  @GetMapping("welcome/en")
  public String getMessage() {
    System.out.println("English message: " + message.welcome().getEnglishMessage());
    return message.getEnglishMessage();
  }

  @GetMapping("welcome/fr")
  public String getFrenchMessage() {
    System.out.println("French message: " + message.welcome().getFrenchMessage());
    return message.getFrenchMessage();
  }

}





