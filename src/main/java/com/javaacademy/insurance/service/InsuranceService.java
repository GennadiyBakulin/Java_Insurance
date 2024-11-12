package com.javaacademy.insurance.service;

import com.javaacademy.insurance.archive.Archive;
import com.javaacademy.insurance.contract.InsuranceContract;
import com.javaacademy.insurance.contract.enums.StatusContract;
import com.javaacademy.insurance.contract.enums.TypeOfInsurance;
import java.math.BigDecimal;

public interface InsuranceService {

  InsuranceContract issuingInsuranceOffer(
      BigDecimal amountOfCoverage, String fullName, TypeOfInsurance typeOfInsurance);

  default InsuranceContract insurancePayment(String number) {
    if (Archive.LIST_CONTRACTS.containsKey(number)) {
      InsuranceContract contract = Archive.LIST_CONTRACTS.get(number);
      contract.setStatusContract(StatusContract.PAID);
      return contract;
    }
    throw new RuntimeException("Договора №%s не существует!".formatted(number));
  }

}
