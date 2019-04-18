package org.softuni.onlinegrocery.domain.models.view;

import java.time.LocalDateTime;

public class MyOrderViewModel {

    private String id;
    private LocalDateTime issuedOn;
    private LocalDateTime statusDate;

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
}
