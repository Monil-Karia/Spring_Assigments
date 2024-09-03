package com.daomainfiles;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pojo_orm_classes.Post_Pojo;
import com.pojo_orm_classes.Comment_Pojo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CollectionMapping {

    public static void main(String[] args) {
        // Create SessionFactory and Session
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Start transaction
            transaction = session.beginTransaction();

            // Create a Post_Pojo instance
            Post_Pojo post = new Post_Pojo();
            
            System.out.print("Enter post title: ");
            String title = reader.readLine();
            post.setTitle(title);
            
            System.out.print("Enter post description: ");
            String description = reader.readLine();
            post.setDescription(description);
            
            System.out.print("Enter post content: ");
            String content = reader.readLine();
            post.setContent(content);
            
            post.setCreatedAt(new Date());
            post.setUpdatedAt(new Date());

            // Create Comment_Pojo instances
            Set<Comment_Pojo> comments = new HashSet<>();
            for (int i = 1; i <= 2; i++) { // Adjust the loop if you want more or fewer comments
                Comment_Pojo comment = new Comment_Pojo();
                
                System.out.print("Enter comment " + i + " text: ");
                String text = reader.readLine();
                comment.setText(text);
                
                comment.setCreatedAt(new Date());
                comment.setUpdatedAt(new Date());
                
                // Set the relationship
                comment.setPost(post);
                
                comments.add(comment);
            }
            
            // Add comments to the post
            post.setComments(comments);

            // Save the post (which will also save comments due to cascade)
            session.save(post);

            // Commit the transaction
            transaction.commit();
            System.out.println("Post and comments have been inserted successfully.");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            try {
                // Close the reader
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            // Close the session and session factory
            session.close();
            sessionFactory.close();
        }
    }
}
