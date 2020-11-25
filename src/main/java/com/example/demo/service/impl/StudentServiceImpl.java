package com.example.demo.service.impl;

import com.example.demo.dao.MongoDao;
import com.example.demo.entity.MongoTest;
import com.example.demo.service.StudentService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @ClassName StudentServerImpl
 * @Description: TODO
 * @Author fengjc
 * @Date 2020/11/24
 * @Version V1.0
 **/
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    MongoDao mongoDao;
    @Override
    public void down(Integer id, HttpServletResponse response) {
        //文件名称
        String excelName ="test.xlsx";
        //创建excel工作空间
        XSSFWorkbook xssfWorkbook =new XSSFWorkbook();
        //创建sheet
        Sheet sheet =xssfWorkbook.createSheet("sheet1");
        //创建表头
        String [] header ={"序号","学号","姓名","班级","年龄","性别","爱好","备注"};
        int cellNum =header.length;
        Row headerRow =sheet.createRow(0);
        for (int i = 0; i < cellNum; i++) {
            XSSFRichTextString text =new XSSFRichTextString(header[i]);
            headerRow.createCell(i).setCellValue(text);
        }
        List<MongoTest>  list  = mongoDao.findTestById(id);
        if(list != null && list.size()>0){
            //设置行数,行数从第一行开始计数
            int rowNum =1;
            for(MongoTest mongoTest :list){
                Row row = sheet.createRow(rowNum);
                row.createCell(0).setCellValue(mongoTest.getId());
                row.createCell(1).setCellValue(mongoTest.getNumber());
                row.createCell(2).setCellValue(mongoTest.getName());
                row.createCell(3).setCellValue(mongoTest.getClasss());
                row.createCell(4).setCellValue(mongoTest.getAge());
                row.createCell(5).setCellValue("1".equals(mongoTest.getSex())?"男":"女");
                row.createCell(6).setCellValue(mongoTest.getHobby());
                row.createCell(7).setCellValue(mongoTest.getIntroduce());
                rowNum ++;
            }

        }
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + excelName);
        try {
            response.flushBuffer();
            xssfWorkbook.write(response.getOutputStream());
        } catch (IOException e) {
            System.out.println("download qywx excel error:{}"+e);
        }
    }

    @Override
    public Map<Integer, MongoTest> fingMap() {
        Integer id =null;
        List<MongoTest>  list  = mongoDao.findTestById(id);
        Map<Integer,MongoTest> map =list.stream().collect(Collectors.toMap(MongoTest::getId, Function.identity()));

        return map;
    }

}
