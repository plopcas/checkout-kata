package plopcas.checkout.service;

import plopcas.checkout.model.Cart;
import plopcas.checkout.model.Item;

public class ScannerService {

  public Cart scan(Item item, Cart cart) {
    if (item != null) {
      cart.getItems().add(item);
    }
    return cart;
  }

}
