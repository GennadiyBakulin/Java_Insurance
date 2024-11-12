package com.javaacademy.insurance.serviceimpl;

import com.javaacademy.insurance.contract.enums.TypeOfInsurance;
import com.javaacademy.insurance.service.InsuranceCalcService;
import java.math.BigDecimal;
import org.springframework.context.annotation.Profile;

@Profile("Brazil")
public class InsuranceCalcBrazilService implements InsuranceCalcService {

  @Override
  public BigDecimal costInsurance(BigDecimal amountOfCoverage, TypeOfInsurance typeOfInsurance) {
    return switch (typeOfInsurance) {
      case MEDICAL_INSURANCE -> {
        BigDecimal cost = amountOfCoverage.multiply(BigDecimal.valueOf(0.03))
            .add(BigDecimal.valueOf(800));
        yield cost;
      }
      case PROTECTION_FROM_ROBBERY -> {
        BigDecimal cost = amountOfCoverage.multiply(BigDecimal.valueOf(0.05))
            .add(BigDecimal.valueOf(300));
        yield cost;
      }
    };
  }
}
