package com.service;

import com.domain.Book;

import java.util.List;

public interface Bookservice {

    List<Book> getBook();

    List<Book> getBookAndBook();


    List<Book> Groundbybook();

    Integer addBook(Book book);

    Book getBookbyid(int id);

    Integer updateBook(Book book);

    Integer deleteByPrimaryKey(int id);

    List<Book> getBookbyname(Book book);


}
