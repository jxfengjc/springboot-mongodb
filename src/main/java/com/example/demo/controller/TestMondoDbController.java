package com.example.demo.controller;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import com.example.demo.dao.MongoDao;
import com.example.demo.entity.MongoTest;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

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
    private MongoDao mongoDao;
    @Autowired
    private StudentService studentService;
    @GetMapping(value = "/save")
    public String saveTest() throws Exception {
        List<MongoTest> list =new ArrayList<>();
        MongoTest mgtest = new MongoTest();
        mgtest.setId(4);
        mgtest.setNumber(2020004);
        mgtest.setAge(18);
        mgtest.setName("刘能");
        mgtest.setCreateTime(new Date());
        mgtest.setSex("1");
        mgtest.setClasss(1);
        mgtest.setTuition(new BigDecimal("5000.15"));
        mgtest.setHobby("篮球,乒乓球,羽毛球");
        mgtest.setHobbyCode("0,3,4");
        mgtest.setIntroduce("我性格开朗，健谈，常常面带笑容，喜欢以微笑待人，喜欢把自己的快乐与所有的人分享");
        list.add(mgtest);
        MongoTest mgtest1 = new MongoTest();
        mgtest1.setId(5);
        mgtest1.setNumber(2020005);
        mgtest1.setAge(18);
        mgtest1.setName("张三丰");
        mgtest1.setCreateTime(new Date());
        mgtest1.setSex("2");
        mgtest1.setClasss(1);
        mgtest1.setTuition(new BigDecimal("5000.15"));
        mgtest1.setHobby("篮球,足球,乒乓球，羽毛球");
        mgtest1.setHobbyCode("0,1,3,4");
        mgtest1.setIntroduce("我性格开朗，健zz谈，常常面带笑容，喜欢以微笑待人，喜欢把自己的快乐与所有的人分享");
        list.add(mgtest1);
        MongoTest mgtest2 = new MongoTest();
        mgtest2.setId(6);
        mgtest2.setNumber(2020006);
        mgtest2.setAge(19);
        mgtest2.setName("许世荣");
        mgtest2.setCreateTime(new Date());
        mgtest2.setSex("2");
        mgtest2.setClasss(2);
        mgtest2.setTuition(new BigDecimal("5000.19"));
        mgtest2.setHobby("足球");
        mgtest2.setHobbyCode("1");
        mgtest2.setIntroduce("我性格zzzz开朗，健谈，常常面带笑容，喜欢以微笑待人，喜欢把自己的快乐与所有的人分享");
        list.add(mgtest2);
        mongoDao.saveTest(list);
        System.out.println("success");
        return "add successful !";
    }

    @GetMapping(value = "/find/{name}")
    public MongoTest findTestByName(String name) {
        MongoTest mgtest = mongoDao.findTestByName(name);
        System.out.println("mgtest is " + mgtest);
        return mgtest;
    }

    @GetMapping(value = "/update/{id}")
    public String updateTest(Integer id) {
        MongoTest mgtest = new MongoTest();
        mgtest.setId(id);
        mgtest.setAge(445566);
        mgtest.setName("修改人"+id);
        mongoDao.updateTest(mgtest);
        System.out.println("successful !");
        return "update successful !";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteTestById(Integer id) {
        mongoDao.deleteTestById(id);
        return "delete successful !";

    }
    @GetMapping(value = "/down/{id}")
    public void downLoadStudent(Integer id, HttpServletResponse response){
        studentService.down(id,response);
    }


    @GetMapping(value = "/getMap")
    public String getMap(Integer id){
        Map<Integer, MongoTest> integerMongoTestMap = studentService.fingMap();
        System.out.println(integerMongoTestMap.get(id).getName());
        return integerMongoTestMap.get(id).toString();
    }
}
