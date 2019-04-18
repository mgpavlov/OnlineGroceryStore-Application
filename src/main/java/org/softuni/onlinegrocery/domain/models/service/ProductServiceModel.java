package org.softuni.onlinegrocery.domain.models.service;

import org.hibernate.validator.constraints.Length;
import org.softuni.onlinegrocery.domain.entities.enumeration.Status;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

import static org.softuni.onlinegrocery.util.constants.ValidationErrorMessages.*;

public class ProductServiceModel extends BaseServiceModel {

    private String name;
    private String description;
    private BigDecimal price;
    private String imageUrl;
    private List<CategoryServiceModel> categories;
    private BigDecimal discountedPrice;
    private boolean isDeleted;

    public ProductServiceModel() {
    }

    @NotNull(message = PRODUCT_NAME_EMPTY_FIELD_ERROR_MSG)
    @Size(min = 3, max = 20, message = PRODUCT_NAME_LENGTH)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull(message = PRODUCT_DESCRIPTION_EMPTY_FIELD_ERROR_MSG)
    @NotEmpty(message = PRODUCT_DESCRIPTION_EMPTY_FIELD_ERROR_MSG)
    @Length(max = 50, message = PRODUCT_DESCRIPTION_MAX_LENGTH_ERROR_MSG)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotNull(message = PRODUCT_PRICE_EMPTY_FIELD_ERROR_MSG)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @NotNull(message = PRODUCT_IMAGE_EMPTY_FIELD_ERROR_MSG)
    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @NotNull
    @NotEmpty(message = PRODUCT_CATEGORIES_EMPTY_FIELD_ERROR_MSG)
    public List<CategoryServiceModel> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryServiceModel> categories) {
        this.categories = categories;
    }

    public BigDecimal getDiscountedPrice() {
        return this.discountedPrice;
    }

    public void setDiscountedPrice(BigDecimal discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public boolean isDeleted() {
        return this.isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
