package com.example.books.controller;

import com.example.books.domain.Book;
import com.example.books.dto.BookPostDTO;
import com.example.books.dto.BookPutDTO;
import com.example.books.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService service;

    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Book> save(@RequestBody BookPostDTO bookPostDTO) {
        return new ResponseEntity<>(service.save(bookPostDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody BookPutDTO bookPutDTO) {
        service.replace(bookPutDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
