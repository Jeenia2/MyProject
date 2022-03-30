package basepackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utility.TimeUtils;



public class BaseHRMClass {

	
	public static Properties p= new Properties();
	public static WebDriver driver;

	//Step1
	
	public BaseHRMClass() {
		try {
	
		FileInputStream file = new FileInputStream("E:\\QA training software\\P_maven\\src\\test\\java\\envvariables\\Config.properties");
	    p.load(file);
		}
		catch (FileNotFoundException  e) {
			e.printStackTrace();
		}
		catch (IOException a) {
			a.printStackTrace();		
		}}
		//Step 2
			
			

		
			public static void initiation() {
				
			String browsername=	p.getProperty("browser");
				if (browsername.equals("Chrome")) {
					
					System.setProperty("Webdriver.ChromeDriver.driver", "ChromeDriver.exe");
					
				driver = new ChromeDriver();}
				else if (browsername.equals("Firefox")) {
					
					System.setProperty("Webdriver.gecko.driver.driver", "geckodriver.exe");
					driver = new FirefoxDriver ();
					}	
				
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage, TimeUnit.SECONDS);
		
		driver.get(p.getProperty("url"));
	
				}
				
				public void screenshots(String Filename)  {
					
				File file=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				try {
				FileUtils.copyFile(file, new File("E:\\QA training software\\P_maven\\src\\test\\java\\screenshots\\Screenshots" + Filename +".jpg"));
					
				}
				catch(IOException e) {
					e.printStackTrace();
				}
				}
				
			}
			
		
	

	
	
	
	
	
	
	
	
	
	
	
	