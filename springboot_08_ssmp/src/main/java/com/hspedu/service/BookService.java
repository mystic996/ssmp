package com.hspedu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hspedu.domain.Book;

import java.util.List;

public interface BookService {
    public boolean insert(Book book);
    public boolean delete(Integer id);
    public boolean update(Book book);
    public Book  getById(Integer id);
    public List<Book> getAll();
    public IPage<Book> getpage(Integer curentpage,Integer pagesize);
}
