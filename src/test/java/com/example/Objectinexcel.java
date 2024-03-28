package com.iamneo;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class AppTest {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws IOException {
        // Specify the path of the Excel file
        String excelFilePath = "C:\\Users\\NithyaT\\Desktop\\Book1.xlsx";
//File file=new File(excelFilePath);
        // Create a FileInputStream to read the Excel file
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

        // Create a Workbook object for the Excel file
        Workbook workbook = new XSSFWorkbook(inputStream);

        // Get the first sheet of the Excel workbook
        Sheet sheet = workbook.getSheetAt(0);

        // Get the number of rows in the sheet
        int rowCount = sheet.getPhysicalNumberOfRows();

        // Create a 2D array to store test data
        Object[][] data = new Object[rowCount - 1][2]; // Subtract 1 for header row

        // Iterate over all the rows in the Excel sheet (skipping the header row)
        for (int i = 1; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            // Get data from columns
            String username = row.getCell(0).getStringCellValue();
            String password = row.getCell(1).getStringCellValue();
            // Store data in the array
            data[i - 1][0] = username;
            data[i - 1][1] = password;
        }

        // Close the workbook and input stream
        workbook.close();
        inputStream.close();

        return data;
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) {
        // Perform login using username and password
        System.out.println("Logging in with username: " + username + " and password: " + password);
        // Add your test steps/assertions here
    }
}
