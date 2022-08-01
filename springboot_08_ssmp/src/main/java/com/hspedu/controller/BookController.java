package com.hspedu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hspedu.domain.Book;
import com.hspedu.service.BookService;
import com.hspedu.service.IbookService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/books")
public class BookController {

    private static final Logger  log= LoggerFactory.getLogger(BookController.class);
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAll() {
        return bookService.getAll();

    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable Integer id) {
        return bookService.delete(id);
    }

    @PutMapping
    public boolean UPDATE(@RequestBody Book book) {
        return bookService.update(book);
    }

    @PostMapping
    public boolean save(@RequestBody Book book) {
        return bookService.insert(book);
    }

    @GetMapping("/{id}")
    public Book getbyId(@PathVariable Integer id) {
        System.out.println("apringboot is running");
//        log.error("error");
//        log.warn("waring");
//        log.info("debug");
        return bookService.getById(id);


    }


}