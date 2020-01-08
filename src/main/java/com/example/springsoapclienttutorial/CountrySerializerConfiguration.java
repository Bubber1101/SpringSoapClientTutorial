package com.example.springsoapclienttutorial;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CountrySerializerConfiguration {

  @Bean
  public Jaxb2Marshaller marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setContextPath("com.example.springsoapclienttutorial.wsdl");
    return marshaller;
  }

  @Bean
  public CountryClient countryClient(Jaxb2Marshaller marshaller) {
    CountryClient client = new CountryClient();
    client.setDefaultUri("http://localhost:8080/ws");
    client.setMarshaller(marshaller);
    client.setUnmarshaller(marshaller);
    return client;
  }

}
