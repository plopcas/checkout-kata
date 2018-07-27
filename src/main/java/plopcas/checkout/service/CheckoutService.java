package plopcas.checkout.service;

import java.util.Objects;
import java.util.stream.Collectors;
import plopcas.checkout.exception.CartNotValidException;
import plopcas.checkout.model.Cart;
import plopcas.checkout.model.Item;
import plopcas.checkout.model.Price;

public class CheckoutService {

  public Price checkout(Cart cart) {

    if (cart == null) {
      throw new CartNotValidException("Cart is null");
    }

    Integer total = cart.getItems().stream().filter(Objects::nonNull).map(Item::getPrice)
        .collect(Collectors.summingInt(Integer::intValue));
    return new Price(total);

  }

}
