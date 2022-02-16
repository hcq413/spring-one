package com.service_impl;

import com.domain.Book;
import com.mapper.BookMapper;
import com.service.Bookservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Booksercviceimpl implements Bookservice {

    @Autowired
    BookMapper mapper;

    @Override
    public ArrayList<Book> getBook() {
        return (ArrayList<Book>) mapper.selectAll();
    }

    @Override
    public ArrayList<Book> getBookAndBook() {
        return (ArrayList<Book>) mapper.bookandBookResult();
    }

    @Override
    public ArrayList<Book> Groundbybook() {
        return (ArrayList<Book>) mapper.bookandBookResultGroipby();
    }

    @Override
    public Integer addBook(Book book) {
        return mapper.insert(book);
    }

    @Override
    public Book getBookbyid(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer updateBook(Book book) {
        return mapper.updateByPrimaryKey(book);
    }

    @Override
    public Integer deleteByPrimaryKey(int id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public ArrayList<Book> getBookbyname(Book book) {
        return (ArrayList<Book>) mapper.selecltbyusername(book);
    }

}
