package org.softuni.onlinegrocery.util.constants;

public final class AppConstants {

    private AppConstants() {
    }

    public static final String CLOUD_NAME = "cloud_name";
    public static final String API_KEY = "api_key";
    public static final String API_SECRET = "api_secret";

    public static final String UUID_STRING = "uuid-string";
    public static final String UUID_GENERATOR = "org.hibernate.id.UUIDGenerator";

    public static final String FAVICON_URL= "https://res.cloudinary.com/mgpavlov/image/upload/v1554912174/icons8-shopping-cart-96.png";
    public static final String FAVICON= "favicon";

    public static final String GREETING= "greeting";
    public static final String GREETING_GOOD_MORNING = "Good morning ";
    public static final String GREETING_GOOD_AFTERNOON = "Good afternoon ";
    public static final String GREETING_GOOD_EVENING = "Good evening ";

    public static final String TITLE_GROCERY_STORE = "Grocery Store";
    public static final String TITLE = "title";
    public static final String DASH = " - ";
    public static final String EMPTY_STRING = "";

    public static final String MODEL = "model";
    public static final String USERNAME = "username";
    public static final String MESSAGE = "message";
    public static final String STATUS_CODE = "statusCode";
    public static final String REGISTER = "Register";

    public static final String ERROR = "error";
    public static final String LOGIN = "Login";
    public static final String USER_PROFILE = "User Profile";
    public static final String VIEW_MODEL= "viewModel";
    public static final String USERS= "Users";

    public static final String RECEIPTS = "Receipts";
    public static final String RECEIPTS_TO_LOWER_CASE = "receipts";
    public static final String RECEIPT_TO_LOWER_CASE = "receipt";
    public static final String RECEIPTS_DETAILS = "Receipts Details";

    public static final String ORDERS = "Orders";
    public static final String ORDER_DETAILS = "Order Details";
    public static final String MY_ORDERS = "My Orders";
    public static final String MY_PENDING_ORDERS = "myPendingOrders";
    public static final String MY_SHIPPED_ORDERS = "myShippedOrders";
    public static final String MY_DELIVERED_ORDERS = "myDeliveredOrders";

    public static final String STATUS_ALL = "All";
    public static final String STATUS_SHIPPED = "Shipped";
    public static final String STATUS_DELIVERED = "Delivered";
    public static final String STATUS_ACQUIRED = "Acquired";

    public static final String ORDERS_TO_LOWER_CASE = "orders";
    public static final String ORDER_TO_LOWER_CASE = "order";

    public static final String SALES = "Sales";
    public static final String INDEX = "Index";
    public static final String HOME = "Home";

    public static final String PRINCIPAL_TO_LOWER_CASE = "principal";
    public static final String CATEGORIES_TO_LOWER_CASE = "categories";
    public static final String CATEGORIES = "Categories";

    public static final String TOTAL_PRICE = "totalPrice";
    public static final String SHOPPING_CART = "shopping-cart";

    public static final String REDIRECT_BASE_CONTROLLER = "redirect:";
    public static final String URL_TO_LOWERCASE = "url";
    public static final String TEMP_FILE = "temp-file";

    public static final String PRODUCTS_TO_LOWERCASE = "products";
    public static final String PRODUCT_TO_LOWERCASE = "product";
    public static final String PRODUCT_ID = "productId";
    public static final String CATEGORY_NAME = "categoryName";


    public static final int PRODUCT_NAME_MIN_LENGTH = 3;
    public static final int PRODUCT_NAME_MAX_LENGTH = 20;
    public static final int PRODUCT_DESCRIPTION_MAX_LENGTH = 50;
    public static final int CATEGORY_NAME_MAX_LENGTH = 20;
    public static final int USER_NAME_MIN_LENGTH = 3;
    public static final int USER_NAME_MAX_LENGTH = 20;
    public static final int PASSWORD_MIN_LENGTH = 3;

    public static final int OFFER_SCHEDULED_FIX_RATE = 300000;//5 minutes
    public static final int OFFER_SCHEDULED_NUMBER_OF_PRODUCTS = 10;
    public static final int ZERO_NUMBER = 0;
    public static final int ONE_NUMBER = 1;
    public static final double OFFER_SCHEDULED_DISCOUNT = 0.75;//25%

    public static final int GREETING_INTERCEPTOR_TWELVE = 12;
    public static final int GREETING_INTERCEPTOR_SEVENTEEN = 17;


}
