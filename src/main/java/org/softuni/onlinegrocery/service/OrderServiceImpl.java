package org.softuni.onlinegrocery.service;

import org.modelmapper.ModelMapper;
import org.softuni.onlinegrocery.domain.entities.Order;
import org.softuni.onlinegrocery.domain.entities.enumeration.Status;
import org.softuni.onlinegrocery.domain.models.service.OrderServiceModel;
import org.softuni.onlinegrocery.util.error.OrderNotFoundException;
import org.softuni.onlinegrocery.repository.OrderRepository;
import org.softuni.onlinegrocery.repository.ProductRepository;
import org.softuni.onlinegrocery.validation.ProductValidationService;
import org.softuni.onlinegrocery.validation.UserValidationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.softuni.onlinegrocery.util.constants.ExceptionMessages.*;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final UserValidationService userValidation;
    private final ProductValidationService productValidation;

    public OrderServiceImpl(
            OrderRepository orderRepository,
            ProductRepository productRepository,
            UserService userService,
            UserValidationService userValidation,
            ProductValidationService productValidation,
            ModelMapper modelMapper
    ) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.userService = userService;
        this.userValidation = userValidation;
        this.productValidation = productValidation;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createOrder(OrderServiceModel orderServiceModel) {
        orderServiceModel.setIssuedOn(LocalDateTime.now());
        Order order = this.modelMapper.map(orderServiceModel, Order.class);
        order.setShippingAddress(orderServiceModel.getCustomer().getAddress());
        order.setStatus(Status.Pending);
        this.orderRepository.save(order);
    }

    @Override
    public List<OrderServiceModel> findAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(o -> modelMapper.map(o, OrderServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderServiceModel> findOrdersByCustomer(String username) {
        return this.orderRepository.findAllOrdersByCustomer_UsernameOrderByIssuedOn(username)
                .stream()
                .map(o -> modelMapper.map(o, OrderServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public OrderServiceModel findOrderById(String id) {
        return this.orderRepository.findById(id)
                .map(o -> this.modelMapper.map(o, OrderServiceModel.class))
                .orElseThrow(() -> new OrderNotFoundException(ORDER_NOT_FOUND_EX_MSG));
    }

    @Override
    public List<OrderServiceModel> findOrdersByStatus(Status status) {
        return this.orderRepository.findAllOrdersByStatus_OrderByIssuedOn(status)
                .stream()
                .map(o -> modelMapper.map(o, OrderServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void changeOrderStatus(String id) {
        Order order = this.orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(ORDER_NOT_FOUND_EX_MSG));

        order.setStatusDate(LocalDateTime.now());
        changeStatus(order);

        this.orderRepository.save(order);
    }

    @Override
    public List<OrderServiceModel> findOrdersByCustomerAndStatus(String customerName, Status status) {
        return this.orderRepository
                .findAllOrdersByCustomerUsernameAndStatus_OrderByIssuedOn(customerName, status)
                .stream()
                .map(o -> modelMapper.map(o, OrderServiceModel.class))
                .collect(Collectors.toList());
    }


    private void changeStatus(Order order) {
        order.setStatus(Status.values()[Arrays.asList(Status.values()).indexOf(order.getStatus()) + 1]);
    }
}