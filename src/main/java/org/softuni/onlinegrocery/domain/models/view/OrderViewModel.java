package org.softuni.onlinegrocery.domain.models.view;

import org.softuni.onlinegrocery.domain.entities.enumeration.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class OrderViewModel {

    private String id;
    private List<OrderProductViewModel> products;
    private UserProfileViewModel customer;
    private BigDecimal totalPrice;
    private LocalDateTime issuedOn;
    private LocalDateTime statusDate;
    private Status status;

    public OrderViewModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<OrderProductViewModel> getProducts() {
        return this.products;
    }

    public void setProducts(List<OrderProductViewModel> products) {
        this.products = products;
    }

    public UserProfileViewModel getCustomer() {
        return customer;
    }

    public void setCustomer(UserProfileViewModel customer) {
        this.customer = customer;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getIssuedOn() {
        return this.issuedOn;
    }

    public void setIssuedOn(LocalDateTime issuedOn) {
        this.issuedOn = issuedOn;
    }

    public LocalDateTime getStatusDate() {
        return this.statusDate;
    }

    public void setStatusDate(LocalDateTime statusDate) {
        this.statusDate = statusDate;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
