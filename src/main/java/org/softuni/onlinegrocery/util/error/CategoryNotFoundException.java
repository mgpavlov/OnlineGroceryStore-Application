package org.softuni.onlinegrocery.util.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.softuni.onlinegrocery.util.constants.ExceptionMessages.*;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = CATEGORY_NOT_FOUND_EX_MSG)
public class CategoryNotFoundException extends RuntimeException {

    private int statusCode;

    public CategoryNotFoundException() {
        this.statusCode = 404;
    }

    public CategoryNotFoundException(String message) {
        super(message);
        this.statusCode = 404;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
