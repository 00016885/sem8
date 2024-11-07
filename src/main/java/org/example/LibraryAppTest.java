package org.example;

public class LibraryAppTest {
    public static void main(String[] args) {
        BooService service = new BooService();
        service.addBook("Pride and Prejudice", "Jane Austen");
        Book book = service.getBookById(1);
        if (book != null){
            System.out.println("Book is not null");
        }
    }
}
