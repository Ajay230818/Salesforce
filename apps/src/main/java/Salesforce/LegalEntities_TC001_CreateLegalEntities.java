package Salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LegalEntities_TC001_CreateLegalEntities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");

		// open my browser
		ChromeDriver driver=new ChromeDriver(options);

		// Window max
		driver.manage().window().maximize();

		//wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		//load URL
		driver.get("https://login.salesforce.com/");
		
		//SendKeys-username
		driver.findElement(By.id("username")).sendKeys("sahanabaasha@gmail.com");

		//Sendkeys password
		driver.findElement(By.id("password")).sendKeys("Sahana@123");

		//1.Click login
		driver.findElement(By.id("Login")).click();
		
		//2. Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		
		//3. Click View All 
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		//and click Legal Entities from App Launcher
		JavascriptExecutor js = (JavascriptExecutor)driver;		

		WebElement legalEntity = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		
		js.executeScript("arguments[0].click();",legalEntity);
		
		//4. Click on the Dropdown icon in the legal Entities tab
		
		WebElement Drpdown = driver.findElement(By.xpath("//span[text()='Legal Entities List']"));
				
		js.executeScript("arguments[0].click();",Drpdown);
		
		//Click on New Legal Entity
		
		WebElement newEnt = driver.findElement(By.xpath("//span[text()='New Legal Entity']"));
		js.executeScript("arguments[0].click();",newEnt);
		
		//Enter Name as 'Salesforce Automation by *Your Name*'
		
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation by Sahana1");
		
		//Click save and verify Legal Entity Name
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		// Verify
		String entitiesCreated=driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		if(entitiesCreated.indexOf("Legal Entity\"Sahana1\"was created.")<0)
		{

			System.out.println("Legal Entities Sahana1 was Created ");  
		}
		else
		{
			System.out.println("Legal Entities not Created");
		}

		driver.close();	
		}

}
