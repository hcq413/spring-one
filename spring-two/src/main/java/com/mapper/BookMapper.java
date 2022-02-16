package com.mapper;

import com.domain.Book;

import java.util.List;

public interface BookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    List<Book> selectAll();


    List<Book> bookandBookResult();

    List<Book> bookandBookResultGroipby();


    List<Book> selecltbyusername(Book record);
}