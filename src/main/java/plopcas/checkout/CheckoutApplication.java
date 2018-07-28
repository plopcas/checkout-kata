package plopcas.checkout;

import java.io.File;
import java.util.Scanner;
import plopcas.checkout.controller.CheckoutController;
import plopcas.checkout.model.PricingRules;
import plopcas.checkout.service.CheckoutService;
import plopcas.checkout.service.ItemService;
import plopcas.checkout.service.PricingService;
import plopcas.checkout.service.ScannerService;

public class CheckoutApplication {

  public static void main(String[] args) {

    File pricingRulesFile = new File("src/main/resources/pricing_rules.csv");
    PricingService pricingService = new PricingService(pricingRulesFile);
    PricingRules pricingRules = pricingService.getPricingRules();
    ItemService itemService = new ItemService(pricingRules);
    ScannerService scannerService = new ScannerService();
    CheckoutService checkoutService = new CheckoutService();

    Scanner sc = new Scanner(System.in);

    CheckoutController checkoutController =
        new CheckoutController(sc, itemService, scannerService, checkoutService);
    
    checkoutController.handleCheckoutTransaction();

    sc.close();
  }

}
