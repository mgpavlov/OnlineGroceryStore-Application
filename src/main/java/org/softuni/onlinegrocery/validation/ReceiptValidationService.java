package org.softuni.onlinegrocery.validation;

import org.softuni.onlinegrocery.domain.entities.Receipt;
import org.softuni.onlinegrocery.domain.models.service.ReceiptServiceModel;

public interface ReceiptValidationService {
    boolean isValid(Receipt receipt);

    boolean isValid(ReceiptServiceModel receiptServiceModel);
}
