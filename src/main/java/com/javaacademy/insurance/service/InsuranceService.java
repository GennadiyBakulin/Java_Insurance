package com.javaacademy.insurance.service;

import com.javaacademy.insurance.entity.Archive;
import com.javaacademy.insurance.entity.InsuranceContract;
import com.javaacademy.insurance.entity.enumentity.StatusContract;
import com.javaacademy.insurance.entity.enumentity.TypeOfInsurance;
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
