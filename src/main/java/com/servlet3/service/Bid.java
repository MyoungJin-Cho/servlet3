package com.servlet3.service;

import java.math.BigDecimal;

public class Bid {

    private String id;
    private BigDecimal price;

    public Bid(BigDecimal price) {
        this.price = price;
        this.id = "alma";
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
