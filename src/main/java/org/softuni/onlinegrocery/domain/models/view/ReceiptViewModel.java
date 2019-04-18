package org.softuni.onlinegrocery.domain.models.view;



import org.softuni.onlinegrocery.domain.entities.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ReceiptViewModel {

    private String id;
    private BigDecimal fee;
    private LocalDateTime issuedOn;
    private User recipient;

    public ReceiptViewModel() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getFee() {
        return this.fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public LocalDateTime getIssuedOn() {
        return this.issuedOn;
    }

    public void setIssuedOn(LocalDateTime issuedOn) {
        this.issuedOn = issuedOn;
    }

    public User getRecipient() {
        return this.recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }
}
