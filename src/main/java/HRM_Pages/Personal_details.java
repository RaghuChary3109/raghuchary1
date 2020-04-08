package HRM_Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import HRM_BASECLASS.TestBase;
public class Personal_details extends TestBase 
{
	LoginPage loginPage;
	AdminPage adminpage;
	EmployeePage employeePage;
	
//Initialize the page objects
public Personal_details() 
{
PageFactory.initElements(driver, this);
}
//Actions
public static void  ADD_ONE_EMP() throws Exception 
			{
				driver.findElement(By.name("txtEmpLastName")).sendKeys("Srinivas");
				Thread.sleep(1000);
				driver.findElement(By.name("txtEmpFirstName")).sendKeys("katla");
				Thread.sleep(1000);
				driver.findElement(By.name("txtEmpMiddleName")).sendKeys("rao");
				Thread.sleep(1000);
				driver.findElement(By.name("txtEmpNickName")).sendKeys("No Nick name");
				Thread.sleep(1000);
				driver.findElement(By.id("btnEdit")).click();
			}
public static void Select_EMP() throws Exception 
			{
				driver.findElement(By.xpath("//a[contains(text(),'katla rao Srinivas')]")).click();
				Thread.sleep(3000);
			}
public static void ClickOn_EditButton() 
			{
				driver.findElement(By.name("EditMain")).click();
			}
public static  void ADD_Personal_details(String ssn_no,String sin_no ,String Other_id ,String driving_license ,String military_service,String dob) throws Exception 
			{
				Thread.sleep(2000);
				driver.findElement(By.name("txtNICNo")).sendKeys(ssn_no);
				Thread.sleep(1000);
				driver.findElement(By.name("txtSINNo")).sendKeys(sin_no);
				Thread.sleep(1000);
				driver.findElement(By.name("txtOtherID")).sendKeys(Other_id);
				Thread.sleep(1000);
				driver.findElement(By.id("txtLicenNo")).sendKeys(driving_license);
				Thread.sleep(1000);
				driver.findElement(By.name("txtMilitarySer")).sendKeys(military_service);
				Thread.sleep(1000);
				driver.findElement(By.id("DOB")).sendKeys(dob);
				Select select= new Select(driver.findElement(By.name("cmbMarital")));
				select.selectByVisibleText("Married");
			}
}
