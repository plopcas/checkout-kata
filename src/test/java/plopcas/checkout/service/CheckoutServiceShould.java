package plopcas.checkout.service;

import static org.assertj.core.api.Assertions.assertThat;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import plopcas.checkout.exception.CartNotValidException;
import plopcas.checkout.model.Cart;
import plopcas.checkout.model.Item;

public class CheckoutServiceShould {

  @InjectMocks
  private CheckoutService checkoutService;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void checkout() {
    Cart cart = new Cart();
    cart.add(itemA());
    cart.add(itemB());

    Integer total = checkoutService.checkout(cart);

    assertThat(total).isEqualTo(80);
  }

  @Test
  public void checkoutEmptyCart() {
    Cart cart = new Cart();

    Integer total = checkoutService.checkout(cart);

    assertThat(total).isEqualTo(0);
  }

  @Test
  public void checkoutNullItems() {
    Cart cart = new Cart();
    cart.add(itemA());
    cart.add(null);

    Integer total = checkoutService.checkout(cart);

    assertThat(total).isEqualTo(50);
  }

  @Test(expected = CartNotValidException.class)
  public void failWhenCartIsNull() {
    checkoutService.checkout(null);
  }

  private Item itemA() {
    return new Item("A", 50);
  }

  private Item itemB() {
    return new Item("B", 30);
  }

}
