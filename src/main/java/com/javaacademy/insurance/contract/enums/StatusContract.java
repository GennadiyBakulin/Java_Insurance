package com.javaacademy.insurance.contract.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum StatusContract {
  PAID("оплаченный договор"),
  UNPAID("неоплаченный договор");
  private final String status;
}
