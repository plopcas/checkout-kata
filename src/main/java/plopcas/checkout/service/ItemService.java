package plopcas.checkout.service;

import plopcas.checkout.exception.ItemNotFoundException;
import plopcas.checkout.exception.PricingRulesNotValidException;
import plopcas.checkout.model.Item;
import plopcas.checkout.model.PricingRules;

public class ItemService {

  private PricingRules pricingRules;

  public ItemService(PricingRules pricingRules) {
    if (pricingRules == null) {
      throw new PricingRulesNotValidException("Pricing rules are null");
    }
    this.pricingRules = pricingRules;
  }

  public Item find(String itemId) throws ItemNotFoundException {
    if (!pricingRules.containsKey(itemId)) {
      throw new ItemNotFoundException(String.format("Item %s not found", itemId));
    }
    return pricingRules.get(itemId);
  }

}
