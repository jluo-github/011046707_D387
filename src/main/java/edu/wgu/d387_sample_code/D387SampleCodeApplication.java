package edu.wgu.d387_sample_code;


import edu.wgu.d387_sample_code.model.MyWelcomeMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class D387SampleCodeApplication {

  public static void main(String[] args) {

    SpringApplication.run(D387SampleCodeApplication.class, args);
    ExecutorService executor = Executors.newFixedThreadPool(4);


    MyWelcomeMessage messages = new MyWelcomeMessage();

    executor.execute(() -> {
      messages.welcome().getEnglishMessage();
      System.out.println(messages.welcome().getEnglishMessage() + " " + Thread.currentThread().getName());
    });

    executor.execute(() -> {
      messages.welcome().getFrenchMessage();
      System.out.println(messages.welcome().getFrenchMessage() + " " + Thread.currentThread().getName());
    });


  }
}




