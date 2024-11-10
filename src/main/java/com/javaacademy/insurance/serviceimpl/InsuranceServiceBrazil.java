package com.javaacademy.insurance.serviceimpl;

import com.javaacademy.insurance.entity.InsuranceContract;
import com.javaacademy.insurance.entity.enumentity.Country;
import com.javaacademy.insurance.entity.enumentity.Currency;
import com.javaacademy.insurance.entity.enumentity.TypeOfInsurance;
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
