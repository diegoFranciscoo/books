package com.example.books.mapper;

import com.example.books.domain.Book;
import com.example.books.dto.BookPostDTO;
import com.example.books.dto.BookPutDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book toBook(BookPostDTO bookPostDTO);
    Book toBook(BookPutDTO bookPutDTO);
}
