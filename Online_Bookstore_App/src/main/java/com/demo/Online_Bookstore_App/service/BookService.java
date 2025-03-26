package com.demo.Online_Bookstore_App.service;

import com.demo.Online_Bookstore_App.entity.Book;
import com.demo.Online_Bookstore_App.exception.ResourceNotFoundException;
import com.demo.Online_Bookstore_App.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// making it a Spring-managed bean.
@Service
public class BookService {

    // Injects an instance of BookRepository to handle database operations.
    @Autowired
    private BookRepository bookRepository;

    // Method to add a new book to the database.
    public Book addBook(Book book) {
        return bookRepository.save(book); // Saves the book entity and returns the saved instance.
    }

    // Method to retrieve all books from the database.
    public List<Book> getAllBooks() {
        return bookRepository.findAll(); // Fetches all books from the database.
    }

    // Method to retrieve a book by its ID. Throws an exception if not found.
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with ID: " + id));
    }

    // Method to update book details. If the book exists, it updates the details and saves them.
    public Book updateBook(Long id, Book updatedBook) {
        Book book1 = getBookById(id); // Fetch the book or throw an exception if not found.
        book1.setTitle(updatedBook.getTitle());
        book1.setAuthor(updatedBook.getAuthor());
        book1.setPrice(updatedBook.getPrice());
        book1.setPublishedDate(updatedBook.getPublishedDate());
        return bookRepository.save(book1); // Save and return the updated book.
    }

    // Method to delete a book by ID. Throws an exception if the book is not found.
    public void deleteBook(Long id) {
        Book book = getBookById(id); // Fetch the book or throw an exception if not found.
        bookRepository.delete(book); // Deletes the book from the database.
    }
}
