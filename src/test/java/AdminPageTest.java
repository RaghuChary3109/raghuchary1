import HRM_BASECLASS.TestBase;
import HRM_Pages.AdminPage;
import HRM_Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminPageTest extends TestBase
{

	LoginPage loginPage;
	AdminPage adminpage;


 public  AdminPageTest()
 {
 super();
 }
 
 @BeforeMethod
 public void Setup() throws Exception  {
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
 					public void verify_adminPage_tittle_Test() 
 						{
	 				String homePage_Tittle= adminpage.verify_admin_page_tittle();
	 				Assert.assertEquals(homePage_Tittle, "OrangeHRM");
	 				System.out.println(homePage_Tittle);
 						}
 @Test(priority=2)//Employee list will be printed in Test_output_data file
 					public void Get_EMP_List() throws Exception 
 						{
 					adminpage.GET_Employe_List();
 						}
 @Test(priority=3)
 					public void verify_PIM_Test() 
 						{
	 				Assert.assertTrue(adminpage.Verify_PIM());
 						}
 @Test(priority=4)
 					public void add_Employee_Test() 
 						{
	 				adminpage.Click_On_PIM();
	 				adminpage.Click_on_AddEmployee();
 						}
 
 
 


}
