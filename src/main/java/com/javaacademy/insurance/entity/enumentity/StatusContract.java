package com.javaacademy.insurance.entity.enumentity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum StatusContract {
  PAID("оплаченный договор"),
  UNPAID("неоплаченный договор");
  private final String status;
}
