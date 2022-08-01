package com.hspedu.service.imp;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hspedu.dao.BookDao;
import com.hspedu.domain.Book;
import com.hspedu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImp implements BookService {
    @Autowired
    private BookDao bookDao;
    @Override
    public boolean insert(Book book) {
        return bookDao.insert(book)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return bookDao.deleteById(id )>0;
    }

    @Override
    public boolean update(Book book) {
        return bookDao.updateById(book)>0;
    }

    @Override
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }

    @Override
    public IPage<Book> getpage(Integer curentpage, Integer pagesize) {
        IPage page = new Page<>(curentpage,pagesize);

        return bookDao.selectPage(page,null);
    }
}
