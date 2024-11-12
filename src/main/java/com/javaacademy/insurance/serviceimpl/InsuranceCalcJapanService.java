package com.javaacademy.insurance.serviceimpl;

import com.javaacademy.insurance.contract.enums.TypeOfInsurance;
import com.javaacademy.insurance.data.CountryData;
import com.javaacademy.insurance.service.InsuranceCalcService;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("japan")
@Component
@RequiredArgsConstructor
public class InsuranceCalcJapanService implements InsuranceCalcService {

  private final CountryData data;

  @Override
  public BigDecimal costInsurance(BigDecimal amountOfCoverage, TypeOfInsurance typeOfInsurance) {
    return switch (typeOfInsurance) {
      case MEDICAL_INSURANCE -> amountOfCoverage.multiply(data.getMedical().get("ratio"))
          .add(data.getMedical().get("adding"));

      case PROTECTION_FROM_ROBBERY -> amountOfCoverage.multiply(data.getRobbery().get("ratio"))
          .add(data.getRobbery().get("adding"));
    };
  }
}
