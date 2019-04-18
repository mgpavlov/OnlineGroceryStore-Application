package org.softuni.onlinegrocery.service;

import org.softuni.onlinegrocery.domain.entities.enumeration.Status;
import org.softuni.onlinegrocery.domain.models.service.OrderServiceModel;

import java.util.List;

public interface OrderService {

    void createOrder(OrderServiceModel orderServiceModel);

    List<OrderServiceModel> findAllOrders();

    List<OrderServiceModel> findOrdersByCustomer(String username);

    OrderServiceModel findOrderById(String id);

    List<OrderServiceModel> findOrdersByStatus(Status status);

    void changeOrderStatus(String id);

    List<OrderServiceModel> findOrdersByCustomerAndStatus(String customerName, Status status);
}
