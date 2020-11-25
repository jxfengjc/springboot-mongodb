package com.example.demo.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName MongoTest
 * @Description: TODO
 * @Author fengjc
 * @Date 2020/11/9
 * @Version V1.0
 **/
public class MongoTest {
    private Integer id;//主键id
    private Integer number;//学号
    private Integer age;//年龄
    private String name;//姓名
    private Date createTime;
    private String sex;//性别 1男 2女
    private Integer classs;//班级
    private BigDecimal tuition;//学费
    private String hobby; //爱好
    private String hobbyCode; //0篮球 1足球 2排球 3乒乓球 4羽毛球
    private String introduce;//个人介绍

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getClasss() {
        return classs;
    }

    public void setClasss(Integer classs) {
        this.classs = classs;
    }

    public BigDecimal getTuition() {
        return tuition;
    }

    public void setTuition(BigDecimal tuition) {
        this.tuition = tuition;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getHobbyCode() {
        return hobbyCode;
    }

    public void setHobbyCode(String hobbyCode) {
        this.hobbyCode = hobbyCode;
    }
}
