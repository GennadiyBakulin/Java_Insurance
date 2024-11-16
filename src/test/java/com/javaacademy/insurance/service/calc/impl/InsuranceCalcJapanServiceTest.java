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

@ActiveProfiles("japan")
@SpringBootTest
class InsuranceCalcJapanServiceTest {

  @Autowired
  private InsuranceCalcJapanService calcJapanService;

  @Test
  @DisplayName("Стоимость страховки при грабеже")
  void calculateCostInsuranceCaseOfRobbery() {
    BigDecimal result = calcJapanService.costInsurance(BigDecimal.valueOf(1_000_000),
        TypeOfInsurance.PROTECTION_FROM_ROBBERY);
    BigDecimal expected = BigDecimal.valueOf(20_000).setScale(2, RoundingMode.HALF_EVEN);
    Assertions.assertEquals(expected, result);
  }

  @Test
  @DisplayName("Стоимость медицинской страховки")
  void calculateCostInsuranceCaseOfMedical() {
    BigDecimal result = calcJapanService.costInsurance(BigDecimal.valueOf(10_000_000),
        TypeOfInsurance.MEDICAL_INSURANCE);
    BigDecimal expected = BigDecimal.valueOf(162_000).setScale(2, RoundingMode.HALF_EVEN);
    Assertions.assertEquals(expected, result);
  }
}