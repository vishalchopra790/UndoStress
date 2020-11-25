package utilities;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelHashMap {
    public static void main(String[] args) throws IOException {

        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet("data");

        Map<String, String> data = new HashMap<>();
        data.put("101","Vishal");
        data.put("102","Sahil");
        data.put("103","Rajesh");
        data.put("104","Alka");
        data.put("105","Ashish");

        int rowno=0;

        for(Map.Entry entry:data.entrySet()){
            XSSFRow row=sheet.createRow(rowno++);
            row.createCell(0).setCellValue((String)entry.getKey());
            row.createCell(1).setCellValue((String)entry.getValue());

        }

        String file="src/test/resources/stu.xlsx";
        FileOutputStream fos=new FileOutputStream(file);
        workbook.write(fos);
        System.out.println("data generated");
    }
}
