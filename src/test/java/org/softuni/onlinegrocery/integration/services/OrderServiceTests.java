package org.softuni.onlinegrocery.integration.services;//package org.softuni.productshop.integration.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.softuni.onlinegrocery.domain.entities.Order;
import org.softuni.onlinegrocery.domain.entities.OrderProduct;
import org.softuni.onlinegrocery.domain.entities.Product;
import org.softuni.onlinegrocery.domain.entities.User;
import org.softuni.onlinegrocery.domain.models.service.OrderServiceModel;
import org.softuni.onlinegrocery.domain.models.service.UserServiceModel;
import org.softuni.onlinegrocery.repository.OrderRepository;
import org.softuni.onlinegrocery.repository.ProductRepository;
import org.softuni.onlinegrocery.service.OrderService;
import org.softuni.onlinegrocery.service.UserService;
import org.softuni.onlinegrocery.validation.ProductValidationService;
import org.softuni.onlinegrocery.validation.UserValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceTests {
    @Autowired
    OrderService service;

    @MockBean
    OrderRepository mockOrderRepository;

    @MockBean
    UserValidationService mockUserValidation;

    @MockBean
    UserService mockUserService;

    @MockBean
    ProductRepository mockProductRepository;

    @MockBean
    ProductValidationService productValidation;

    private List<Order> orders;

    @Before
    public void setupTest() {
        orders = new ArrayList<>();
        when(mockOrderRepository.findAll())
                .thenReturn(orders);
    }

    @Test
    public void findAllOrders_when1Orders_return1Orders() {
        String customer = "Test customer";
        String productImageUrl = "http://image.url";
        String productName = "product 1";
        BigDecimal productPrice = BigDecimal.valueOf(1.34);

        Order order = new Order();
        order.setCustomer(new User() {{
            setUsername(customer);
        }});
        List<OrderProduct> orderProducts = new ArrayList<>();
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setPrice(productPrice);

        Product product = new Product();
        product.setPrice(productPrice);
        product.setImageUrl(productImageUrl);
        product.setName(productName);

        orderProduct.setProduct(product);
        orderProducts.add(orderProduct);

        order.setProducts(orderProducts);

        orders.add(order);

        var result = service.findAllOrders();
        OrderServiceModel orderResult = result.get(0);

        assertEquals(1, result.size());
        assertEquals(customer, orderResult.getCustomer().getUsername());
        assertEquals(productName, orderResult.getProducts().get(0).getProduct().getName());
        assertEquals(productImageUrl, orderResult.getProducts().get(0).getProduct().getImageUrl());
        assertEquals(productPrice, orderResult.getProducts().get(0).getProduct().getPrice());
    }

    @Test
    public void findAllOrders_whenNoOrders_returnEmptyOrders() {
        orders.clear();
        var result = service.findAllOrders();
        assertTrue(result.isEmpty());
    }

    @Test(expected = NullPointerException.class)
    public void createOrder_whenUserAndProductAreValid_orderCreated() throws Exception {
        when(mockUserValidation.isValid(any()))
                .thenReturn(true);
        when(productValidation.isValid(any(Product.class)))
                .thenReturn(true);

        when(mockUserService.findUserByUserName(any()))
                .thenReturn(new UserServiceModel());

        when(mockProductRepository.findById(any()))
                .thenReturn(java.util.Optional.of(new Product()));

        OrderServiceModel orderServiceModel = new OrderServiceModel();
        service.createOrder(orderServiceModel);

        verify(mockOrderRepository)
            .save(any());
    }

    @Test(expected = Exception.class)
    public void createOrder_whenUserIsValidAndProductIsNotValid_throw() throws Exception {
        when(mockUserValidation.isValid(any()))
                .thenReturn(true);
        when(productValidation.isValid(any(Product.class)))
                .thenReturn(false);

        service.createOrder(null);
    }

    @Test(expected = Exception.class)
    public void createOrder_whenUserIsNotValidAndProductIsValid_throw() throws Exception {
        when(mockUserValidation.isValid(any()))
                .thenReturn(false);
        when(productValidation.isValid(any(Product.class)))
                .thenReturn(true);

        service.createOrder(null);
    }

    @Test(expected = Exception.class)
    public void createOrder_whenUserAndProductAreNotValid_throw() throws Exception {
        when(mockUserValidation.isValid(any()))
                .thenReturn(false);
        when(productValidation.isValid(any(Product.class)))
                .thenReturn(false);

        service.createOrder(null);
    }
}
