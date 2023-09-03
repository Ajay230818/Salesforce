package Salesforce;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Refund_TC01_Create_New_Refund {

	public static void main(String[] args) throws InterruptedException {
		//created by Ashish
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
		//5. Click on New
		driver.findElement(By.xpath("//div[text()='New']")).click();
		//6. Select Account name
		driver.findElement(By.xpath("(//span[text()='Account'])[2]/following::input")).click();
		
		driver.findElement(By.xpath("//div[text()='Peter']")).click();
		//7. Select Status as Canceled
		driver.findElement(By.xpath("//a[@class='select']")).click();
		driver.findElement(By.xpath("//a[@title='Canceled']")).click();
		
		//8. Give Amount as 50000 and select Referenced in Type
		driver.findElement(By.xpath("//input[@class='input uiInputSmartNumber']")).sendKeys("50000");
		
		driver.findElement(By.xpath("(//a[@class='select'])[2]")).click();
		
		driver.findElement(By.xpath("//a[@title='Referenced']")).click();
		
		//9. Select Processing Mode as External
		driver.findElement(By.xpath("(//a[@class='select'])[3]")).click();
		
		driver.findElement(By.xpath("//a[@title='External']")).click();
		
		//10. Click Save
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		
		driver.close();

	}

}
