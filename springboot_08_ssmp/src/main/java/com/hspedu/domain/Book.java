package com.hspedu.domain;

import lombok.Data;

@Data

public class Book {
    private Integer id;
    private String type;
    private String name;
    private String  description;

    public Book() {
    }
}
