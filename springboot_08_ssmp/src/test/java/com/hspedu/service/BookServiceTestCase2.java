package com.hspedu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hspedu.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookServiceTestCase2 {
    QueryWrapper<Book> wrapper = new QueryWrapper<>();
    Book book = new Book();
    @Autowired
    private IbookService ibookService;
    @Test
    void testGetById (){
        System.out.println(ibookService.getById(6));

    }
@Test
    void  testInsert(){


        book.setName("测试abcdefg");
        book.setType("测试132");
        book.setDescription("123");
        ibookService.save(book);
    }
    @Test
    void  testUpDate(){

        book.setId(null);
        book.setName("测试12366666");
        book.setType("测试132");
        book.setDescription("测试123");
        ibookService.updateById(book);

    }
    @Test
    void  testDelete(){
ibookService.removeById(15);

    }
    @Test
    void testGetall(){
ibookService.list(null);
    }
    @Test
    void testGetby(){


        wrapper.like("name","java");
        List<Book> list = ibookService.list(wrapper);
        System.out.println(list);
    }
@Test
    void testgetPage(){
    IPage<Book> page=new Page<>(2,3);
        ibookService.page(page);
    }

}
