package com.javaacademy.insurance.service.calc.impl;

import com.javaacademy.insurance.contract.enums.TypeOfInsurance;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("brazil")
@SpringBootTest
class InsuranceCalcBrazilServiceTest {

  @Autowired
  private InsuranceCalcBrazilService calcBrazilService;

  @Test
  @DisplayName("Стоимость страховки при грабеже")
  void calculateCostInsuranceCaseOfRobbery() {
    BigDecimal result = calcBrazilService.costInsurance(BigDecimal.valueOf(50_000),
        TypeOfInsurance.PROTECTION_FROM_ROBBERY);
    BigDecimal expected = BigDecimal.valueOf(2_800).setScale(2, RoundingMode.HALF_EVEN);
    Assertions.assertEquals(expected, result);
  }

  @Test
  @DisplayName("Стоимость медицинской страховки")
  void calculateCostInsuranceCaseOfMedical() {
    BigDecimal result = calcBrazilService.costInsurance(BigDecimal.valueOf(200_000),
        TypeOfInsurance.MEDICAL_INSURANCE);
    BigDecimal expected = BigDecimal.valueOf(6_800).setScale(2, RoundingMode.HALF_EVEN);
    Assertions.assertEquals(expected, result);
  }
}