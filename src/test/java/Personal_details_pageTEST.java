import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import HRM_BASECLASS.TestBase;
import HRM_Pages.AdminPage;
import HRM_Pages.EmployeePage;
import HRM_Pages.LoginPage;
import HRM_Pages.Personal_details;
import HRM_UtilCLass.Testutil;
public class Personal_details_pageTEST extends TestBase 
{
LoginPage loginPage;
AdminPage adminpage;
EmployeePage employeePage;
Personal_details personal_details;
EmployeePageTest employeePageTest;

public  Personal_details_pageTEST()//constructor 
{
super();
}
	
@BeforeMethod()
			public void Setup() throws Exception  
			{
			initilization();
			loginPage=new LoginPage();
			adminpage=loginPage.login(prop.getProperty("Username"), prop.getProperty("Password"));
			Thread.sleep(3000);
			}
 @AfterMethod
 			public void tearDown()
 			{
	 		driver.quit();
 			}
@Test(priority=1)
			public  void Add_personalDetails_Test() throws Exception
	 		{
			adminpage.Click_On_PIM();
			Thread.sleep(2000);
			adminpage.Click_on_AddEmployee();
			Thread.sleep(2000);
			Testutil.SwitchToFrame();
			Thread.sleep(2000);
			Personal_details.ADD_ONE_EMP();
			Thread.sleep(2000);
			EmployeePage.BACK_Btn();
			Personal_details.Select_EMP();
			Personal_details.ClickOn_EditButton();
			Personal_details.ADD_Personal_details("123Abc", "143zc12", "256IOndia", "123456", "No", "1992-01-01");
	 		}
}
