package org.softuni.onlinegrocery.domain.models.service;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class OfferServiceModel extends BaseServiceModel {

    private ProductServiceModel product;
    private BigDecimal price;

    public OfferServiceModel() {
    }

    @NotNull
    public ProductServiceModel getProduct() {
        return product;
    }

    public void setProduct(ProductServiceModel product) {
        this.product = product;
    }

    @NotNull
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
