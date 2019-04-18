package org.softuni.onlinegrocery.domain.models.service;



import org.softuni.onlinegrocery.domain.entities.Order;
import org.softuni.onlinegrocery.domain.entities.User;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ReceiptServiceModel {

    private String id;
    private BigDecimal fee;
    private LocalDateTime issuedOn;
    private User recipient;
    private Order order;

    public ReceiptServiceModel() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NotNull
    public BigDecimal getFee() {
        return this.fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    @NotNull
    public LocalDateTime getIssuedOn() {
        return this.issuedOn;
    }

    public void setIssuedOn(LocalDateTime issuedOn) {
        this.issuedOn = issuedOn;
    }

    @NotNull
    public User getRecipient() {
        return this.recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    @NotNull
    public Order getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
