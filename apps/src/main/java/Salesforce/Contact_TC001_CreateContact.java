package Salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Contact_TC001_CreateContact {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("sahanabaasha@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Sahana@123");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		WebElement create= driver.findElement(By.xpath("//p[text()='Contacts']"));
		js.executeScript("arguments[0].click();",create);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Contacts List']/preceding-sibling::lightning-icon")).click();
		WebElement newCon= driver.findElement(By.xpath("//span[text()='New Contact']"));
		js.executeScript("arguments[0].click();",newCon);
		driver.findElement(By.xpath("//span[text()='--None--']")).click();
		driver.findElement(By.xpath("//span[text()='Mrs.']")).click();
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Aameena Sahana");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("A");
		driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("sahana@test.com");
		driver.findElement(By.xpath("(//input[@class='slds-combobox__input slds-input'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='New Account']")).click();
		driver.findElement(By.xpath("(//input[@class=' input'])[1]")).sendKeys("Credits");
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		String contactText = driver.findElement(By.xpath("//span[text()='Contact']")).getText();
		
		if(contactText.contains(contactText)) {
			System.out.println("Contact was created");
			
			}

	}

}
