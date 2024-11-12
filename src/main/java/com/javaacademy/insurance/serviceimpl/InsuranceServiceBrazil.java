package com.javaacademy.insurance.serviceimpl;

import com.javaacademy.insurance.contract.InsuranceContract;
import com.javaacademy.insurance.contract.enums.TypeOfInsurance;
import com.javaacademy.insurance.data.CountryData;
import com.javaacademy.insurance.service.InsuranceService;
import com.javaacademy.insurance.utils.ContractNumberGenerator;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;

@Profile("brazil")
@RequiredArgsConstructor
public class InsuranceServiceBrazil implements InsuranceService {

  private final InsuranceCalcBrazilService calcBrazilService;
  private final CountryData data;

  @Override
  public InsuranceContract issuingInsuranceOffer(BigDecimal amountOfCoverage, String fullName,
      TypeOfInsurance typeOfInsurance) {
    return new InsuranceContract(ContractNumberGenerator.contractNumberGenerator(),
        calcBrazilService.costInsurance(amountOfCoverage, typeOfInsurance),
        amountOfCoverage,
        data.getCurrency(),
        fullName,
        data.getName(),
        typeOfInsurance);
  }

}
