package org.softuni.onlinegrocery.validation.implementations;

import org.softuni.onlinegrocery.domain.entities.Product;
import org.softuni.onlinegrocery.domain.models.service.CategoryServiceModel;
import org.softuni.onlinegrocery.domain.models.service.ProductServiceModel;
import org.softuni.onlinegrocery.validation.ProductValidationService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductionValidationServiceImpl implements ProductValidationService {
    @Override
    public boolean isValid(Product product) {
        return product != null;
    }

    @Override
    public boolean isValid(ProductServiceModel product) {
        return product != null
                && areCategoriesValid(product.getCategories());
    }

    private boolean areCategoriesValid(List<CategoryServiceModel> categories) {
        return categories != null && !categories.isEmpty();
    }
}
