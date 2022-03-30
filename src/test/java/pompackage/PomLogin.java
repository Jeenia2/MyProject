package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.BaseHRMClass;

public class PomLogin extends BaseHRMClass {

	//object repository
	
	@FindBy(id="txtUsername") WebElement Username;
	
	@FindBy (css="#txtPassword" ) WebElement Password;
	
	@FindBy (id="btnLogin")  WebElement Login;
	
	//initiate page elements
	
	public PomLogin() {
		PageFactory.initElements(driver,this);	
	}
	
	public void typerusername(String name) {
		Username.sendKeys(name);
	}
	
	public void typerpassword (String pwd) {
		Password.sendKeys(pwd);
	}
	
	public void Lbutton () {
		Login.click();
	}
	
	
	public String verify () {
		return driver.getTitle();
	}
	
	
	
	
	
	
	
	
	
	
	
}
