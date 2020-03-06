/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.eCommerceSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
/**
 *
 * @author Adam
 */
@Entity
public class OrderProduct {
    
    @EmbeddedId
    @JsonIgnore
    private OrderProductPK pk;
    
    @Column(nullable = false)
    private Integer quantity;

    public OrderProduct(OrderProductPK pk, Integer quantity) {
        this.pk = pk;
        this.quantity = quantity;
    }
    
    public OrderProduct(Order order, Product product, Integer quantity){
        pk = new OrderProductPK();
        pk.setOrder(order);
        pk.setProduct(product);
        this.quantity = quantity;
    }
    
    @Transient
    public Product getProduct(){
        return this.pk.getProduct();
    }

    public OrderProductPK getPk() {
        return pk;
    }

    public void setPk(OrderProductPK pk) {
        this.pk = pk;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    @Transient
    public Double getTotalPrice(){
        return getProduct().getPrice() * getQuantity();
    }
    
    public OrderProduct(){
        super();
    }
    
    
    
}
