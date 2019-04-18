package org.softuni.onlinegrocery.util.constants;

public final class ExceptionMessages {

    private ExceptionMessages() {
    }
    public static final String INCORRECT_USERNAME = "Username should be between 3 and 20 symbols.";
    public static final String INCORRECT_USERNAME_EMPTY_FIELD_ERROR_MSG = "Cannot be empty, should be at least 3 symbols.";
    public static final String INCORRECT_PASSWORD = "Cannot be empty, should be at least 3 symbols.";
    public static final String INCORRECT_ADDRESS = "Cannot be empty, should be at least 5 symbols.";
    public static final String INCORRECT_EMAIL = "Email should be valid, compliant with RFC822.";
    public static final String INVALID_PRODUCT_EX_MSG = "Invalid product.";
    public static final String USER_NOT_FOUND_EX_MSG = "Username not found.";
    public static final String CATEGORY_NOT_FOUND_EX_MSG = "Category not found.";
    public static final String ORDER_NOT_FOUND_EX_MSG = "Order not found.";
    public static final String PRODUCT_NOT_FOUND_EX_MSG = "Product not found.";
    public static final String PRODUCT_NAME_EXIST_EX_MSG = "Product name exists.";
    public static final String PRODUCT_ID_DOESNT_EXIST_EX_MSG = "Product with the given id was not found!";
    public static final String RECEIPT_NAME_EXIST_EX_MSG = "Receipt name exists.";
    public static final String PAGE_NOT_FOUND_EX_MSG = "Page Not Found: ERROR 404!\n" +
            "This page doesn't exist...";

}
