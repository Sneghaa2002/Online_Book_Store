package com.demo.Online_Bookstore_App.controller;

import com.demo.Online_Bookstore_App.entity.Book;
import com.demo.Online_Bookstore_App.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marks this class as a REST controller
@RequestMapping("/books") // Base URL for this controller
public class BookController {

    @Autowired // Injects the BookService dependency
    private BookService bookService;

    @PostMapping // Handles HTTP POST requests to add a new book
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping // Handles HTTP GET requests to fetch all books
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}") // Handles HTTP GET requests to fetch a book by its ID
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PutMapping("/{id}") // Handles HTTP PUT requests to update a book by its ID
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}") // Handles HTTP DELETE requests to delete a book by its ID
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}

