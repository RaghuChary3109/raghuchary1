package HRM_Pages;
import HRM_BASECLASS.TestBase;
import HRM_UtilCLass.Testutil;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AdminPage extends TestBase
{
LoginPage loginpage;
	
	@FindBy(xpath="//*[@id=\"option-menu\"]/li[contains(text(),'Welcome qaplanet1')]")
	WebElement UsernameLabel;
	
//	@FindBy(linkText="PIM")
//	WebElement PIM;
	
	@FindBy(linkText="Add Employee")
	WebElement AddEmployee;
	
	@FindBy(xpath="//input[@type='button' and @value='Add']")
	WebElement ADD_BTN;
	
	@FindBy(xpath="//*[@id=\"standardView\"]/table/tbody/tr[1]/td[3]/a")
	WebElement Emp;
	

	//Initialize the page objects
public AdminPage()
		{
		PageFactory.initElements(driver, this);
		}
public String verify_admin_page_tittle()
		{
		return driver.getTitle();
		}
public Boolean Verify_PIM() 
		{
		return driver.findElement(By.linkText("PIM")).isDisplayed();
		}
public void Click_On_PIM() 
		{
		action.moveToElement(driver.findElement(By.linkText("PIM"))).perform();
		}
public void Click_on_AddEmployee()
		{
		AddEmployee.click();
		}
public EmployeePage Click_ADD_BTN() throws Exception 
		{
		Thread.sleep(3000);
		Testutil.SwitchToFrame();
		ADD_BTN.click();
		return new EmployeePage();
		}
public Personal_details Select_Emp() 
		{
		Emp.click();
		return  new Personal_details();
		}

public void GET_Employe_List() throws Exception 
		{
		FileOutputStream file1=new FileOutputStream("C:\\workspace\\HRM_POM_Project1\\src\\main\\java\\HRM_UtilCLass\\EMP_List_data.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet sheet=wb.createSheet("employee");
		driver.switchTo().frame("rightMenu");
		String EMP_ID_Xpath1="//*[@id=\"standardView\"]/table/tbody/tr[";
		String EMP_ID_Xpath2="]/td[3]/a";
		
		for(int i=1;i<15;i++)
		{
				String employe_list=driver.findElement(By.xpath(EMP_ID_Xpath1+i+EMP_ID_Xpath2)).getText();
				System.out.println(employe_list);
				//sheet.createRow(i).createCell(0).setCellValue(employe_list);
				Row row = sheet.createRow(i);
				Cell cell = row.createCell(0);
				Thread.sleep(1000);
				cell.setCellValue(employe_list);
		}
		wb.write(file1);
	}	
	
}
