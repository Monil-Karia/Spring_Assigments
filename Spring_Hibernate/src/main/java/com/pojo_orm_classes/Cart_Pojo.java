package com.pojo_orm_classes;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a cart entity.
 */
@Entity
@Table(name = "fis_hibcart")
public class Cart_Pojo {
    @Id
    @Column(name = "cart_id")
    int cartId;

    @Column(name = "total")
    int total;

    @Column(name = "name", length = 15)
    String name;

    @Embedded
    Items_Pojo items;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Items_Pojo getItems() {
        return items;
    }

    public void setItems(Items_Pojo items) {
        this.items = items;
    }
}
