package plopcas.checkout.service;

import java.util.ArrayList;
import java.util.List;
import plopcas.checkout.model.Item;

public class ScannerService {
  
  List<Item> items = new ArrayList<>();

  public List<Item> scan(Item item) {
    items.add(item);
    return items;
  }

}
