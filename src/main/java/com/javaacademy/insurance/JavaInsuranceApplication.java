package com.javaacademy.insurance;

import com.javaacademy.insurance.contract.InsuranceContract;
import com.javaacademy.insurance.contract.enums.TypeOfInsurance;
import com.javaacademy.insurance.service.calc.impl.InsuranceCalcJapanService;
import com.javaacademy.insurance.service.service.impl.InsuranceServiceJapan;
import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
public class JavaInsuranceApplication {

  private static final BigDecimal BILLIARD = BigDecimal.valueOf(1_000_000);
  private static final BigDecimal TEN_BILLIARD = BigDecimal.valueOf(10_000_000);

  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(JavaInsuranceApplication.class,
        args);

    log.info("-----------------Japan---------------------");
    log.info("Рассчитать стоимость страховки при грабеже, "
        + "сумма покрытия 1 000 000. Ожидаемая стоимость: 20 000");
    InsuranceCalcJapanService calcJapanService = context.getBean(InsuranceCalcJapanService.class);
    log.info(calcJapanService.costInsurance(
        BILLIARD,
        TypeOfInsurance.PROTECTION_FROM_ROBBERY).toString());
    log.info("-----------------Japan---------------------");
    log.info("Рассчитать стоимость страховки при мед страховке, "
        + "сумма покрытия 10 000 000. Ожидаемая стоимость: 162 000");
    log.info(calcJapanService.costInsurance(
        TEN_BILLIARD,
        TypeOfInsurance.MEDICAL_INSURANCE).toString());

//    log.info("----------------Brazil----------------------");
//    log.info("Рассчитать стоимость страховки при грабеже, сумма покрытия 50 000. "
//        + "Ожидаемая стоимость: 2800");
//    InsuranceCalcBrazilService calcBrazilService = context.getBean(
//        InsuranceCalcBrazilService.class);
//    log.info(calcBrazilService.costInsurance(BigDecimal.valueOf(50000),
//        TypeOfInsurance.PROTECTION_FROM_ROBBERY).toString());
//    log.info("----------------Brazil----------------------");
//    log.info("Рассчитать стоимость страховки при мед страховке, "
//        + "сумма покрытия 200 000. Ожидаемая стоимость: 6800");
//    log.info(calcBrazilService.costInsurance(BigDecimal.valueOf(200000),
//        TypeOfInsurance.MEDICAL_INSURANCE).toString());

    log.info("-----------------Japan---------------------");
    log.info("Получить предложение по страховке, на вход: Иванов Иван Иванович, "
        + "сумма покрытия 1 000 000, тип - от грабежа");
    InsuranceServiceJapan serviceJapan = context.getBean(InsuranceServiceJapan.class);
    InsuranceContract contractMedicalJapan = serviceJapan.issuingInsuranceOffer(
        BILLIARD,
        "Иванов Иван Иванович",
        TypeOfInsurance.PROTECTION_FROM_ROBBERY);
    log.info(contractMedicalJapan.toString());
    log.info("На выход из метода оплаты страховки получаем:");
    log.info(serviceJapan.insurancePayment("001").toString());

    log.info("-----------------Japan---------------------");
    log.info("Получить предложение по страховке, на вход: Петров Петр Петрович, "
        + "сумма покрытия 1 000 000, тип - от грабежа");
    InsuranceContract contractMedicalJapan2 = serviceJapan.issuingInsuranceOffer(
        BILLIARD,
        "Петров Петр Петрович",
        TypeOfInsurance.PROTECTION_FROM_ROBBERY);
    log.info(contractMedicalJapan2.toString());
    log.info("На выход из метода оплаты страховки получаем:");
    log.info(serviceJapan.insurancePayment("002").toString());
    context.close();
  }
}
