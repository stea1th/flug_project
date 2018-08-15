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

public class TestMain {

    public static void main(String[] args) throws IOException {
        List<String> result = new ArrayList<>();
        FileInputStream input = new FileInputStream(new File("c:/demo/aa.xls"));
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

        Iterator<Row> rowIterator = sheet.iterator();

        while(rowIterator.hasNext()){
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();

            while(cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                CellType cellType = cell.getCellTypeEnum();
                if (cellType.equals(CellType.STRING)) {
                    /*System.out.print(String.format("%20s", cell.getStringCellValue()));
                    System.out.print("\t");*/
                    result.add(cell.getStringCellValue());
                }else if(cellType.equals(CellType._NONE)&&cellType.equals(CellType.BLANK)){
                    result.add("null");
                }
            }
//
            /*if(result.size()>14&&result.size()<18){
                System.out.println(String.format("%8s %8s", result.get(13), result.get(14)));
            }*/
            System.out.println(result.size());
            result.clear();
        }
    }
}
