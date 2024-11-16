package com.javaacademy.insurance.service.calc.impl;

import com.javaacademy.insurance.contract.enums.TypeOfInsurance;
import com.javaacademy.insurance.service.calc.InsuranceCalcService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("brazil")
@Component
@RequiredArgsConstructor
public class InsuranceCalcBrazilService implements InsuranceCalcService {

  @Value("${medical.ratio}")
  private BigDecimal medicalRatio;
  @Value("${medical.adding}")
  private BigDecimal medicalAdding;

  @Value("${robbery.ratio}")
  private BigDecimal robberyRatio;
  @Value("${robbery.adding}")
  private BigDecimal robberyAdding;

  @Override
  public BigDecimal costInsurance(BigDecimal amountOfCoverage, TypeOfInsurance typeOfInsurance) {
    return switch (typeOfInsurance) {
      case MEDICAL_INSURANCE -> amountOfCoverage.multiply(medicalRatio).add(medicalAdding)
          .setScale(2, RoundingMode.HALF_EVEN);
      case PROTECTION_FROM_ROBBERY -> amountOfCoverage.multiply(robberyRatio).add(robberyAdding)
          .setScale(2, RoundingMode.HALF_EVEN);
    };
  }
}
