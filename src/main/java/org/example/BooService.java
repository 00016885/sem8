package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class BooService {
    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("library_pu");

    public void addBook(String title, String author){
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        em.persist(book);
        em.getTransaction().commit();

        System.out.println("New book inserted: "+book.getId()+", "+book.getTitle()+", "+book.getAuthor());
        em.close();
    }

    public Book getBookById(int id){
        EntityManager em = emf.createEntityManager();
        Book book = em.find(Book.class, id);
        em.close();

        if (book != null){
            System.out.println("Found book: "+book.getTitle()+", "+book.getAuthor());
        }else {
            System.out.println("Book with ID: "+id+"not found");
        }
        return book;

    }

}
