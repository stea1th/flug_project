package flug.project.xlsreader;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import javax.swing.text.html.HTMLDocument;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XLSReader {

     public static List<String[]> readXLS(String url) throws IOException{
        List<String> stringList = new ArrayList<>();
        List<String[]> result = new ArrayList<>();
        FileInputStream input = new FileInputStream(new File(url));
        HSSFWorkbook workbook = new HSSFWorkbook(input);
        HSSFSheet sheet = workbook.getSheetAt(0);
        //Sheet sheet  = workbook.getSheetAt(0); // Get Your Sheet.

        /*for (Row row : sheet) { // For each Row.
            Cell cell = row.getCell(21); // Get the Cell at the Index / Column you want.
            CellType cellType = cell.getCellTypeEnum();
            if(cellType.equals(CellType.STRING)) {
                System.out.println(String.format("%20s", cell.getStringCellValue()));
            }
        }*/

         for (Row row : sheet) {
             Iterator<Cell> cellIterator = row.cellIterator();
             int count = 0;

             while (cellIterator.hasNext()) {
                 count++;
                 Cell cell = cellIterator.next();
                 int index = cell.getColumnIndex();
                 CellType cellType = cell.getCellTypeEnum();
                 if (count < index) {
                     stringList.add("");
                     //System.out.print("NULL      " + count);
                     //System.out.print("\t");
                     count = index;
                 }
                 switch (cellType) {
                     case STRING:
                         //stringList.add(cell.getStringCellValue());
                         stringList.add(cell.getStringCellValue());
                         //System.out.print("StringCell" + index);
                         //System.out.print("\t");
                         break;
                     case NUMERIC:
                         stringList.add(Double.valueOf(cell.getNumericCellValue()).toString());
                         //System.out.print("NumericCell" + index);
                         //System.out.print("\t");
                         break;
                 }


                 /*if (cellType.equals(CellType.STRING)) {
                  *//*System.out.print(String.format("%20s", cell.getStringCellValue()));
                    System.out.print("\t");*//*
                    stringList.add(cell.getStringCellValue());
                }else if(cellType.equals(CellType._NONE)&&cellType.equals(CellType.BLANK)){
                    stringList.add("null");
                }*/
             }
//
             if (stringList.size() == 25) {
//                System.out.println(String.format("%5s %8s %8s",stringList.get(18).replace(".0", ""), stringList.get(19), stringList.get(20)));
//                 result.add(new String[]{stringList.get(18).replace(".0", ""), stringList.get(19), stringList.get(20)});
                 result.add(stringList.toArray(new String[25]));
             }
             //System.out.println(stringList.size());
             stringList.clear();
             //System.out.println("");
         }
        return result;
    }
}
