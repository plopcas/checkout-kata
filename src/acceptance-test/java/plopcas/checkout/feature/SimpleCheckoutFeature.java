package plopcas.checkout.feature;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;
import plopcas.checkout.model.Cart;
import plopcas.checkout.model.Item;
import plopcas.checkout.service.CheckoutService;
import plopcas.checkout.service.ScannerService;

public class SimpleCheckoutFeature {

  private ScannerService scannerService;
  private CheckoutService checkoutService;

  @Before
  public void setUp() {
    scannerService = new ScannerService();
    checkoutService = new CheckoutService();
  }

  @Test
  public void scanSingleItem() {
    Cart cart = new Cart();

    cart = scannerService.scan(itemA(), cart);
    Integer total = checkoutService.checkout(cart);

    assertThat(total).isEqualTo(50);
  }

  @Test
  public void scanMultipleDifferentItems() {
    Cart cart = new Cart();

    cart = scannerService.scan(itemA(), cart);
    cart = scannerService.scan(itemB(), cart);
    Integer total = checkoutService.checkout(cart);

    assertThat(total).isEqualTo(80);
  }

  @Test
  public void scanMultipleSameItems() {
    Cart cart = new Cart();

    cart = scannerService.scan(itemA(), cart);
    cart = scannerService.scan(itemC(), cart);
    cart = scannerService.scan(itemC(), cart);
    Integer total = checkoutService.checkout(cart);

    assertThat(total).isEqualTo(90);
  }

  private Item itemA() {
    return new Item("A", 50);
  }

  private Item itemB() {
    return new Item("B", 30);
  }

  private Item itemC() {
    return new Item("C", 20);
  }

}
