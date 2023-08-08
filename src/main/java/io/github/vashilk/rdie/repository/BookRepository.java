package io.github.vashilk.rdie.repository;


import io.github.vashilk.rdie.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Author Neeschal Kissoon created on 03/08/2023
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findBookByAuthor(String author);
}
