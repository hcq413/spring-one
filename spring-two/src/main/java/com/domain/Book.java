package com.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Integer id;

    private String name;

    private Integer categoryId;

    private Date publishTime;

    private BigDecimal price;

    private String publishName;

    private Date selfTime;

    private BookCategory bookCategory;

}