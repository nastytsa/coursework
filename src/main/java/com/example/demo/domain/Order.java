package com.example.demo.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order", schema = "")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String text;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User customer;

    private BigDecimal price;

    private boolean status;

    public Order(String text, User customer) {
        this.text = text;
        this.customer = customer;
        this.price = new BigDecimal(0.00);
        this.status = false;
    }

    public Order() {
    }

    public String getCustomerName(){
        return customer != null ? customer.getUsername() : "<none>";
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
