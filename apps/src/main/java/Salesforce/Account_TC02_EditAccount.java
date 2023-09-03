package Salesforce;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Account_TC02_EditAccount {

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
		
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Ashish12");
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(@class,'slds-button slds-button--icon-x-small')]")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		//8) Select Type as Technology Partner
		driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input slds-input_faux')])[2]")).click();
		//driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input slds-input_faux')])[2]")).click();
		driver.findElement(By.xpath("//span[@title='Technology Partner']")).click();
		//span[@title='Technology Partner']
		
		//driver.findElement(By.xpath("//span[@title='Technology Partner']")).sendKeys(Keys.ENTER);
		//9) Select Industry as Healthcare 
	
		WebElement Indus = driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input slds-input_faux')])[4]"));
        driver.executeScript("arguments[0].click();", Indus);
		WebElement health = driver.findElement(By.xpath("//span[text()='Healthcare']"));
		 driver.executeScript("arguments[0].click();", health);
		
		//10)Enter Billing Address
		driver.findElement(By.xpath("//textarea[@name='street']")).sendKeys("Marine");
		//11)Enter Shipping Address
		driver.findElement(By.xpath("(//textarea[@name='street'])[2]")).sendKeys("TNAGAR");
		//12)Select Customer Priority as Low
		WebElement priority = driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input slds-input_faux')])[5]"));
		driver.executeScript("arguments[0].click();", priority);
		
		WebElement low = driver.findElement(By.xpath("//span[text()='Low']"));
		driver.executeScript("arguments[0].click();", low);
		//13)Select SLA as Silver
		WebElement selectSla = driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input slds-input_faux')])[6]"));
		driver.executeScript("arguments[0].click();", selectSla);

		WebElement sla = driver.findElement(By.xpath("//span[text()='Silver']"));
		
		driver.executeScript("arguments[0].click();", sla);

		//14) Select Active as NO 
		WebElement selActive = driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input slds-input_faux')])[8]"));
		driver.executeScript("arguments[0].click();", selActive);

		WebElement active = driver.findElement(By.xpath("(//span[text()='No'])"));
		driver.executeScript("arguments[0].click();", active);

		//15) Enter Unique Number in Phone Field
		driver.findElement(By.xpath("(//input[@class='slds-input'])[3]")).sendKeys("0987654322");
		//16)Select Upsell Oppurtunity as No
		WebElement selUpsell = driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input slds-input_faux')])[7]"));
		driver.executeScript("arguments[0].click();", selUpsell);

		WebElement upsell = driver.findElement(By.xpath("(//span[text()='No'])[1]"));
		driver.executeScript("arguments[0].click();", upsell);

		
		//17)Click on save and verfiy Phone number
		WebElement save = driver.findElement(By.xpath("//button[text()='Save']"));
		driver.executeScript("arguments[0].click();", save);
		
		//text
		String text = driver.findElement(By.xpath("//span[@dir='ltr']")).getText();
		System.out.println("p.no"+text);
		if(text.equals("0987654322")) {
			System.out.println("Phone number verified successfully....!!!");
		}

		
		driver.close();

	}

}
