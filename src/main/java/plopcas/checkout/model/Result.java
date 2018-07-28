package plopcas.checkout.model;

public class Result {

  private Integer total;
  private Integer discount;
  private Integer toPay;
  private Cart cart;

  public Result(Integer total, Integer discount, Integer toPay, Cart cart) {
    this.total = total;
    this.discount = discount;
    this.toPay = toPay;
    this.cart = cart;
  }

  public Integer getTotal() {
    return total;
  }

  public Integer getDiscount() {
    return discount;
  }

  public Integer getToPay() {
    return toPay;
  }

  public Cart getCart() {
    return cart;
  }

}
