# Online Grocery Store[![HitCount](http://hits.dwyl.io/mgpavlov/OnlineGroceryStore-Application.svg)](http://hits.dwyl.io/mgpavlov/OnlineGroceryStore-Application)
Developed an end to end Ecommerce web Application using Spring MVC with multiple modules
__
Online Grocery Shop is a system that registers users, categories, products and orders.
__

## The Database of the Application support 8 entities:
[User](https://github.com/mgpavlov/OnlineGroceryStore-Application/blob/master/src/main/java/org/softuni/onlinegrocery/domain/entities/User.java)

[Role](https://github.com/mgpavlov/OnlineGroceryStore-Application/blob/master/src/main/java/org/softuni/onlinegrocery/domain/entities/Role.java)

[Category](https://github.com/mgpavlov/OnlineGroceryStore-Application/blob/master/src/main/java/org/softuni/onlinegrocery/domain/entities/Category.java)

[Product](https://github.com/mgpavlov/OnlineGroceryStore-Application/blob/master/src/main/java/org/softuni/onlinegrocery/domain/entities/Product.java)

[OrderProduct](https://github.com/mgpavlov/OnlineGroceryStore-Application/blob/master/src/main/java/org/softuni/onlinegrocery/domain/entities/OrderProduct.java)

[Order](https://github.com/mgpavlov/OnlineGroceryStore-Application/blob/master/src/main/java/org/softuni/onlinegrocery/domain/entities/Order.java)

[Offer](https://github.com/mgpavlov/OnlineGroceryStore-Application/blob/master/src/main/java/org/softuni/onlinegrocery/domain/entities/Offer.java)

[Receipt](https://github.com/mgpavlov/OnlineGroceryStore-Application/blob/master/src/main/java/org/softuni/onlinegrocery/domain/entities/Receipt.java)

__
### Functionalities:

1. User Registeration

2. **CRUD Operations** like
* Admin can change users ROLE ("ADMIN")
* Admin can add category to the category list
* Admin can edit the category details
* Admin can delete the category from the list
* Admin can add product to the product list
* Admin can edit the product details
* Admin can delete the product from the list
* Admin can change order status
* User can add product to his cart
* User can order products and track orders.
___
## Setup
Tested on Windows 8/10 x64
### Versions
* Java **11.0.2**
* Maven **3.6.0**
* Maven Compiler **3.8.0**
* MySQL with mysql-connector-java **8.0.15**
* hibernate-core **5.4.1.Final**
* Apache TomEE 8.0.0.M2 **webprofile**
### Other tools:
* [ModelMapper](http://modelmapper.org/)
* [Jargon2](https://github.com/kosprov/jargon2-api) - Fluent Java API for Argon2 password hashing
### Environment configuration
System and IDE should be configured to use:
* [Java **11.0.2**](https://docs.oracle.com/cd/E19509-01/820-3208/inst_cli_jdk_javahome_t/) - [IntelliJ](https://stackoverflow.com/questions/18987228/how-do-i-change-the-intellij-idea-default-jdk)
* [Maven **3.6.0**](http://maven.apache.org/install.html) - [IntelliJ](https://www.jetbrains.com/help/idea/maven-support.html#create_new_maven_project)
* [mysql-connector-java **8.0.15**](https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-installing-classpath.html) - [IntelliJ](https://www.jetbrains.com/help/idea/connecting-to-a-database.html)
___
#### Project configuration
* [pom.xml](https://github.com/ivelin1936/Panda-Application/blob/master/pom.xml) - project setup - dependencies, compile, packaging
* [beans.xml](https://github.com/ivelin1936/Panda-Application/blob/master/src/main/webapp/WEB-INF/beans.xml) - default setup with 
## The Database of the PANDA application support 3 entities:
[User](https://github.com/ivelin1936/Panda-Application/blob/master/src/main/java/pandaApp/domain/entities/User.java)
* Has an Id – a UUID String
* Has an Username
* Has a Password
* Has an Email
* Has an Role – can be one of the following values (“User”, “Admin”)

[Package](https://github.com/ivelin1936/Panda-Application/blob/master/src/main/java/pandaApp/domain/entities/Package.java)
* Has an Id – a UUID String
* Has a Description – a string.
* Has a Weight – a floating-point number.
* Has a Shipping Address – a string.
* Has a Status – can be one of the following values (“Pending”, “Shipped”, “Delivered”, “Acquired”)
* Has an Estimated Delivery Date – A LocalDateTime object.
* Has a Recipient – a User object.

[Receipt](https://github.com/ivelin1936/Panda-Application/blob/master/src/main/java/pandaApp/domain/entities/Receipt.java)
* Has an Id – a UUID String
* Has a Fee – a decimal number.
* Has an Issued On – a LocalDateTime object.
* Has a Recipient – a User object.
* Has a Package – a Package object.

## Project Functionality
### Users
The first registered User should be assigned a role – "Root Admin". Every User after that, should have a role – "User".
Users have Packages, which are created and controlled for them, by an Administrator. 
Users can view Details about their own Orders. 
When a Order is delivered, a User can acquire it, at which point a Receipt is created with that Order and that User. 
Users can view their Receipts, and details about each Receipt.
Administrators (role = "Admin") are essentially like normal Users. They can also have Orders, which are delivered, acquired and they also have Receipts. 
Administrators can also create Orders for a specific User. 
* They can also view all Pending Packages, and they can Ship them.
* They can also view all Shipped Packages, and they can Deliver them.
* They can also view all Delivered Packages, and they can view Details about them.

##### The application provide Guest (not logged in) users with the functionality to:
* Login 
* Register
* View the Guest Index page
##### The application provide Users (logged in) with the functionality to:
* Logout
* View their Orders
* View details about a Order
* View their Receipts
* View details about a Receipt
##### The application provide Admins (logged in, with role - Admin) with the functionality to:
* Logout
* View their Orders
* View details about a Order
* View their Receipts
* View details about a Receipt
* View all Pending Orders
* View all Shipped Orders
* View all Delivered Orders
* View details about all Delivered Orders
* Ship Orders
* Deliver Orders

### Orders
When Orders are created, they are created with a list of Products, a Total Price, a Shipping Address and a Recipient User. 
* Upon creation, the Status of a Order should be set to Pending.
* Upon creation, the Issued On Date of a Order should be set to current date.
#### Pending Packages
A Pending Order, can be Shipped by an Administrator, by clicking on the [Ship] button from the Pending Orders Page. At that moment the Order Status becomes "Shipped" and the Status Date is to be set to a current date.
* All Pending Orders are presented on the Pending Orders Page.
* A User can view his Pending Orders on his My Orders Page in the Pending rectangular block.
* A User can view details about each one of his Pending Orders from his My Orders Page, by clicking on the [Details] button.
#### Shipped Packages
A Shipped Package, can be Delivered by an Administrator, by clicking on the [Deliver] button from the Shipped Packages Page. At that moment the Package Status becomes "Delivered".
* All Shipped Packages are presented on the Shipped Packages Page.
* A User can view his Shipped Packages on his Index Page in the Shipped rectangular block.
* A User can view details about each one of his Shipped Packages from his Index Page, by clicking on the [Details] button.
#### Delivered Orders
A Delivered Order, can be Acquired by the Order’s Recipient, by clicking on the [Acquire] button from his My Orders Page. At that moment the Order Status becomes "Acquired" and a Receipt is generated to the User for that Order.
All Delivered Orders are presented on the Delivered Orders Page.
A User can view his Delivered Orders on his My Orders Page in the Delivered rectangular block.
A User can Acquire each one of his Delivered Orders from his My Orders Page, by clicking on the [Acquire] button.

NOTE: The INDEX PAGE visualizes ONLY the CURRENTLY LOGGED IN USER / ADMIN’s PACKAGES.
NOTE: Acquired Packages are viewable only by Administrators on the Delivered Packages Page.
NOTE: Administrators can view details about ALL Delivered / Acquired Packages from the
Delivered Packages Page, by clicking on the [Details] button.

### Receipts
Receipts are just data entities. They are created when a Order is Acquired by its Recipient User. 
A Receipt should be created with a Order and a Recipient User.
Upon creation, a Receipt’s IssuedOn should be set to the current moment.

## Security Configurations - mainly access requirements
* Guest (not logged in) users can access Index page and functionality.
* Guest (not logged in) users can access Login page and functionality.
* Guest (not logged in) users can access Register page and functionality.

* Users (logged in) can access User LoggedIn Home page and functionality.
* Users (logged in) can access User Order Details page and functionality.
* Users (logged in) can access User Receipts page and functionality.
* Users (logged in) can access User Receipt Details page and functionality. 
* Users (logged in) can access User Order Acquire functionality.
* Users (logged in) can access Logout functionality.


* Moderator (logged in) can access every functionality a normal logged in User can.
* Moderator (logged in) can access Moderator LoggedIn Home page and functionality.
* Moderator (logged in) can access the Moderator Category Create page and functionality.
* Moderator (logged in) can access the Moderator Product Create page and functionality.

* Admins (logged in) can access every functionality a logged in Moderator can.
* Admins (logged in) can access the Admin Pending Orders page and functionality.
* Admins (logged in) can access the Admin Shipped Orders page and functionality.
* Admins (logged in) can access the Admin Delivered Orders page and functionality.
* Admins (logged in) can access the Admin Order Ship functionality. 
* Admins (logged in) can access the Admin Order Deliver functionality.
* Admins (logged in) can access the Users Profiles functionality and change User Role except Root Admin profile.

* Root Admin (logged in) can access every functionality a logged in Admin can.
* Root Admin (logged in) role cannot be changed.

___
## Technologies
* Java - [JDK11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)

## Built With
* [Maven](https://maven.apache.org/) - Dependency Management

## Version
1.0-SNAPSHOT

## Author
**Mihail Pavlov** 
* [GitHub](https://github.com/mgpavlov)
* [LinkedIn](https://www.linkedin.com/in/mihail-georgiev-pavlov/)

## License
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
