
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import HRM_BASECLASS.TestBase;
import HRM_Pages.AdminPage;
import HRM_Pages.EmployeePage;
import HRM_Pages.LoginPage;
import HRM_UtilCLass.Testutil;
public class EmployeePageTest extends TestBase
{
LoginPage loginPage;
AdminPage adminpage;
EmployeePage employeePage;
String sheet_name="Sheet1";		

public  EmployeePageTest()
{
super();
}	 
@BeforeMethod
			public void Setup() throws Exception  
			{
			initilization();
			loginPage=new LoginPage();
			adminpage=loginPage.login(prop.getProperty("Username"), prop.getProperty("Password"));
			Thread.sleep(3000);
			employeePage.Click_PIM_();
			Thread.sleep(2000);
			employeePage.click_AddEmployee();
			Thread.sleep(2000);
			driver.switchTo().frame("rightMenu");
			}
 @AfterMethod
	 		public void tearDown()
	 		{
	 		driver.quit();
	 		}
@DataProvider
			public Object[][] getTestData() throws Exception 
	 		{
			Object data[][]=Testutil.getTestData(sheet_name);
			return data;
	 		} 	
@Test(priority=1)
			public void verify_adminPage_tittle_Test() 
			{
			String homePage_Tittle= adminpage.verify_admin_page_tittle();
			Assert.assertEquals(homePage_Tittle, "OrangeHRM");
			System.out.println(homePage_Tittle);
			} 	 
@Test(priority=2,dataProvider="getTestData")
	 		public void AddEMP_Details_Test(String LastName,String FirstName ,String MiddleName,String NickName) throws Exception 
	 		{
			EmployeePage.AddEMP_Details(LastName, FirstName, MiddleName, NickName);
	 		}	
			}
