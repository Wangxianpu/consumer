package com.wxp.mix.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HelloWorldMapper {

    List<String> sayHello(@Param("name") String name);


}
