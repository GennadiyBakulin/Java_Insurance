package com.javaacademy.insurance.serviceimpl;

import com.javaacademy.insurance.entity.enumentity.TypeOfInsurance;
import com.javaacademy.insurance.service.InsuranceCalcService;
import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InsuranceCalcJapanService implements InsuranceCalcService {

  @Override
  public BigDecimal costInsurance(BigDecimal amountOfCoverage, TypeOfInsurance typeOfInsurance) {
    return switch (typeOfInsurance) {
      case MEDICAL_INSURANCE -> {
        BigDecimal cost = amountOfCoverage.multiply(BigDecimal.valueOf(0.015))
            .add(BigDecimal.valueOf(12_000));
        yield cost;
      }
      case PROTECTION_FROM_ROBBERY -> {
        BigDecimal cost = amountOfCoverage.multiply(BigDecimal.valueOf(0.01))
            .add(BigDecimal.valueOf(10_000));
        yield cost;
      }
    };
  }
}
