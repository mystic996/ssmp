package com.hspedu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hspedu.domain.Book;

public interface IbookService extends IService<Book> {
    IPage<Book> getpage(int curentpage, int pagesize);
    IPage<Book> getpage(int curentpage, int pagesize, Book book);
  boolean save(Book book);
}
