package week5Day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;



public class ProjectSpecificMethod {
	
	public RemoteWebDriver driver;
	@Parameters({"URL", "BROWSER_NAME"})
	@BeforeMethod
		public void beforeMethod(String url, String browsername)
		{
			
		
		if(browsername.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("edge"))
		{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		}
		
	
	driver.manage().window().maximize();
	driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
	driver.findElement(By.id("password")).sendKeys("crmsfa");
	driver.findElement(By.className("decorativeSubmit")).click();
	driver.findElement(By.linkText("CRM/SFA")).click();
	driver.findElement(By.linkText("Leads")).click();
	}
@AfterMethod
public void afterMethod()
{
	driver.close();
	
}
}
