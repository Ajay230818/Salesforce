package Salesforce;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Account_TC03_DeleteAccount {

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
		driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys("Account");
		
		driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
		
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("DeleteAccout");
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(@class,'slds-button slds-button--icon-x-small')]")).click();
		//driver.findElement(By.xpath("(//a[@title='Edit'])[3]")).click();
		
		  WebElement del = driver.findElement(By.xpath("//a[@title='Delete']"));
		  driver.executeScript("arguments[0].click();", del);
		 
		
		
		List<WebElement> ele = driver.findElements(By.xpath("//table[contains(@class,'slds-table forceRecordLayout')]/tbody/tr/th"));
		for (WebElement name : ele) {
			System.out.println(name);
			
		}
		if(ele.contains("DeleteAccout")==false) {
			System.out.println("Account deleted successfully...!!!");
		}
		
		driver.close();

	}

}
