package plopcas.checkout.service;

import java.io.File;
import plopcas.checkout.model.PricingRules;

public class PricingService {

  private File pricingRulesFile;

  public PricingService(File pricingRulesFile) {
    this.pricingRulesFile = pricingRulesFile;
  }

  public PricingRules getPricingRules() {
    return null;
  }

}
