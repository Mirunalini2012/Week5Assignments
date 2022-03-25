package week5AssignmentServicenow;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Week5Day1_Incident_Assign extends ProjectSpecificMethod {
	@Test
	public void testcase03() throws InterruptedException, IOException {
		
	
	driver.switchTo().frame("gsft_main");
	System.out.println(incidentNumber);
	driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(incidentNumber);
	driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("(//td[@class='vt']/a)[1]")).click();
	
	
	driver.findElement(By.id("lookup.incident.assignment_group")).click();
	System.out.println(driver.getCurrentUrl());
	
	//another screen
	Set<String> allWindowHandleSet = driver.getWindowHandles();
	List<String> allWindowHandleList = new ArrayList<String>();
	allWindowHandleList.addAll(allWindowHandleSet);
	String newWindow = allWindowHandleList.get(1);
	driver.switchTo().window(newWindow);
	
	//select software group
	driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("software");
	driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(Keys.ENTER);
	
	Thread.sleep(2000);
     String selectedGroup = driver.findElement(By.xpath("//table[@id='sys_user_group_table']/tbody[1]/tr[1]/td[3]/a[1]")).getText();
	System.out.println("Selected Group "+selectedGroup);
	driver.findElement(By.xpath("//table[@id='sys_user_group_table']/tbody[1]/tr[1]/td[3]/a[1]")).click();
		
	//home screen
	
	String newWindow1 = allWindowHandleList.get(0);
	driver.switchTo().window(newWindow1);
	driver.switchTo().frame("gsft_main");
	//System.out.println(driver.getCurrentUrl());
	
	driver.findElement(By.id("activity-stream-textarea")).sendKeys("updated");
	driver.findElement(By.id("sysverb_update")).click();
	driver.findElement(By.xpath("(//td[@class='vt']/a)[1]")).click();
	
	String verifygroup = driver.findElement(By.xpath("(//div[@class='input-group ref-container']/input)[3]")).getAttribute("value");
	System.out.println("Verify Group "+verifygroup);
	if(selectedGroup.equals(verifygroup))
	{
		System.out.println("Group Verified");
		
	}
	

}
}
