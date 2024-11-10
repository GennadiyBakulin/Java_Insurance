package com.javaacademy.insurance.entity.enumentity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TypeOfInsurance {
  MEDICAL_INSURANCE("медицинское страхование"),
  PROTECTION_FROM_ROBBERY("защита от грабежа");
  private final String type;
}
