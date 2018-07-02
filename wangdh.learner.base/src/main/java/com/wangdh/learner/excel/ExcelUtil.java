package com.wangdh.learner.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * @Auther: dw_wanghonghong
 * @Date: 2018/6/27 14:32
 * @Description:
 */
public class ExcelUtil {
    // private static Logger logger = LoggerFactory.getLogger(ExcelUtil.class);

    public static void main(String[] args){
        String filePath = "C:\\Users\\Administrator\\Desktop\\VipUserTemplate.xlsx";
        File file = new File(filePath);

        InputStream inputStream = null;
        XSSFWorkbook xssfWorkbook = null;
        try{
            inputStream = new FileInputStream(file);
            xssfWorkbook = new XSSFWorkbook(inputStream);
            inputStream.close();

            // 工作表对象
            Sheet sheet = xssfWorkbook.getSheetAt(0);

            // 总行数
            int rowLength = sheet.getLastRowNum() + 1;
            System.out.println("总行数："+ rowLength);

            // 工作表的列
            Row row = sheet.getRow(0);
            // 总列数
            int colLength = row.getLastCellNum();
            System.out.println("总列数："+ colLength);

            Cell cell = row.getCell(0);
            CellStyle cellStyle = cell.getCellStyle();
            for (int j = 0; j < colLength; j++) {
                cell = row.getCell(j);
                //Excel数据Cell有不同的类型，当我们试图从一个数字类型的Cell读取出一个字符串时就有可能报异常：
                //Cannot get a STRING value from a NUMERIC cell
                //将所有的需要读的Cell表格设置为String格式

                System.out.println(cell.getStringCellValue());
            }
            Row newRow = sheet.createRow(rowLength);
            String[] cellValus = {"飘渺冷雨zs","1","2018-03-14","2018-06-11","28518","1","2018-03-14","2018-04-12"};
            for (int j = 0; j < colLength; j++) {
                Cell newCell = newRow.createCell(j);
                newCell.setCellStyle(cellStyle);
                newCell.setCellValue(cellValus[j]);
            }
            OutputStream out = new FileOutputStream(file);
            xssfWorkbook.write(out);



        }catch (Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
