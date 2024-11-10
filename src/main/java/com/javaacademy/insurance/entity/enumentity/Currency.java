package com.javaacademy.insurance.entity.enumentity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Currency {
  JPY("yen"),
  BRL("real");

  private final String name;
}
