package com.example.demo.server;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName StudentServer
 * @Description: TODO
 * @Author fengjc
 * @Date 2020/11/24
 * @Version V1.0
 **/
@Service
public interface StudentServer {
    public void down(Integer id,HttpServletResponse response);
}
