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
            int count = 0;

            while(cellIterator.hasNext()) {
                count++;
                Cell cell = cellIterator.next();
                int index = cell.getColumnIndex();
                CellType cellType = cell.getCellTypeEnum();
                if(count<index){
                    result.add("NULL");
                    //System.out.print("NULL      " + count);
                    //System.out.print("\t");
                    count=index;
                }
                switch(cellType){
                    case STRING:
                        //result.add(cell.getStringCellValue());
                        result.add(cell.getStringCellValue());
                        //System.out.print("StringCell" + index);
                        //System.out.print("\t");
                        break;
                    case NUMERIC:
                        result.add(Double.valueOf(cell.getNumericCellValue()).toString());
                        //System.out.print("NumericCell" + index);
                        //System.out.print("\t");
                        break;
                }


                /*if (cellType.equals(CellType.STRING)) {
                    *//*System.out.print(String.format("%20s", cell.getStringCellValue()));
                    System.out.print("\t");*//*
                    result.add(cell.getStringCellValue());
                }else if(cellType.equals(CellType._NONE)&&cellType.equals(CellType.BLANK)){
                    result.add("null");
                }*/
            }
//
            if(result.size()==25){
                System.out.println(String.format("%5s %8s %8s",result.get(18).replace(".0", ""), result.get(19), result.get(20)));
            }
            //System.out.println(result.size());
            result.clear();
            System.out.println("");
        }
    }
}
