package com.javaacademy.insurance.serviceimpl;

import com.javaacademy.insurance.archive.Archive;
import com.javaacademy.insurance.contract.InsuranceContract;
import com.javaacademy.insurance.contract.enums.StatusContract;
import com.javaacademy.insurance.contract.enums.TypeOfInsurance;
import com.javaacademy.insurance.data.CountryData;
import com.javaacademy.insurance.service.InsuranceService;
import com.javaacademy.insurance.utils.ContractNumberGenerator;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("brazil")
@Component
@RequiredArgsConstructor
public class InsuranceServiceBrazil implements InsuranceService {

  private final Archive archive;
  private final InsuranceCalcBrazilService calcBrazilService;
  private final ContractNumberGenerator numberGenerator;
  private final CountryData data;

  @Override
  public InsuranceContract issuingInsuranceOffer(BigDecimal amountOfCoverage, String fullName,
      TypeOfInsurance typeOfInsurance) {
    InsuranceContract insuranceContract = new InsuranceContract(
        numberGenerator.contractNumberGenerator(),
        calcBrazilService.costInsurance(amountOfCoverage, typeOfInsurance),
        amountOfCoverage,
        data.getCurrency(),
        fullName,
        data.getName(),
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
