package plopcas.checkout.controller;

import java.util.Scanner;
import plopcas.checkout.model.Result;
import plopcas.checkout.service.CheckoutService;
import plopcas.checkout.service.ItemService;
import plopcas.checkout.service.ScannerService;

public class CheckoutController {


  private Scanner sc;
  private ItemService itemService;
  private ScannerService scannerService;
  private CheckoutService checkoutService;

  public CheckoutController(Scanner sc, ItemService itemService, ScannerService scannerService,
      CheckoutService checkoutService) {
    this.sc = sc;
    this.itemService = itemService;
    this.scannerService = scannerService;
    this.checkoutService = checkoutService;
  }

  public Result handleCheckoutTransaction() {
    return null;
  }
}
