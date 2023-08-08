package io.github.vashilk.rdie.controller;


import io.github.vashilk.rdie.model.entity.Book;
import io.github.vashilk.rdie.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author Neeschal Kissoon created on 03/08/2023
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BooksController {

    private final BookService bookService;

    @PostMapping("/save")
    public void saveBook(@RequestBody Book book) {
        bookService.saveBook(book);
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping()
    public Book getBook(@RequestParam String author) {
        return bookService.getBookByAuthor(author);
    }

    @PutMapping("/update")
    public void update(@RequestBody Book book) {
        bookService.update(book);
    }

    @GetMapping("/release")
    public void releaseCache() {
        bookService.releaseCache();
    }
}
