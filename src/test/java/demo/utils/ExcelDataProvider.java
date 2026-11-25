package demo.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.FileOutputStream;

public class ExcelDataProvider {

    @DataProvider(name = "excelData")
    public static Object[][] excelData() {
        String fileLocation = System.getProperty("user.dir") + "/src/test/resources/data.xlsx";
        System.out.println("Fetching excel file from " + fileLocation);
        return ExcelReaderUtil.readExcelData(fileLocation);
    }

    public static void main(String args[]) throws Exception {
        File dir = new File(System.getProperty("user.dir") + "/src/test/resources");
        if (!dir.exists()) dir.mkdirs();

        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("Sheet1");
        String[] items = {"Search Terms", "Movies", "Music", "Games", "India", "UK"};
        for (int i = 0; i < items.length; i++) {
            sheet.createRow(i).createCell(0).setCellValue(items[i]);
        }
        FileOutputStream fos = new FileOutputStream(new File(dir, "data.xlsx"));
        wb.write(fos);
        fos.close();
        wb.close();
        System.out.println("data.xlsx created successfully!");

        
        excelData();
    }
}
