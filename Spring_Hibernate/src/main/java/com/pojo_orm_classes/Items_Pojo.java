package com.pojo_orm_classes;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Represents items in a cart.
 */
@Embeddable
public class Items_Pojo {
    @Column(name = "cart_id")
    int cartId;

    @Column(name = "item_id")
    int itemId;

    @Column(name = "item_total")
    int itemTotal;

    @Column(name = "quantity")
    int quantity;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(int itemTotal) {
        this.itemTotal = itemTotal;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
