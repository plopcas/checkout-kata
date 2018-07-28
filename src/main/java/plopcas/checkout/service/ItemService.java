package plopcas.checkout.service;

import plopcas.checkout.exception.ItemNotFoundException;
import plopcas.checkout.model.Item;
import plopcas.checkout.model.PricingRules;

public class ItemService {

  private PricingRules pricingRules;

  public ItemService(PricingRules pricingRules) {
    this.pricingRules = pricingRules;
  }

  public Item find(String itemId) {
    if (!pricingRules.containsKey(itemId)) {
      throw new ItemNotFoundException(String.format("Item %s not found", itemId));
    }
    return pricingRules.get(itemId);
  }

}
