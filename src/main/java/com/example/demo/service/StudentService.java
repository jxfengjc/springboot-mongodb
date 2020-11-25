package com.example.demo.service;

import com.example.demo.entity.MongoTest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @ClassName StudentServer
 * @Description: TODO
 * @Author fengjc
 * @Date 2020/11/24
 * @Version V1.0
 **/
@Service
public interface StudentService {
    public void down(Integer id,HttpServletResponse response);
    public Map<Integer, MongoTest> fingMap();
}
