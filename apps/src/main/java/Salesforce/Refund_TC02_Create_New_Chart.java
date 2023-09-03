package Salesforce;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Refund_TC02_Create_New_Chart {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
	    options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("ashish@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Profile123#");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
		driver.findElement(By.xpath("//p[text()='Service Console']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@title='Show Navigation Menu']//lightning-primitive-icon[1]")).click();
		
		driver.findElement(By.xpath("//span[text()='Refunds']")).click();
		
		//	5.Click on drop down near Recently viewed and change into 'All'.
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Recently Viewed']")).click();
		
		driver.findElement(By.xpath("//a[@role='option']")).click();
	
	//	6. Click on Chart icon under New Button
		//Thread.sleep(1000);
		//driver.findElement(By.xpath("//button[@title='Show charts']//lightning-primitive-icon[1]")).click();
		driver.findElement(By.xpath("(//button[@role='button']//lightning-primitive-icon)[3]")).click();
		//	7. Click New Chart
		driver.findElement(By.xpath("//span[text()='New Chart']")).click();
		//Thread.sleep(1000);
	//	8. Give Chart Name and Select Chart Type
		driver.findElement(By.xpath("//input[@part='input']")).sendKeys("My chart");
	//	driver.findElement(By.className("slds-input")).sendKeys("My chart");
	//	9. Select Aggregate Type as Average and ggregate Field as Amount
		driver.findElement(By.xpath("(//a[@class='select'])[2]")).click();
		driver.findElement(By.xpath("//a[@title='Average']")).click();
		
	//	10. Select Grouping Field as Account and click Save
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();

		driver.close();

	}

}
