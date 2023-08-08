package io.github.vashilk.rdie.service;


import io.github.vashilk.rdie.model.entity.Book;
import io.github.vashilk.rdie.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.nki.redis.cache.annotations.CacheRelease;
import org.nki.redis.cache.annotations.CacheSave;
import org.nki.redis.cache.annotations.CacheSync;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Author Neeschal Kissoon created on 03/08/2023
 */

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    @CacheSync(group = "Book")
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    @CacheSave(group = "Book")
    public Book getBookById(Long id) {
        return Optional
                .ofNullable(id)
                .flatMap(bookRepository::findById)
                .orElse(null);
    }

    @CacheSave(group = "Book")
    public Book getBookByAuthor(String author) {
        return Optional
                .ofNullable(author)
                .flatMap(bookRepository::findBookByAuthor)
                .orElse(null);
    }

    @CacheSync(group = "Book")
    public void update(Book book) {
        Optional.ofNullable(book.getId())
                .flatMap(bookRepository::findById)
                .map(entity -> {
                    entity.setAuthor(book.getAuthor());
                    entity.setTitle(book.getTitle());
                    return entity;
                })
                .ifPresent(bookRepository::save);
    }

    @CacheRelease(group = "Book")
    public void releaseCache() {

    }
}
