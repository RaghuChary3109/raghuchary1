package HRM_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import HRM_BASECLASS.TestBase;

public class LoginPage extends TestBase
{
	@FindBy(name="txtUserName")
	public WebElement Username;
	@FindBy(name="txtPassword")
	public WebElement Password;
	@FindBy(name="Submit")
	public WebElement loginButton;
	@FindBy(name="clear")
	WebElement ClearButton;
//Initialize the page objects
public LoginPage() 
		{
		PageFactory.initElements(driver, this);
		}
//Actions 
public String validateLoginPageTittle() 
		{
		return driver.getTitle();
		}
	
public  AdminPage login(String UN,String PWD) 
		{
		Username.sendKeys(UN);
		Password.sendKeys(PWD);
		loginButton.click();
		return new AdminPage();
		}
}
