package Salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Opportunity_TC001_CreateNewOpportunity {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		//login Script
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("karthikdamotharan99@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Karthik@664721");
		driver.findElement(By.id("Login")).click();
		
		//TC01SCRIPT
		driver.findElement(By.className("slds-icon-waffle")).click();		
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Opportunities");
		driver.findElement(By.xpath("(//mark[text()='Opportunities'])")).click();
		driver.findElement(By.xpath("//div[text()='New']")).click();
		Thread.sleep(5000);
		String name = "KARTHIK D";
		driver.findElement(By.xpath("(//input[@part='input'])[3]")).sendKeys(name);		
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("//td[@class='slds-is-today']")).click();
		driver.findElement(By.xpath("(//button[@role='combobox'])[1]")).click();
		//driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;        
	    WebElement account = driver.findElement(By.xpath("//span[@title='Needs Analysis']"));
	    js.executeScript("arguments[0].click();",account);
	    driver.findElement(By.xpath("//button[text()='Save']")).click();
	   // String opportunityname = driver.findElement(By.xpath("(//span[@id='window'])[2]")).getText();	
	    String opportunityname = driver.findElement(By.xpath("(//span[text()='KARTHIK D'])")).getText();
	    System.out.println(name);
	    System.out.println(opportunityname);
	    if(opportunityname.equals(name)) {
	    	System.out.println("TestCase Passed ");
	    }
	    else{
	    	System.out.println("Testcase Failed");
	    }

	}

}
