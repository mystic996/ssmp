package com.hspedu.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hspedu.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class BookDaoTestCase {
    @Autowired
    private BookDao bookDao;
    @Test
    void  testGetById(){

        System.out.println(bookDao.selectById(8));
    }
    @Test
    void  testInsert(){

        Book book = new Book();
        book.setName("测试123");
        book.setType("测试132");
        book.setDescription("123");
        bookDao.insert(book);
    }
    @Test
    void  testUpDate(){
        Book book = new Book();
        book.setId(15);
        book.setName("测试123");
        book.setType("测试132");
        book.setDescription("测试abcdefg");
        bookDao.updateById(book);

    }
    @Test
    void  testGetDelete(){


    }

    @Test
    void  testGetAll(){
        System.out.println(      bookDao.selectList(null));

    }
    @Test

    void  testGetByFilter(){
        String name="spring";
        LambdaQueryWrapper<Book> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like( name!=null,Book::getName,name );
        bookDao.selectList(lambdaQueryWrapper);

    }
    @Test
    void  testGetPage(){
        IPage page = new Page(2, 5);

        bookDao.selectPage(page,null);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
        System.out.println();

    }


}



