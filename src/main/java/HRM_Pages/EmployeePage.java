package HRM_Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import HRM_BASECLASS.TestBase;
public class EmployeePage extends TestBase
{
			LoginPage loginpage;
			AdminPage adminpage;
//Initialize the page objects
public EmployeePage() 
			{
				PageFactory.initElements(driver, this);
			}
public static void Click_PIM_() 
			{
				action.moveToElement(driver.findElement(By.linkText("PIM"))).perform();
			}
public static void click_AddEmployee() 
			{
				driver.findElement(By.linkText("Add Employee")).click();
			}
public static void AddEMP_Details(String L_Name,String F_Name ,String M_Name,String N_Name) throws Exception 
			{
				Thread.sleep(2000);
				driver.findElement(By.name("txtEmpLastName")).sendKeys(L_Name);
				Thread.sleep(2000);
				driver.findElement(By.name("txtEmpFirstName")).sendKeys(F_Name);
				Thread.sleep(1000);
				driver.findElement(By.name("txtEmpMiddleName")).sendKeys(M_Name);
				Thread.sleep(1000);
				driver.findElement(By.name("txtEmpNickName")).sendKeys(N_Name);
				Thread.sleep(1000);
				driver.findElement(By.id("btnEdit")).click();
			}
public static void BACK_Btn() throws Exception 
			{
				driver.findElement(By.xpath("//input[@type='button' and @value='Back']")).click();
			}
public static void Select_emplyee() throws Exception 
			{
				driver.findElement(By.xpath("public static void BACK_Btn() throws Exception ")).click();
				Thread.sleep(2000);
			}
		
}
