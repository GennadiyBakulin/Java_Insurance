package com.javaacademy.insurance.service;

import com.javaacademy.insurance.entity.enumentity.TypeOfInsurance;
import java.math.BigDecimal;

public interface InsuranceCalcService {

  BigDecimal costInsurance(BigDecimal amountOfCoverage, TypeOfInsurance typeOfInsurance);
}
