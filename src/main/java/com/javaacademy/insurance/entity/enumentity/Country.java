package com.javaacademy.insurance.entity.enumentity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Country {
  JAPAN("Japan"),
  BRAZIL("Brazil");
  private final String name;
}
