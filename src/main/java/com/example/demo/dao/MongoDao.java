package com.example.demo.dao;

import com.example.demo.entity.MongoTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;


import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;


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
     * @param list
     */
    public void saveTest(List<MongoTest> list){
        //insert 和save的区别
        //insert 若新增的主键已经存在则会抛出异常，save会修改当前存在的数据
        //insert 可以一次性插入整个列表，而不用遍历操作，效率高，save则时循环插入
      //  mongoTemplate.save(mongoTest,"student");
        mongoTemplate.insert(list,"student");
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
     * 根据用户id查询对象
     * @param id
     * @return
     */
    public List<MongoTest> findTestById(Integer id){

        Query query =new Query();
        Criteria criteria =new Criteria();
        if(id !=null){
            criteria.and("id").is(id);
        }
        query.addCriteria(criteria);
        List<MongoTest> mongoTest =   mongoTemplate.find(query,MongoTest.class,"student");
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
    public List<MongoTest> testAL(){


        return null;
    }


    public static void main(String[] args) {

    }

}
