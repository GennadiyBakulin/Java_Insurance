package com.javaacademy.insurance.contract.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Country {
  JAPAN("Japan"),
  BRAZIL("Brazil");
  private final String name;
}
