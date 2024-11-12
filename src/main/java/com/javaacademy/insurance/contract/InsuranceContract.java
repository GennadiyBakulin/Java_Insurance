package com.javaacademy.insurance.contract;

import com.javaacademy.insurance.contract.enums.StatusContract;
import com.javaacademy.insurance.contract.enums.TypeOfInsurance;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
public class InsuranceContract {

  private final String number;
  private final BigDecimal costInsurance;
  private final BigDecimal amountOfCoverage;
  private final String currency;
  private final String fullName;
  private final String countryOfAction;
  private final TypeOfInsurance typeOfInsurance;
  @Setter
  private StatusContract statusContract = StatusContract.UNPAID;

}
