package com.javaacademy.insurance.serviceimpl;

import com.javaacademy.insurance.contract.InsuranceContract;
import com.javaacademy.insurance.contract.enums.Country;
import com.javaacademy.insurance.contract.enums.Currency;
import com.javaacademy.insurance.contract.enums.TypeOfInsurance;
import com.javaacademy.insurance.service.InsuranceService;
import com.javaacademy.insurance.utils.ContractNumberGenerator;
import java.math.BigDecimal;

public class InsuranceServiceBrazil implements InsuranceService {

  @Override
  public InsuranceContract issuingInsuranceOffer(BigDecimal amountOfCoverage, String fullName,
      TypeOfInsurance typeOfInsurance) {
    return new InsuranceContract(ContractNumberGenerator.contractNumberGenerator(),
        new InsuranceCalcJapanService().costInsurance(amountOfCoverage, typeOfInsurance),
        amountOfCoverage,
        Currency.BRL,
        fullName,
        Country.BRAZIL,
        typeOfInsurance);
  }

}
