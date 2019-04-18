package org.softuni.onlinegrocery.domain.models.view;

import java.math.BigDecimal;

public class OrderProductViewModel {

    private ProductDetailsViewModel product;
    private BigDecimal price;

    public OrderProductViewModel() {
    }

    public ProductDetailsViewModel getProduct() {
        return product;
    }

    public void setProduct(ProductDetailsViewModel product) {
        this.product = product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
