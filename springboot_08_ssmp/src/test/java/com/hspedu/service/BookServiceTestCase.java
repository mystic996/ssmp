package com.hspedu.service;

import com.hspedu.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTestCase {
    Book book = new Book();
    @Autowired
    private BookService bookService;
    @Test
    void testGetById (){
        System.out.println(bookService.getById(4));

    }
@Test
    void  testInsert(){


        book.setName("测试123");
        book.setType("测试132");
        book.setDescription("123");
        bookService.insert(book);
    }
    @Test
    void  testUpDate(){

        book.setId(16);
        book.setName("测试123");
        book.setType("测试132");
        book.setDescription("测试123");
        bookService.update(book);

    }
    @Test
    void  testDelete(){
bookService.delete(15);

    }
    @Test
    void testGetall(){
bookService.getAll();
    }
@Test
    void testgetPage(){
        bookService.getpage(1,3);
    }

}
