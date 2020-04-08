import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import HRM_BASECLASS.TestBase;
import HRM_Pages.AdminPage;
import HRM_Pages.LoginPage;

public class LoginPageTest extends TestBase
{
	LoginPage loginPage;
	AdminPage adminpage;
	 
	 
	 public  LoginPageTest()
	 {
	 super();
	 }
	 
	 @BeforeMethod
	 public void Setup() {
	 initilization();
	 loginPage=new LoginPage();
	 }
	 
	 @AfterMethod
	 public void tearDown()
	 {
		 driver.quit();
	 }
	 
@Test(priority=1)
			public void login_Page_tittle_Test() 
			{
			String tittle=loginPage.validateLoginPageTittle();
			Assert.assertEquals(tittle, "OrangeHRM - New Level of HR Management");
			}
@Test(priority=2)
			public void loginTest()
			{
			adminpage=loginPage.login(prop.getProperty("Username"), prop.getProperty("Password"));
			}


		

}
