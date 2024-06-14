package flipkartAutomate.utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class ExcelUtils {
	private String filePath;
	private String sheetName;
	private Workbook workbook;
	private Sheet sheet;
 
	public ExcelUtils(String filePath, String sheetName) {
		this.filePath = filePath;
		this.sheetName = sheetName;
		try {
			FileInputStream fis = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
 
	public Map<String, Boolean> getExecutionMap() {
		Map<String, Boolean> executionMap = new HashMap<>();
		Iterator<Row> rowIterator = sheet.iterator();
 
		rowIterator.next(); // Skip the header row
 
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Cell methodNameCell = row.getCell(0); // Assuming method name is the first column
			Cell executionRequiredCell = row.getCell(1); // Assuming "Execution Required" is the second column
//           System.out.println(methodNameCell+"hello");
           
			String methodName = methodNameCell.getStringCellValue();
			boolean executionRequired = "yes".equalsIgnoreCase(executionRequiredCell.getStringCellValue());
			executionMap.put(methodName, executionRequired);
		}
 
		return executionMap;
	}
 
	
	public Map<String, String> getTestDataMap() {
        Map<String, String> testDataMap = new HashMap<>();
        if (sheet == null) return testDataMap; // Handle case where sheet is not found
        Iterator<Row> rowIterator = sheet.iterator();
 
        if (rowIterator.hasNext()) rowIterator.next(); // Skip the header row
 
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Cell methodNameCell = row.getCell(0);
            Cell testDataCell = row.getCell(2);
 
            if (methodNameCell == null || testDataCell == null) continue; // Handle missing cells
 
            String methodName = methodNameCell.getStringCellValue();
            String testData = getCellDataAsString(testDataCell);
            testDataMap.put(methodName, testData);
        }
 
        return testDataMap;
    }
	
	private String getCellDataAsString(Cell cell) {
        if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            return String.valueOf((int) cell.getNumericCellValue());
        } else {
            return "";
        }
    }

}