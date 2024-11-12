package com.javaacademy.insurance.data;

import java.math.BigDecimal;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "country")
@Getter
@Setter
public class CountryData {

  private String name;
  private String currency;
  private Map<String, BigDecimal> robbery;
  private Map<String, BigDecimal> medical;

}
