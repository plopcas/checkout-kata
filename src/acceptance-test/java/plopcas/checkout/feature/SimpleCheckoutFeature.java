package plopcas.checkout.feature;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import plopcas.checkout.model.Item;
import plopcas.checkout.model.Price;
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
    Item item1 = new Item("A", 50);

    List<Item> scannedItems = scannerService.scan(item1);
    Price price = checkoutService.checkout(scannedItems);

    assertThat(price.getValue()).isEqualTo(50);
  }

}
