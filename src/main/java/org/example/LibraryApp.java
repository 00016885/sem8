package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class LibraryApp {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("library_pu");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Book book = new Book();
        book.setTitle("Pride and Prejudice");
        book.setAuthor("Jane Austin");

        em.persist(book);
        em.getTransaction().commit();

        System.out.println("Book saved: "+book.getTitle()+", "+book.getAuthor());
        em.close();
        emf.close();
    }
}
