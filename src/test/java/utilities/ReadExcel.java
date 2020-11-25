package utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class ReadExcel {
    public static void main(String[] args) throws IOException {
        String file = "src\\test\\resources\\Data.xlsx";
        FileInputStream input = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(input);
        XSSFSheet sheet = workbook.getSheetAt(0);
//        int rows=sheet.getLastRowNum();
//        int cols=sheet.getRow(1).getLastCellNum();
//        for(int r=0;r<=rows;r++){
//            XSSFRow row=sheet.getRow(r);
//            for(int c=0;c<cols;c++){
//                XSSFCell cell=row.getCell(c);
//                switch(cell.getCellType()){
//                    case STRING :
//                        System.out.print(cell.getStringCellValue());
//                        break;
//                    case NUMERIC:
//                        System.out.print(cell.getNumericCellValue());
//                        break;
//                    case BOOLEAN:
//                        System.out.print(cell.getBooleanCellValue());
//                        break;
//
//                }
//
//                System.out.print(" | ");
//
//            }
//            System.out.println();
//        }
        Iterator iterator = sheet.iterator();
        while (iterator.hasNext()) {
            XSSFRow row = (XSSFRow) iterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                XSSFCell cell = (XSSFCell) cellIterator.next();
                switch (cell.getCellType()) {
                    case STRING:
                        System.out.print(cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue());
                        break;
                    case BOOLEAN:
                        System.out.print(cell.getBooleanCellValue());
                        break;
                }
                System.out.print(" |  ");
            }
            System.out.println();
        }
    }
}
