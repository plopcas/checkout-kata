package plopcas.checkout.service;

import java.util.List;
import java.util.stream.Collectors;
import plopcas.checkout.model.Item;
import plopcas.checkout.model.Price;

public class CheckoutService {

  public Price checkout(List<Item> scannedItems) {
    Integer total =
        scannedItems.stream().map(Item::getPrice).collect(Collectors.summingInt(Integer::intValue));
    return new Price(total);
  }

}
