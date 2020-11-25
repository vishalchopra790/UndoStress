package utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class WriteExcel {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet  sheet=workbook.createSheet("Employee");

//        Object employee[][]={
//                {"Emp Id","Name","Job"},
//                {101,"Vishal","Engineer"},
//                {102,"Sahil","Sales"}
//
//        };
        ArrayList<Object[]> employee = new ArrayList<>();
        employee.add(new Object[]{"Emp Id","Name","Job"});
        employee.add(new Object[]{101,"Vishal","Engineer"});
        employee.add(new Object[]{102,"Sahil","Sales"});

//        int rows=employee.length;
//        int cols=employee[0].length;
//
//        for(int r=0;r<rows;r++)
//        {
//            XSSFRow row=sheet.createRow(r);
//            for(int c=0;c<cols;c++)
//            {
//                XSSFCell cell=row.createCell(c);
//                Object value=employee[r][c];
//                if(value instanceof String )
//                    cell.setCellValue((String) value);
//                if(value instanceof Integer )
//                    cell.setCellValue((Integer) value);
//                if(value instanceof Boolean )
//                    cell.setCellValue((Boolean) value);
//
//            }
//        }

        //for each
        int rowcount=0;
        for(Object emp[]:employee){
           XSSFRow row= sheet.createRow(rowcount++);
           int colcount=0;
            for(Object value:emp){
                 XSSFCell cell=row.createCell(colcount++);
                if(value instanceof String )
                    cell.setCellValue((String) value);
                if(value instanceof Integer )
                    cell.setCellValue((Integer) value);
                if(value instanceof Boolean )
                    cell.setCellValue((Boolean) value);
            }
        }
        String file="src\\test\\resources\\employee.xlsx";
        File file1;
        FileOutputStream outputStream=new FileOutputStream(file);
        workbook.write(outputStream);
    }
}
