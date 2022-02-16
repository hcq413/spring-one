package com.service_impl;

import com.domain.BookCategory;
import com.mapper.BookCategoryMapper;
import com.service.BookCategoryservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class BookCategoryimpl implements BookCategoryservice {

    @Autowired
    BookCategoryMapper book;


    @Override
    public ArrayList<BookCategory> getall() {
        return (ArrayList<BookCategory>) book.selectall();
    }

}
