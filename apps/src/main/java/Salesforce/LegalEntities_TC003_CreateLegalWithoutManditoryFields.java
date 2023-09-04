package Salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LegalEntities_TC003_CreateLegalWithoutManditoryFields {

	public static void main(String[] args) throws InterruptedException {


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

		WebElement Drpdown = driver.findElement(By.xpath("//span[contains(text(),'Legal Entities List')]"));

		js.executeScript("arguments[0].click();",Drpdown);

		//Click on New Legal Entity

		WebElement newEnt = driver.findElement(By.xpath("//span[text()='New Legal Entity']"));
		js.executeScript("arguments[0].click();",newEnt);

		//Enter the Company name as 'Tetsleaf'.

		driver.findElement(By.xpath("//input[@name='CompanyName']")).clear();
		driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys("Testleaf");

		//Enter Description as 'SalesForce'.

		driver.findElement(By.xpath("//label[text()='Description']/following-sibling::div/textarea"))
		.sendKeys("Sales Force");

		//Select Status as 'Active'
		Thread.sleep(3000);
		WebElement statusDrop = driver.findElement(By.xpath("//button[@data-value='--None--']"));
		js.executeScript("arguments[0].click();",statusDrop);

		driver.findElement(By.xpath("//span[text()='Active']")).click();
		
		//10. Click on Save and Verify Status as Active
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		//verify
				String alert=driver.findElement(By.xpath("//h2[text()='We hit a snag.']")).getText();
				if(alert.indexOf("We hit a snag.'")<0)
				{

					System.out.println("Review the following fields ");  
				}
				else
				{
					System.out.println("Legal Entities  saved");
				}

				driver.close();	
				

	}

}
