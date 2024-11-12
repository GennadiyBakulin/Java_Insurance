package com.javaacademy.insurance.contract.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Currency {
  JPY("yen"),
  BRL("real");
  private final String name;
}
