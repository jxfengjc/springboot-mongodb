package com.example.demo.dao;

import com.example.demo.entity.MongoTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;


import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;


/**
 * @ClassName MongoDao
 * @Description: TODO
 * @Author fengjc
 * @Date 2020/11/9
 * @Version V1.0
 **/
@Component
public class MongoDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 创建对象
     * @param mongoTest
     */
    public void saveTest(MongoTest mongoTest){
        mongoTemplate.save(mongoTest,"student");
    }

    /**
     * 根据用户名查询对象
     * @param name
     * @return
     */
    public MongoTest findTestByName(String name){

        Query query =new Query(Criteria.where("name").is(name));
        MongoTest mongoTest =   mongoTemplate.findOne(query,MongoTest.class,"student");
        return mongoTest;
    }

    /**
     * 更改对象
     * @param test
     */
    public void updateTest(MongoTest test){
        Query query =new Query(Criteria.where("id").is(test.getId()));
        Update update =new Update().set("name",test.getName()).set("age",test.getAge());
        //更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query,update,MongoTest.class,"student");
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,TestEntity.class);
    }
    /**
     * 删除对象
     * @param id
     */
    public void deleteTestById(Integer id) {
        Query query=new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,MongoTest.class,"student");
    }


}
