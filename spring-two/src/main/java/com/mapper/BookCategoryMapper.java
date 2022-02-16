package com.mapper;

import com.domain.BookCategory;

import java.util.List;

public interface BookCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookCategory record);

    int insertSelective(BookCategory record);

    BookCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BookCategory record);

    int updateByPrimaryKey(BookCategory record);

    List<BookCategory> selectall();


}