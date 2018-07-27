package plopcas.checkout.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

  private List<Item> items;

  public Cart() {
    this.items = new ArrayList<>();
  }

  public void add(Item item) {
    this.items.add(item);
  }

  public List<Item> getItems() {
    return this.items;
  }

}
