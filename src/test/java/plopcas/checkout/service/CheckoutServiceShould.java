package plopcas.checkout.service;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import plopcas.checkout.exception.CartNotValidException;
import plopcas.checkout.model.Cart;
import plopcas.checkout.model.Item;
import plopcas.checkout.model.Price;

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

    Price total = checkoutService.checkout(cart);

    Assertions.assertThat(total.getValue()).isEqualTo(80);
  }

  @Test
  public void checkoutEmptyCart() {
    Cart cart = new Cart();

    Price total = checkoutService.checkout(cart);

    Assertions.assertThat(total.getValue()).isEqualTo(0);
  }

  @Test
  public void checkoutNullItems() {
    Cart cart = new Cart();
    cart.add(itemA());
    cart.add(null);

    Price total = checkoutService.checkout(cart);

    Assertions.assertThat(total.getValue()).isEqualTo(50);
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
