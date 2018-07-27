package plopcas.checkout.service;

import java.util.stream.Collectors;
import plopcas.checkout.model.Cart;
import plopcas.checkout.model.Item;
import plopcas.checkout.model.Price;

public class CheckoutService {

  public Price checkout(Cart cart) {
    Integer total = cart.getItems().stream().map(Item::getPrice)
        .collect(Collectors.summingInt(Integer::intValue));
    return new Price(total);
  }

}
