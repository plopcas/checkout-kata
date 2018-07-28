package plopcas.checkout.feature;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;
import plopcas.checkout.model.Cart;
import plopcas.checkout.model.Discount;
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

    cart = scannerService.scan(itemA(), cart);
    cart = scannerService.scan(itemA(), cart);
    cart = scannerService.scan(itemA(), cart);
    Price total = checkoutService.checkout(cart);

    assertThat(total.getValue()).isEqualTo(130);
  }

  @Test
  public void checkoutItemsWithSpecialPriceMoreThanOnce() {
    Cart cart = new Cart();

    cart = scannerService.scan(itemA(), cart);
    cart = scannerService.scan(itemA(), cart);
    cart = scannerService.scan(itemA(), cart);
    cart = scannerService.scan(itemA(), cart);
    cart = scannerService.scan(itemA(), cart);
    cart = scannerService.scan(itemA(), cart);
    Price total = checkoutService.checkout(cart);

    assertThat(total.getValue()).isEqualTo(260);
  }

  private Item itemA() {
    return new Item("A", 50, new Discount(3, 20));
  }
}
