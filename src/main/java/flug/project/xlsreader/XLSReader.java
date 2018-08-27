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
                     count = index;
                 }
                 switch (cellType) {
                     case STRING:
                         stringList.add(cell.getStringCellValue());
                         break;
                     case NUMERIC:
                         stringList.add(Double.valueOf(cell.getNumericCellValue()).toString());
                         break;
                 }
             }

             if (stringList.size() == 25) {
                 result.add(stringList.toArray(new String[25]));
             }
             stringList.clear();
         }
         result.remove(0);
        return result;
    }
}
