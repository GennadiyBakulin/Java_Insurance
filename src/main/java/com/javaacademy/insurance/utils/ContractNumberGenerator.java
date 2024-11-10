package com.javaacademy.insurance.utils;

public class ContractNumberGenerator {

  private static int countContracts;

  public static String contractNumberGenerator() {

    return String.format("%08d", countContracts++);
  }
}
