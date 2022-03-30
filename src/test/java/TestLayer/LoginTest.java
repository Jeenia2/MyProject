package TestLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepackage.BaseHRMClass;
import pompackage.PomLogin;
import testdata.ExcelSheet;


public class LoginTest extends BaseHRMClass{
	PomLogin log;
	
	public LoginTest() {	
		super();	
	}
	
	@BeforeMethod
	public void initsetup() {
		initiation();
		screenshots("Login");
		log =new PomLogin();

	}
	
	@Test (priority=1)
	
	public void title() {
	 
	String actual=	log.verify();
	System.out.println(actual);
	Assert.assertEquals(actual, "OrangeHRM");
	
	}
    @DataProvider
    public Object[][] Details(){
    	Object result[][]= ExcelSheet.readdata("Sheet1");
    	return result;
    	
    	}
   
	
	@Test (priority=2, dataProvider= "Details")
	public void Login(String name, String password) throws InterruptedException {
		log.typerusername(name);
		Thread.sleep(2000);
		log.typerpassword(password);
	    //log.Lbutton();
	}
@AfterMethod
public void close() {
	driver.close();
	
}


	
	}
	
