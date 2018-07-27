package plopcas.checkout.service;

import java.util.List;
import plopcas.checkout.model.Item;
import plopcas.checkout.model.Price;

public class CheckoutService {

  public Price checkout(List<Item> scannedItems) {
    return new Price(50);
  }

}
