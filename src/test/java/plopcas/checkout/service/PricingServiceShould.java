package plopcas.checkout.service;

import static org.assertj.core.api.Assertions.assertThat;
import java.io.File;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import plopcas.checkout.exception.PricingRulesNotFoundException;
import plopcas.checkout.exception.PricingRulesNotValidException;
import plopcas.checkout.model.Discount;
import plopcas.checkout.model.Item;
import plopcas.checkout.model.PricingRules;

public class PricingServiceShould {

  private PricingService pricingService;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void getPricingRulesFromFile() {
    pricingService =
        new PricingService(new File("src/test/resources/pricing_rules_ok.csv"));

    PricingRules expectedPricingRules = new PricingRules();
    expectedPricingRules.put("A", new Item("A", 50, new Discount(3, 20)));
    expectedPricingRules.put("B", new Item("B", 30, new Discount(2, 15)));
    expectedPricingRules.put("C", new Item("C", 20));
    expectedPricingRules.put("D", new Item("D", 15));

    PricingRules pricingRules = pricingService.getPricingRules();

    assertThat(pricingRules).isEqualTo(expectedPricingRules);
  }

  @Test(expected = PricingRulesNotFoundException.class)
  public void failWhenPricingRulesNotExist() {
    pricingService =
        new PricingService(new File("src/test/resources/pricing_rules_???.csv"));
    
    pricingService.getPricingRules();
  }

  @Test(expected = PricingRulesNotValidException.class)
  public void failWhenPricingRulesNotValid() {
    pricingService =
        new PricingService(new File("src/test/resources/pricing_rules_not_valid.csv"));
    
    pricingService.getPricingRules();
  }

}
