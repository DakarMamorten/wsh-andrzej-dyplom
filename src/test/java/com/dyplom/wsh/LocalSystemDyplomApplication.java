package com.dyplom.wsh;

import com.dyplom.WshAndrzejDyplomApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

 public class LocalSystemDyplomApplication {
   
  public static void main(String[] args) {
    new SpringApplicationBuilder(WshAndrzejDyplomApplication.class)
        .initializers(new StandaloneApplicationContextInitializer())
        .profiles("dev")
        .run(args);
  }
  
}
