package Utilities;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class TestData {

    String filename = "TestData.xls";

    public String read(String dataName,int row, int cell){
        try {
            File file = new File(System.getProperty("user.dir")+"/src/main/resources/"+filename);
            FileInputStream exel = new FileInputStream(file);
            HSSFWorkbook wb = new HSSFWorkbook(exel);
            HSSFSheet sayfaadi = wb.getSheet(dataName);
            HSSFRow satir = sayfaadi.getRow(row);
            HSSFCell hucre = satir.getCell(cell);
            return hucre.getStringCellValue();
        }catch (Exception e) {
            return "Null";
        }
    }

}
