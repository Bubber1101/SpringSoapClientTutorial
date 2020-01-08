package com.example.springsoapclienttutorial;

import com.example.springsoapclienttutorial.wsdl.GetCountryRequest;
import com.example.springsoapclienttutorial.wsdl.GetCountryResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

@Slf4j
public class CountryClient extends WebServiceGatewaySupport {

  GetCountryResponse getCountry(String country) {

    GetCountryRequest request = new GetCountryRequest();
    request.setName(country);

    log.info("Requesting location for " + country);

    GetCountryResponse response =
        (GetCountryResponse)
            getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/countries", request);

    return response;
  }
}
