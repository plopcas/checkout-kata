package plopcas.checkout.service;

import java.io.File;
import plopcas.checkout.model.Discount;
import plopcas.checkout.model.Item;
import plopcas.checkout.model.PricingRules;

public class PricingService {

  private File pricingRulesFile;

  public PricingService(File pricingRulesFile) {
    this.pricingRulesFile = pricingRulesFile;
  }

  public PricingRules getPricingRules() {
    PricingRules pricingRules = new PricingRules();
    pricingRules.put("A", new Item("A", 50, new Discount(3, 20)));
    pricingRules.put("B", new Item("B", 30, new Discount(2, 15)));
    pricingRules.put("C", new Item("C", 20));
    pricingRules.put("D", new Item("D", 15));
    return pricingRules;
  }

}
