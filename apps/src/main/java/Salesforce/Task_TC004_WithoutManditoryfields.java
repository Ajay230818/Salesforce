package Salesforce;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Task_TC004_WithoutManditoryfields {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("sahanabaasha@tcs.com");
		driver.findElement(By.id("password")).sendKeys("Sahana@123");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		WebElement newTask= driver.findElement(By.xpath("//p[text()='Tasks']"));
		js.executeScript("arguments[0].click();",newTask);
		driver.findElement(By.xpath("//span[text()='Tasks List']/preceding-sibling::lightning-icon")).click();
		WebElement NewTask= driver.findElement(By.xpath("//span[text()='New Task']"));
		js.executeScript("arguments[0].click();",NewTask);
		driver.findElement(By.xpath("//input[@title='Search People']")).click();
		Thread.sleep(2000);
		WebElement name= driver.findElement(By.xpath("//span[text()='Aameena sahana A']"));
		js.executeScript("arguments[0].click();",name);
		driver.findElement(By.xpath("//span[@id='quickTextKeyboardTip']/following::textarea")).sendKeys("SALES FORCE Automation Using Selenium");
		driver.findElement(By.xpath("//span[text()='Save']")).click();
		String error = driver.findElement(By.xpath("//span[text()='Review the errors on this page.']")).getText();
	if(error.contains(error)) {
	System.out.println("error message displayed");
	
	}
	
	}

}
