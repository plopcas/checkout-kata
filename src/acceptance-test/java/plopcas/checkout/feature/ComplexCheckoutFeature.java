package plopcas.checkout.feature;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;
import plopcas.checkout.model.Cart;
import plopcas.checkout.model.Item;
import plopcas.checkout.model.Price;
import plopcas.checkout.service.CheckoutService;
import plopcas.checkout.service.ScannerService;

public class ComplexCheckoutFeature {
  private ScannerService scannerService;
  private CheckoutService checkoutService;

  @Before
  public void setUp() {
    scannerService = new ScannerService();
    checkoutService = new CheckoutService();
  }

  @Test
  public void checkoutItemsWithSpecialPrice() {
    Cart cart = new Cart();

    Item item1 = new Item("A", 50);
    Item item2 = new Item("A", 50);
    Item item3 = new Item("A", 50);

    cart = scannerService.scan(item1, cart);
    cart = scannerService.scan(item2, cart);
    cart = scannerService.scan(item3, cart);
    Price total = checkoutService.checkout(cart);

    assertThat(total.getValue()).isEqualTo(130);
  }
}
