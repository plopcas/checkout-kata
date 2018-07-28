package plopcas.checkout.feature;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;
import plopcas.checkout.model.Cart;
import plopcas.checkout.model.PricingRules;
import plopcas.checkout.model.Result;
import plopcas.checkout.service.CheckoutService;
import plopcas.checkout.service.ItemService;
import plopcas.checkout.service.ScannerService;

/**
 * Feature: Pricing <br>
 * As an admin <br>
 * I should be able to specify the pricing rules <br>
 * before a checkout transaction starts <br>
 * so that I can be reconfigure the prices and deals on demand
 */
public class PricingFeature {
  private ScannerService scannerService;
  private CheckoutService checkoutService;
  private ItemService itemService;

  @Before
  public void setUp() {
    scannerService = new ScannerService();
    checkoutService = new CheckoutService();
  }

  @Test
  public void simpleCheckoutWithPricingRules() {
    PricingRules pricingRules = new PricingRules();
    
    itemService = new ItemService(pricingRules);
    
    Cart cart = new Cart();

    cart = scannerService.scan(itemService.find("A"), cart);
    Result result = checkoutService.checkout(cart);

    assertThat(result.getToPay()).isEqualTo(50);
  }
}
