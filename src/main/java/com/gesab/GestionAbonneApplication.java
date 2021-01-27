package com.gesab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import com.gesab.services.IAbonneService;

 
@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class GestionAbonneApplication implements CommandLineRunner {
  
@Autowired
    private IAbonneService myService ;
public static void main(String[]args) throws Exception {

	
	 SpringApplication.run(GestionAbonneApplication.class, args);

 }

 @Override
 public void run(String... args) throws Exception {
 
//    myService.createAbonne("s", "z", "z");   
//    myService.addContrat(1, "france");
//    myService.updateAdress(1, "inter");
     }

}

