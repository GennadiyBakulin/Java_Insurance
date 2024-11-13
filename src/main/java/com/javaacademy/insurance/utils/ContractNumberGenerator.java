package com.javaacademy.insurance.utils;

import org.springframework.stereotype.Component;

@Component
public class ContractNumberGenerator {

  private int countContracts;

  public String contractNumberGenerator() {

    return String.format("%03d", ++countContracts);
  }
}
