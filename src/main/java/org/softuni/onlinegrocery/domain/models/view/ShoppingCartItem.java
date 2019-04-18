package org.softuni.onlinegrocery.domain.models.view;

import java.io.Serializable;
import java.math.BigDecimal;

public class ShoppingCartItem implements Serializable {

    private OrderProductViewModel product;
    private int quantity;

    public ShoppingCartItem() {
    }

    public OrderProductViewModel getProduct() {
        return this.product;
    }

    public void setProduct(OrderProductViewModel product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
