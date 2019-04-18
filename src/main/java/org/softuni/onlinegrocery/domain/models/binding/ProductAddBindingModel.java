package org.softuni.onlinegrocery.domain.models.binding;

import org.hibernate.validator.constraints.Length;
import org.softuni.onlinegrocery.domain.entities.Category;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

import static org.softuni.onlinegrocery.util.constants.ValidationErrorMessages.*;


public class ProductAddBindingModel {


    private String name;
    private String description;
    private BigDecimal price;
    private MultipartFile image;
    private List<Category> categories;

    public ProductAddBindingModel() {
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
    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    @NotNull
    @NotEmpty(message = PRODUCT_CATEGORIES_EMPTY_FIELD_ERROR_MSG)
    public List<Category> getCategories() {
        return this.categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
