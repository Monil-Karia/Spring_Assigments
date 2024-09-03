package com.daomainfiles;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;  // For Hibernate 4.x

import com.pojo_orm_classes.Cart_Pojo;
import com.pojo_orm_classes.Items_Pojo;

public class ComponentMapping {

    public static void main(String[] args) throws Exception {
        SessionFactory sessionFactory = new Configuration().configure("hibernatedb.cfg.xml").buildSessionFactory();

        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();

        InputStreamReader i = new InputStreamReader(System.in);
        BufferedReader b = new BufferedReader(i);

        Cart_Pojo cart = new Cart_Pojo();

        System.out.println("Cart ID: ");
        int cartId = Integer.parseInt(b.readLine());
        System.out.println("Total: ");
        int total = Integer.parseInt(b.readLine());
        System.out.println("Name: ");
        String name = b.readLine();

        System.out.println("Item ID: ");
        int itemId = Integer.parseInt(b.readLine());
        System.out.println("Item Total: ");
        int itemTotal = Integer.parseInt(b.readLine());
        System.out.println("Quantity: ");
        int quantity = Integer.parseInt(b.readLine());

        Items_Pojo items = new Items_Pojo();
        items.setCartId(cartId);
        items.setItemId(itemId);
        items.setItemTotal(itemTotal);
        items.setQuantity(quantity);

        cart.setCartId(cartId);
        cart.setTotal(total);
        cart.setName(name);
        cart.setItems(items);

        s.persist(cart); // Insertion happens here
        System.out.println("*****Inserted*****");
        t.commit();

        String query1 = "From Cart_Pojo";
        Query query4 = s.createQuery(query1);
        List<Cart_Pojo> list4 = query4.list();
        for (Cart_Pojo c : list4) {
            System.out.println(c.getCartId() + " " + c.getTotal() + " " + c.getName() + " " +
                c.getItems().getItemId() + " " + c.getItems().getItemTotal() + " " + c.getItems().getQuantity());
        }

        s.close();
    }
}
