package Salesforce;

import java.time.Duration;


import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class Account_TC04_VerifySorting {

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
		WebElement sale = driver.findElement(By.xpath("//p[text()='Sales']"));
		driver.executeScript("arguments[0].click();", sale);
		
		WebElement account = driver.findElement(By.xpath("//span[text()='Accounts']"));
		driver.executeScript("arguments[0].click();", account);

		driver.findElement(By.xpath("//a[contains(@class,'toggle slds-th__action')]")).click();
		Thread.sleep(2000);
		driver.close();

	}

}
