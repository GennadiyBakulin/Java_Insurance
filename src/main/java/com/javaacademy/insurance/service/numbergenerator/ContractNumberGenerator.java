package com.javaacademy.insurance.service.numbergenerator;

import org.springframework.stereotype.Component;

@Component
public class ContractNumberGenerator {

  private int countContracts;

  public String contractNumberGenerator() {

    return String.format("%03d", ++countContracts);
  }
}
