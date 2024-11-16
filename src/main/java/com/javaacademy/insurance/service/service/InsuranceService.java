package com.javaacademy.insurance.service.service;

import com.javaacademy.insurance.contract.InsuranceContract;
import com.javaacademy.insurance.contract.enums.TypeOfInsurance;
import java.math.BigDecimal;

public interface InsuranceService {

  InsuranceContract issuingInsuranceOffer(
      BigDecimal amountOfCoverage, String fullName, TypeOfInsurance typeOfInsurance);

  InsuranceContract insurancePayment(String number);

}
