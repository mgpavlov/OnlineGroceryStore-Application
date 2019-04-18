package org.softuni.onlinegrocery.domain.models.view;

import java.math.BigDecimal;

public class OfferViewModel {

    private ProductDetailsViewModel product;
    private BigDecimal price;

    public OfferViewModel() {
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
