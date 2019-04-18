package org.softuni.onlinegrocery.validation;

import org.softuni.onlinegrocery.domain.entities.Product;
import org.softuni.onlinegrocery.domain.models.service.ProductServiceModel;

public interface ProductValidationService {
    boolean isValid(Product product);

    boolean isValid(ProductServiceModel product);
}
