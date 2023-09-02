package Salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Task_TC003_DeleteTask {

	public static void main(String[] args) {
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
		WebElement createTask= driver.findElement(By.xpath("//p[text()='Tasks']"));
		js.executeScript("arguments[0].click();",createTask);
		driver.findElement(By.xpath("//span[text()='Select a List View: Tasks']/preceding-sibling::lightning-primitive-icon")).click();
		driver.findElement(By.xpath("(//span[text()='Recently Viewed'])[3]")).click();
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys("Bootcamp",Keys.ENTER);
		driver.findElement(By.xpath("(//span[text()='Bootcamp'])[1]")).click();
		driver.findElement(By.xpath("//a[contains(@class,'slds-grid slds-grid--vertical-align-center')]")).click();
		driver.findElement(By.xpath("//div[text()='Delete']/parent::a")).click();
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		//verify
		String text = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		if(text.indexOf("Task\"Bootcamp\"was deleted.")<0)
		{

			System.out.println(" Task deleted ");  
		}
		else
		{
			System.out.println("Task not deleted");
		}

		driver.close();	
		

	}

}
