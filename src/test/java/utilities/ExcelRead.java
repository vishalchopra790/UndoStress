package utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelRead {
    public static void main(String[] args) throws IOException {
        String file="src/test/resources/stu.xlsx";
        FileInputStream fis=new FileInputStream(file);
        XSSFWorkbook workbook=new XSSFWorkbook(fis);
        XSSFSheet sheet=workbook.getSheetAt(0);
        int rows=sheet.getLastRowNum();
        Map<String, String> data =new HashMap<>();
        for (int r=0;r<rows;r++){
             String key=sheet.getRow(r).getCell(0).getStringCellValue();
            String value=sheet.getRow(r).getCell(1).getStringCellValue();
            data.put(key,value);


        }
        for (Map.Entry entry:data.entrySet()){
            System.out.println(entry.getValue()+"  "+entry.getKey());
        }
    }
}
