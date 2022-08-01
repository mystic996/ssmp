package com.hspedu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hspedu.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookDao extends BaseMapper<Book> {
    //mybatis做法
//    @Select("select * from book where id=#{id}")
//    Book getById(Integer id);
    //mybatis plus做法


}
