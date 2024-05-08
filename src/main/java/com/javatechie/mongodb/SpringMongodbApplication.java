package com.javatechie.mongodb;

import com.javatechie.mongodb.model.Book;
import com.javatechie.mongodb.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringMongodbApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringMongodbApplication.class, args);
    }

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        Book book1 = Book.builder().id(1).bookName("To Kill a Mockingbird").authorName("Harper Lee").build();
        Book book2 = Book.builder().id(2).bookName("1984").authorName("George Orwell").build();
        Book book3 = Book.builder().id(3).bookName("The Catcher in the Rye").authorName("J.D. Salinger").build();
        Book book4 = Book.builder().id(4).bookName("Pride and Prejudice").authorName("Jane Austen").build();
        Book book5 = Book.builder().id(5).bookName("The Great Gatsby").authorName("F. Scott Fitzgerald").build();

        bookRepository.saveAll(List.of(book1,book2,book3,book4,book5));
    }
}
