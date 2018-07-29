package plopcas.checkout;

import static java.lang.String.format;
import java.io.File;
import java.util.Scanner;
import plopcas.checkout.controller.CheckoutController;
import plopcas.checkout.exception.PricingRulesNotFoundException;
import plopcas.checkout.model.PricingRules;
import plopcas.checkout.service.CheckoutService;
import plopcas.checkout.service.ItemService;
import plopcas.checkout.service.PricingService;
import plopcas.checkout.service.ScannerService;

/**
 * Main class for the checkout application.
 */
public class CheckoutApplication {

  public static void main(String[] args) {

    File pricingRulesFile = new File("src/main/resources/pricing_rules.csv");
    PricingService pricingService;
    try {
      pricingService = new PricingService(pricingRulesFile);
    } catch (PricingRulesNotFoundException e) {
      System.err.println(format("Pricing rules file not found: %s", pricingRulesFile));
      return;
    }
    
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
