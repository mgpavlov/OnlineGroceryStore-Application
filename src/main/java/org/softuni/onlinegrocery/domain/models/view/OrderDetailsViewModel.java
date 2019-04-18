package org.softuni.onlinegrocery.domain.models.view;

import net.bytebuddy.agent.builder.AgentBuilder;
import org.softuni.onlinegrocery.domain.entities.User;
import org.softuni.onlinegrocery.domain.entities.enumeration.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class OrderDetailsViewModel {

    private String id;
    private LocalDateTime issuedOn;
    private LocalDateTime statusDate;
    private String shippingAddress;
    private List<ShoppingCartItem> items;
    private Status status;
    private BigDecimal totalPrice;
    private User customer;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getShippingAddress() {
        return this.shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public List<ShoppingCartItem> getItems() {
        return this.items;
    }

    public void setItems(List<ShoppingCartItem> items) {
        this.items = items;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public User getCustomer() {
        return this.customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }
}
