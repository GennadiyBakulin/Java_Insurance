package com.javaacademy.insurance.service.service.impl;

import com.javaacademy.insurance.contract.InsuranceContract;
import com.javaacademy.insurance.contract.enums.StatusContract;
import com.javaacademy.insurance.contract.enums.TypeOfInsurance;
import com.javaacademy.insurance.service.archive.Archive;
import com.javaacademy.insurance.service.calc.impl.InsuranceCalcJapanService;
import com.javaacademy.insurance.service.numbergenerator.ContractNumberGenerator;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("japan")
@SpringBootTest
class InsuranceServiceJapanTest {

  @Autowired
  private InsuranceServiceJapan serviceJapan;

  @MockBean
  private Archive archive;
  @MockBean
  private InsuranceCalcJapanService calcJapanService;
  @MockBean
  private ContractNumberGenerator numberGenerator;

  @Test
  @DisplayName("Получено предложение по страховке от грабежа")
  void getInsuranceOfferRobberyProtection() {
    Mockito.doReturn("001").when(numberGenerator).contractNumberGenerator();
    Mockito.doReturn(BigDecimal.valueOf(20_000).setScale(2, RoundingMode.HALF_EVEN))
        .when(calcJapanService)
        .costInsurance(BigDecimal.valueOf(1_000_000), TypeOfInsurance.PROTECTION_FROM_ROBBERY);
    InsuranceContract result = serviceJapan.issuingInsuranceOffer(
        BigDecimal.valueOf(1_000_000), "Иванов Иван Иванович",
        TypeOfInsurance.PROTECTION_FROM_ROBBERY);

    Assertions.assertEquals("001", result.getNumber());
    Assertions.assertEquals(BigDecimal.valueOf(20_000).setScale(2, RoundingMode.HALF_EVEN),
        result.getCostInsurance());
    Assertions.assertEquals(BigDecimal.valueOf(1_000_000), result.getAmountOfCoverage());
    Assertions.assertEquals("yen", result.getCurrency());
    Assertions.assertEquals("Иванов Иван Иванович", result.getFullName());
    Assertions.assertEquals("Japan", result.getCountryOfAction());
    Assertions.assertEquals(TypeOfInsurance.PROTECTION_FROM_ROBBERY, result.getTypeOfInsurance());
    Assertions.assertEquals(StatusContract.UNPAID, result.getStatusContract());
  }

  @Test
  @DisplayName("Получено предложение по медицинской страховке")
  void getInsuranceOfferMedicalProtection() {
    Mockito.doReturn("001").when(numberGenerator).contractNumberGenerator();
    Mockito.doReturn(BigDecimal.valueOf(162_000).setScale(2, RoundingMode.HALF_EVEN))
        .when(calcJapanService)
        .costInsurance(BigDecimal.valueOf(10_000_000), TypeOfInsurance.MEDICAL_INSURANCE);
    InsuranceContract result = serviceJapan.issuingInsuranceOffer(
        BigDecimal.valueOf(10_000_000), "Иванов Иван Иванович",
        TypeOfInsurance.MEDICAL_INSURANCE);

    Assertions.assertEquals("001", result.getNumber());
    Assertions.assertEquals(BigDecimal.valueOf(162_000).setScale(2, RoundingMode.HALF_EVEN),
        result.getCostInsurance());
    Assertions.assertEquals(BigDecimal.valueOf(10_000_000), result.getAmountOfCoverage());
    Assertions.assertEquals("yen", result.getCurrency());
    Assertions.assertEquals("Иванов Иван Иванович", result.getFullName());
    Assertions.assertEquals("Japan", result.getCountryOfAction());
    Assertions.assertEquals(TypeOfInsurance.MEDICAL_INSURANCE, result.getTypeOfInsurance());
    Assertions.assertEquals(StatusContract.UNPAID, result.getStatusContract());
  }

  @Test
  @DisplayName("Успешная оплата медицинской страховки")
  void paymentMedicalProtection() {
    Mockito.doReturn("001").when(numberGenerator).contractNumberGenerator();
    Mockito.doReturn(BigDecimal.valueOf(162_000).setScale(2, RoundingMode.HALF_EVEN))
        .when(calcJapanService)
        .costInsurance(BigDecimal.valueOf(10_000_000), TypeOfInsurance.MEDICAL_INSURANCE);
    InsuranceContract insuranceContract = new InsuranceContract(
        "001",
        BigDecimal.valueOf(162_000),
        BigDecimal.valueOf(10_000_000),
        "yen",
        "Иванов Иван Иванович",
        "Japan",
        TypeOfInsurance.MEDICAL_INSURANCE
    );
    Mockito.doReturn(Map.of("001", insuranceContract)).when(archive).getListContracts();
    InsuranceContract result = serviceJapan.insurancePayment("001");

    Assertions.assertEquals("001", result.getNumber());
    Assertions.assertEquals(BigDecimal.valueOf(162_000),
        result.getCostInsurance());
    Assertions.assertEquals(BigDecimal.valueOf(10_000_000), result.getAmountOfCoverage());
    Assertions.assertEquals("yen", result.getCurrency());
    Assertions.assertEquals("Иванов Иван Иванович", result.getFullName());
    Assertions.assertEquals("Japan", result.getCountryOfAction());
    Assertions.assertEquals(TypeOfInsurance.MEDICAL_INSURANCE, result.getTypeOfInsurance());
    Assertions.assertEquals(StatusContract.PAID, result.getStatusContract());
  }
}
