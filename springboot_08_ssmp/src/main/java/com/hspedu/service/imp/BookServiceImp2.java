package com.hspedu.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hspedu.dao.BookDao;
import com.hspedu.domain.Book;
import com.hspedu.service.IbookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImp2 extends ServiceImpl<BookDao, Book> implements IbookService {
    @Autowired
    BookDao bookDao;

    @Override
    public IPage<Book> getpage(int curentpage, int pagesize) {
        return null;
    }

    @Override
    public IPage<Book> getpage(int curentpage, int pagesize, Book book) {
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper();
        lqw.like(Strings.isNotEmpty(book.getType()),Book::getType,book.getType());
        lqw.like(Strings.isNotEmpty(book.getName()),Book::getName,book.getName());
        lqw.like(Strings.isNotEmpty(book.getDescription()),Book::getDescription,book.getDescription());
        IPage<Book> page=new Page(curentpage,pagesize);
        bookDao.selectPage(page,lqw);
        return page;
    }

    @Override
    public boolean save(Book book) {

        return bookDao.insert(book)>0;
    }
}
