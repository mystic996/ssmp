package com.hspedu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hspedu.controller.utils.R;
import com.hspedu.domain.Book;
import com.hspedu.service.IbookService;
import org.apache.juli.logging.LogFactory;
import org.apache.logging.log4j.spi.LoggerContextFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/books")
public class BookController2 {

    @Autowired
    private IbookService ibookService;

    @GetMapping
    public R getAll() {
        R r = new R(true, ibookService.list());
        return r;

    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        R r = new R(ibookService.removeById(id));


        return r;


    }

    @PutMapping
    public R UPDATE(@RequestBody Book book) {
        R r = new R(ibookService.updateById(book));


        return r;
    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {


//        R r = new R(ibookService.save(book));


 if (book.getName().equals("123"))throw new  IOException();
        boolean flag = ibookService.save(book);
        return new R(flag,flag?"添加成功^_^":"添加失败-_-!");
    }

    @GetMapping("/{id}")
    public R getbyId(@PathVariable Integer id) {
        System.out.println("热部署...12222222222222222");

        R r = new R(true, ibookService.getById(id));

        return r;

    }

//    @GetMapping("{currentpage}/{pagesize}")
//    public R getpage(@PathVariable int currentpage, @PathVariable int pagesize) {
//        IPage<Book> page = ibookService.getpage(currentpage, pagesize);
//        if (currentpage>page.getPages()){
//            page = ibookService.getpage((int) page.getPages(), pagesize);
//        }
//        return   new R(true,page);
//
//    }
@GetMapping("{currentpage}/{pagesize}")
public R getpage(@PathVariable int currentpage, @PathVariable int pagesize,Book book) {
    IPage<Book> page = ibookService.getpage(currentpage, pagesize,book);
    if (currentpage>page.getPages()){
        page = ibookService.getpage((int) page.getPages(), pagesize,book);
    }
    return   new R(true,page);

}
}