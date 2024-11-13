package com.javaacademy.insurance.archive;

import com.javaacademy.insurance.contract.InsuranceContract;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Archive {

  private final Map<String, InsuranceContract> listContracts = new HashMap<>();

  public void addContractToArchive(InsuranceContract contract) {
    listContracts.put(contract.getNumber(), contract);
  }
}
