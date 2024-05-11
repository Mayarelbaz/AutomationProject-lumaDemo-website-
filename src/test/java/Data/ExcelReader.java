package Data;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    private static final String FILE_PATH = "C:\\Users\\Maya Kind\\AmazonWebsite\\src\\test\\java\\Data\\excelreader.xlsx";

    @DataProvider
    public static Object[][] readTestData() {
        Object[][] testData = null;
        FileInputStream inputStream = null;
        Workbook workbook = null;

        try {
            inputStream = new FileInputStream(FILE_PATH);
            workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheet("Sheet1"); // Assuming data is in Sheet1

            List<Object[]> dataList = new ArrayList<>();

            for (Row row : sheet) {
                if (row.getRowNum() == 0) // Skip header row
                    continue;

                if (isRowEmpty(row))
                    break; // Stop reading rows if encountering an empty row

                List<Object> rowData = new ArrayList<>();
                for (Cell cell : row) {
                    if (cell.getCellType() == CellType.STRING) {
                        rowData.add(cell.getStringCellValue());
                    } else if (cell.getCellType() == CellType.NUMERIC) {
                        rowData.add(cell.getNumericCellValue());
                    } else if (cell.getCellType() == CellType.BLANK) {
                        rowData.add(""); // Add empty string for blank cells
                    }
                }
                dataList.add(rowData.toArray());
            }

            testData = new Object[dataList.size()][];
            for (int i = 0; i < dataList.size(); i++) {
                testData[i] = dataList.get(i);
            }

        } catch (IOException e) {
            e.printStackTrace(); // Handle file IO exception
        } finally {
            try {
                if (workbook != null) {
                    workbook.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace(); // Handle closing resources exception
            }
        }
        return testData;
    }

    private static boolean isRowEmpty(Row row) {
        for (Cell cell : row) {
            if (cell.getCellType() != CellType.BLANK) {
                return false; // Row is not empty if any cell is not blank
            }
        }
        return true; // Row is empty if all cells are blank
    }
}
