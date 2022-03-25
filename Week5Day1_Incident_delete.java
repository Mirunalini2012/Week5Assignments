package week5AssignmentServicenow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class Week5Day1_Incident_delete extends ProjectSpecificMethod {
	
	@Test
	public void testcase04() throws InterruptedException, IOException {
		
	
	driver.switchTo().frame("gsft_main");
	System.out.println(incidentNumber);
	driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(incidentNumber);
	driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(Keys.ENTER);
	System.out.println(driver.getCurrentUrl());
	
	
	Set<String> allWindowHandleSet = driver.getWindowHandles();
	List<String> allWindowHandleList = new ArrayList<String>();
	allWindowHandleList.addAll(allWindowHandleSet);
	String newWindow = allWindowHandleList.get(0);
	driver.switchTo().window(newWindow);
	
	driver.switchTo().frame("gsft_main");
	
	String incidentdelete = driver.findElement(By.xpath("(//td[@class='vt']/a)[1]")).getText();
	
	System.out.println(incidentdelete);
	driver.findElement(By.xpath("(//td[@class='vt']/a)[1]")).click();
	
	
	driver.findElement(By.id("sysverb_delete")).click();
	driver.findElement(By.id("ok_button")).click();
	Thread.sleep(4000);
	if(incidentNumber.equals(incidentdelete)) {
		System.out.println("Incident Deleted");
		
	}
	
	

}
}
