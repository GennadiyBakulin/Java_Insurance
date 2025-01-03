package com.javaacademy.insurance.service.service.impl;

import com.javaacademy.insurance.contract.InsuranceContract;
import com.javaacademy.insurance.contract.enums.StatusContract;
import com.javaacademy.insurance.contract.enums.TypeOfInsurance;
import com.javaacademy.insurance.service.archive.Archive;
import com.javaacademy.insurance.service.calc.impl.InsuranceCalcBrazilService;
import com.javaacademy.insurance.service.numbergenerator.ContractNumberGenerator;
import com.javaacademy.insurance.service.service.InsuranceService;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("brazil")
@Component
@RequiredArgsConstructor
public class InsuranceServiceBrazil implements InsuranceService {

  private final Archive archive;
  private final InsuranceCalcBrazilService calcBrazilService;
  private final ContractNumberGenerator numberGenerator;

  @Value("${name}")
  private String nameCountry;
  @Value("${currency}")
  private String nameCurrency;

  @Override
  public InsuranceContract issuingInsuranceOffer(BigDecimal amountOfCoverage, String fullName,
      TypeOfInsurance typeOfInsurance) {
    InsuranceContract insuranceContract = new InsuranceContract(
        numberGenerator.contractNumberGenerator(),
        calcBrazilService.costInsurance(amountOfCoverage, typeOfInsurance),
        amountOfCoverage,
        nameCurrency,
        fullName,
        nameCountry,
        typeOfInsurance);
    archive.addContractToArchive(insuranceContract);
    return insuranceContract;
  }

  @Override
  public InsuranceContract insurancePayment(String number) {
    if (archive.getListContracts().containsKey(number)) {
      InsuranceContract contract = archive.getListContracts().get(number);
      contract.setStatusContract(StatusContract.PAID);
      return contract;
    }
    throw new RuntimeException("Договора №%s не существует!".formatted(number));
  }
}
