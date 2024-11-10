package com.javaacademy.insurance.entity;

import com.javaacademy.insurance.entity.enumentity.Country;
import com.javaacademy.insurance.entity.enumentity.Currency;
import com.javaacademy.insurance.entity.enumentity.StatusContract;
import com.javaacademy.insurance.entity.enumentity.TypeOfInsurance;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class InsuranceContract {

  private final String number;
  private final BigDecimal costInsurance;
  private final BigDecimal amountOfCoverage;
  private final Currency currency;
  private final String fullName;
  private final Country countryOfAction;
  private final TypeOfInsurance typeOfInsurance;
  private StatusContract statusContract = StatusContract.UNPAID;

}
