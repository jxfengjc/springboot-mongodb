package com.example.demo.controller;

import com.example.demo.dao.MongoDao;
import com.example.demo.entity.MongoTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @ClassName TestMondoDB
 * @Description: TODO
 * @Author fengjc
 * @Date 2020/11/9
 * @Version V1.0
 **/
@RestController
public class TestMondoDbController {
    @Autowired
  private   MongoDao mongoDao;
    @GetMapping(value="/test1")
    public String saveTest() throws Exception {
        MongoTest mgtest=new MongoTest();
        mgtest.setId(2);
        mgtest.setAge(02);
        mgtest.setName("ceshi_Student_01");
        mongoDao.saveTest(mgtest);
        System.out.println("success");
        return "add successful !";
    }

    @GetMapping(value="/test2")
    public MongoTest findTestByName(){
        MongoTest mgtest= mongoDao.findTestByName("ceshi_Student");
        System.out.println("mgtest is "+mgtest);
        return mgtest;
    }

    @GetMapping(value="/test3")
    public String updateTest(){
        MongoTest mgtest=new MongoTest();
        mgtest.setId(2);
        mgtest.setAge(445566);
        mgtest.setName("ceshi_Student_update");
        mongoDao.updateTest(mgtest);
        System.out.println("successful !");
        return "update successful !";
    }

    @GetMapping(value="/test4")
    public String deleteTestById(){
        mongoDao.deleteTestById(2);
        return "delete successful !";

    }
}
