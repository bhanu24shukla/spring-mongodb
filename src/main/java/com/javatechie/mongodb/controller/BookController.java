package com.javatechie.mongodb.controller;

import com.javatechie.mongodb.model.Book;
import com.javatechie.mongodb.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/addBook")
    public ResponseEntity<String> saveBook(@RequestBody Book book) {
        bookRepository.save(book);
        return new ResponseEntity<>("Added book with id: " + book.getId(), HttpStatus.OK);
    }

    @GetMapping("/findAllBooks")
    public ResponseEntity<List<Book>> getBooks() {
        return new ResponseEntity<>(bookRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Book>> getBook(@PathVariable int id) {
        return new ResponseEntity<>(bookRepository.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id) {
        bookRepository.deleteById(id);
        return new ResponseEntity<>("Book deleted with id: " + id, HttpStatus.OK);
    }

}
