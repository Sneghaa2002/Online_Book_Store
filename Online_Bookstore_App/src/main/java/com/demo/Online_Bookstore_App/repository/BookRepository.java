package com.demo.Online_Bookstore_App.repository;
import com.demo.Online_Bookstore_App.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Marks this interface as a repository component, it will be managed by Spring.
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    //  providing CRUD operations for the Book entity.
    // No need to implement methods manually
    //contains in-build methods-sace,findById(), findAll(),delete()

}

