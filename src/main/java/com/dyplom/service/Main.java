package com.dyplom.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Serhii Manko
 */
public class Main {

  public static void main(String[] args) {
    System.out.println(new BCryptPasswordEncoder().encode("gt64"));
  }
//$2a$10$5.WPDJFiUnYGf7CJSwr5i.2aGZmLWh2t95ZiLHOWFgbJJ.RVZnlpO
//$2a$10$Otl968OQHaWTwCKiIh5jbe302pMePHaAbb8.fpGmk74zHWO1/IClm
}
