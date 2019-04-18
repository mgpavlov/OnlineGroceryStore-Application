package org.softuni.onlinegrocery.web.controllers;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.softuni.onlinegrocery.domain.entities.*;
import org.softuni.onlinegrocery.domain.entities.enumeration.Status;
import org.softuni.onlinegrocery.domain.models.view.ReceiptViewModel;
import org.softuni.onlinegrocery.repository.CategoryRepository;
import org.softuni.onlinegrocery.repository.OrderRepository;
import org.softuni.onlinegrocery.repository.ProductRepository;
import org.softuni.onlinegrocery.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ReceiptsControllerTests {

    @Autowired
    private MockMvc mvc;

    @Mock
    Principal principal;

    @Autowired
    ReceiptsController controller;

    @MockBean
    ReceiptRepository mockOrderRepository;
    private ArrayList<Receipt> receipts;

    @Autowired
    private ReceiptRepository receiptRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private Gson gson;

    @Before
    public void setupTest(){
        receipts = new ArrayList<>();

        when(receiptRepository.findAllReceiptsByRecipient_UsernameOrderByIssuedOn(any()))
                .thenReturn(receipts);
    }

    @Test
    @WithMockUser
    public void getCustomerOrders_whenCustomerHasNoOrders_empty() {
        receipts.clear();
        ModelAndView modelAndView = new ModelAndView();
        when(principal.getName())
                .thenReturn("");

        ModelAndView result = controller.getMyOrders(modelAndView, principal);

        List<ReceiptViewModel> viewModels = (List<ReceiptViewModel>) result.getModel().get("receipts");
        assertTrue(viewModels.isEmpty());
    }

    @Test
    @WithMockUser
    @Transactional
    public void getCustomerReceipts_whenCustomerHasNoReceipt_empty() {
        ModelAndView modelAndView = new ModelAndView();
        when(principal.getName())
                .thenReturn("");

        ModelAndView result = controller.getMyOrders(modelAndView, principal);

        List<ReceiptViewModel> viewModels = (List<ReceiptViewModel>) result.getModel().get("receipts");
        assertTrue(viewModels.isEmpty());
    }

    @Test
    @WithMockUser
    public void getCustomerReceipts_whenAllReceiptsAreForCustomer_orders() {
        receipts.addAll(List.of(
                new Receipt()
        ));

        ModelAndView modelAndView = new ModelAndView();
        when(principal.getName())
                .thenReturn("");

        ModelAndView result = controller.getMyOrders(modelAndView, principal);

        List<ReceiptViewModel> viewModels = (List<ReceiptViewModel>) result.getModel().get("receipts");
        assertEquals(receipts.size(), viewModels.size());
    }

    private Order createOrder() {
        Order order = new Order();
        order.setProducts(orderProductList());
        order.setCustomer(createUser());
        order.setStatus(Status.Pending);
        order.setShippingAddress(createUser().getAddress());
        order.setIssuedOn(LocalDateTime.now());
        order.setTotalPrice(BigDecimal.TEN);
        orderRepository.save(order);
        return order;
    }

    private Product createProduct1() {
        Product product = new Product();
        product.setImageUrl("aaaaa");
        product.setName("banana");
        product.setPrice(BigDecimal.TEN);
        product.setDescription("asdasdsdasd");
        product.setDeleted(false);
        product.setCategories(categoryList());

        productRepository.save(product);
        return product;
    }

    private Product createProduct2() {
        Product product = new Product();
        product.setImageUrl("bbbbbb");
        product.setName("bansana");
        product.setPrice(BigDecimal.TEN);
        product.setDescription("asdasddsdasd");
        product.setDeleted(false);
        product.setCategories(categoryList());

        productRepository.save(product);
        return product;
    }

    private Category createCategory (String name){
        Category category = new Category();
        category.setName(name);
        category.setDeleted(false);
        categoryRepository.save(category);
        return category;
    }

    private User createUser (){
        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setAuthority("ROLE_USER");
        roles.add(role);
        User user = new User();
        user.setUsername("alaabala");
        user.setAddress("alalalalal");
        user.setPassword("aaaaaaaa");
        user.setAuthorities(roles);
        return user;
    }

    private List<Category> categoryList(){
        List<Category> categories = new ArrayList<>();

        categories.add(createCategory("music"));
        categories.add(createCategory("health"));

        return categories;
    }

    private List<Product> productList(){
        List<Product> products = new ArrayList<>();
        products.add(createProduct1());
        products.add(createProduct2());

        return products;
    }


    private OrderProduct createOrderProduct1() {
        OrderProduct orderProduct = new OrderProduct();
        Product product = createProduct1();
        orderProduct.setPrice(product.getPrice());
        orderProduct.setProduct(product);

        return orderProduct;
    }

    private OrderProduct createOrderProduct2() {
        OrderProduct orderProduct = new OrderProduct();
        Product product = createProduct2();
        orderProduct.setPrice(product.getPrice());
        orderProduct.setProduct(product);

        return orderProduct;
    }

    private List<OrderProduct> orderProductList(){
        List<OrderProduct> products = new ArrayList<>();
        products.add(createOrderProduct1());
        products.add(createOrderProduct2());

        return products;
    }
}