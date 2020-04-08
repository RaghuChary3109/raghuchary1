package HRM_UtilCLass;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import HRM_BASECLASS.TestBase;
public class Testutil extends TestBase
{
public static long PAGE_LOAD_TEST=80;
public static long IMPLICIT_WAIT=80;
public static String  TEST_DATA_EXCEL_PATH="C:\\workspace\\HRM_POM_Project1\\src\\main\\java\\HRM_UtilCLass\\Testdata.xlsx";
static Workbook book;
static Sheet sheet;
public static Object[][]  getTestData(String sheetname) throws Exception
		{
		FileInputStream file=null;
		{
		try
		{
			file=new FileInputStream(TEST_DATA_EXCEL_PATH);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try
		{
			book=WorkbookFactory.create(file);
		}
		catch(InvalidFormatException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	    sheet=book.getSheet(sheetname);
	    Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	    for(int i=0;i<sheet.getLastRowNum();i++)
	    {
	    	for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
	    	{
	    		data[i][k]=sheet.getRow(i+1).getCell(k).toString();
	    	}
	    }
	    return data;
		}
		}
public static void SwitchToFrame()
		{
		driver.switchTo().frame("rightMenu");
		}

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
