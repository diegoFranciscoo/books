package com.example.books.service;

import com.example.books.domain.Book;
import com.example.books.dto.BookPostDTO;
import com.example.books.dto.BookPutDTO;
import com.example.books.mapper.BookMapper;
import com.example.books.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository repository;
    private final BookMapper bookMapper;

    public List<Book> findAll() {
        return repository.findAll();
    }

    public Book findById(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("book not found, please check id"));
    }

    public Book save(BookPostDTO bookPostDTO) {
        return repository.save(bookMapper.toBook(bookPostDTO));
    }

    public void replace(BookPutDTO bookPutDTO) {
        findById(bookPutDTO.id());
        repository.save(bookMapper.toBook(bookPutDTO));
    }

    public void delete(String id) {
        repository.delete(findById(id));
    }
}
