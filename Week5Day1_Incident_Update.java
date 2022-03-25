package week5AssignmentServicenow;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Week5Day1_Incident_Update extends ProjectSpecificMethod {
	@Test

	public void testcase02() throws InterruptedException, IOException {
		
		driver.switchTo().frame("gsft_main");
		System.out.println(incidentNumber);
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(incidentNumber);
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("(//td[@class='vt']/a)[1]")).click();
		//System.out.println(driver.getCurrentUrl());
		
		
		//updating priority and urgency
		Select priority = new Select(driver.findElement(By.id("incident.state")));
		priority.selectByValue("2");
		Select urgency = new Select(driver.findElement(By.id("incident.impact")));
		urgency.selectByValue("1");
		driver.findElement(By.id("sysverb_update")).click();
		
		driver.findElement(By.xpath("(//td[@class='vt']/a)[1]")).click();
		String checkpriority = driver.findElement(By.id("incident.state")).getAttribute("value");
		String checkurgency = driver.findElement(By.id("incident.impact")).getAttribute("value");
		
		System.out.println("Priority - "+checkpriority);
		System.out.println("Urgency - "+checkurgency);
		//checking priority and urgency
		if((checkpriority=="1") && (checkurgency=="1") )
		{
			System.out.println("Priority and Urgency Checked");
			
		}
		
		
		
		
		
		
	}
	
	}
