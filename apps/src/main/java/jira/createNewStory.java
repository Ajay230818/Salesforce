package jira;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class createNewStory {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://api-training.atlassian.net/");
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("hari.radhakrishnan@testleaf.com");
		driver.findElement(By.xpath("//button[@id='login-submit']")).click();
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("India@123");
		driver.findElement(By.xpath("//button[@id='login-submit']")).click();
		driver.findElement(By.xpath("//p[text()='SDET-5']")).click();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@id='createGlobalItem']//span[text()='Create']")).click();
		driver.findElement(By.name("summary")).click();
		String name="Parthiv Ajay 2 New Story for Automation";
		driver.findElement(By.name("summary")).sendKeys(name);
		driver.findElement(By.xpath("//button[@form='issue-create.ui.modal.create-form']//span[text()='Create']")).click();
		driver.findElement(By.xpath("//span[text()='Backlog']")).click();
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys(name);
		String VerifyStory="//span//mark[text()='"+name+"']";
		if(driver.findElement(By.xpath(VerifyStory)).isDisplayed()) {
			System.out.println("Story is created successfully");
		}else {
			System.out.println("Story not created successfully");
		}
	}

}
