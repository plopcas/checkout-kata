package plopcas.checkout.service;

import plopcas.checkout.model.Item;
import plopcas.checkout.model.PricingRules;

public class ItemService {

  private PricingRules pricingRules;

  public ItemService(PricingRules pricingRules) {
    this.pricingRules = pricingRules;
  }

  public Item find(String itemId) {
    return null;
  }

}
