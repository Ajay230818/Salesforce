package Salesforce;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SalesForceClassic {
	
	String salesForceUrl = "https://login.salesforce.com/";

	@Test
	public void tc001_SalesForce_Classic_NewAccount() {
		WebDriver driver = null;
		try {
			
			  System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			  ChromeOptions options = new ChromeOptions();
			  options.addArguments("--disable-notifications");
			  driver = new ChromeDriver(options);
			  driver.get(salesForceUrl);
			  driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			  driver.findElement(By.id("username")).clear();
			  driver.findElement(By.id("username")).sendKeys("sivaharasankar@gmail.com");
			  driver.findElement(By.id("password")).clear();
			  driver.findElement(By.id("password")).sendKeys("@mmA002330");
			  driver.findElement(By.id("Login")).click();
			 
			
			if(driver.findElements(By.className("switch-to-lightning")).size()>0)
				driver.findElement(By.className("switch-to-lightning")).click();
			
			Thread.sleep(30000);
			driver.findElement(By.xpath("//span[@class='uiImage']")).click();
			driver.findElement(By.linkText("Switch to Salesforce Classic")).click();
			driver.findElement(By.className("allTabsArrow")).click();
			driver.findElement(By.xpath("//td[@class='dataCol accountBlock']/a")).click();
			driver.findElement(By.name("new")).click();
			driver.findElement(By.id("acc2")).sendKeys("BootCamp Puppeteer_Siva");
			driver.findElement(By.id("acc17street")).sendKeys("FirstStreet");
			driver.findElement(By.id("acc17city")).sendKeys("Chennai");
			driver.findElement(By.id("acc17zip")).sendKeys("600119");
			driver.findElement(By.id("acc17state")).sendKeys("TamilNadu");
			driver.findElement(By.id("acc17country")).sendKeys("India");
			driver.findElement(By.linkText("Copy Billing Address to Shipping Address")).click();

			//Getting date code
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Calendar c = Calendar.getInstance();
			c.add(Calendar.DATE, 30);
			String sla = sdf.format(c.getTime());
			
			driver.findElement(By.xpath("//span[contains(@class,'dateInput')]")).click();
			driver.findElement(By.xpath("//span[contains(@class,'dateInput')]/input")).sendKeys(sla);
			driver.findElement(By.xpath("//input[@name='save']")).click();
			driver.findElement(By.xpath("//span[@class='mruText']")).getText().contains("Siva");
			driver.findElement(By.xpath("(//table[@class='detailList']//td)[2]")).getText().contains("Siva");
			driver.findElement(By.className("allTabsArrow")).click();
			driver.findElement(By.xpath("//td[@class='dataCol accountBlock']/a")).click();
			driver.findElement(By.xpath("//th[@scope='row']//a[1]")).getText().contains("Siva");
			driver.findElement(By.className("switch-to-lightning")).click();
			//Thread.sleep(30000);
			driver.findElement(By.xpath("//span[@class='uiImage']")).click();
			driver.findElement(By.linkText("Log Out")).click();
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}
	
	@Test(dependsOnMethods = {"tc001_SalesForce_Classic_NewAccount"})
	public void tc002_SalesForce_Classic_NewAccount() {
		WebDriver driver = null;
		try {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			driver.get(salesForceUrl);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys("sivaharasankar@gmail.com");
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys("@mmA002330");
			driver.findElement(By.id("Login")).click();

			if (driver.findElements(By.className("switch-to-lightning")).size() > 0)
				driver.findElement(By.className("switch-to-lightning")).click();
			Thread.sleep(20000);
			driver.findElement(By.xpath("//span[@class='uiImage']")).click();
			driver.findElement(By.linkText("Switch to Salesforce Classic")).click();
			driver.findElement(By.className("allTabsArrow")).click();
			driver.findElement(By.xpath("//td[@class='dataCol accountBlock']/a")).click();
			driver.findElement(By.xpath("//th[@scope='row']//a[1]")).click();
			driver.findElement(By.xpath("//input[@name='edit']")).click();
			driver.findElement(By.id("acc18street")).clear();
			driver.findElement(By.id("acc18city")).clear();
			driver.findElement(By.id("acc18zip")).clear();
			driver.findElement(By.id("acc18state")).clear();
			driver.findElement(By.id("acc18street")).sendKeys("FirstStreetUpdate");
			driver.findElement(By.id("acc18city")).sendKeys("ChennaiUpdate");
			driver.findElement(By.id("acc18zip")).sendKeys("600112");
			driver.findElement(By.id("acc18state")).sendKeys("Andhra");
			driver.findElement(By.xpath("//input[@name='save']")).click();
			driver.findElement(By.id("acc18_ileinner")).getText().contains("Update");
			driver.findElement(By.className("switch-to-lightning")).click();
			Thread.sleep(20000);
			driver.findElement(By.xpath("//span[@class='uiImage']")).click();
			driver.findElement(By.linkText("Log Out")).click();
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}

	}
	
	@Test
	public void tc003_SalesForce_Classic_NewAccount() {
		WebDriver driver = null;
		try {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			driver.get(salesForceUrl);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys("sivaharasankar@gmail.com");
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys("@mmA002330");
			driver.findElement(By.id("Login")).click();
			
			if(driver.findElements(By.className("switch-to-lightning")).size()>0)
				driver.findElement(By.className("switch-to-lightning")).click();
			
			Thread.sleep(30000);
			driver.findElement(By.xpath("//span[@class='uiImage']")).click();
			driver.findElement(By.linkText("Switch to Salesforce Classic")).click();
			driver.findElement(By.id("createNewButton")).click();
			driver.findElement(By.xpath("//div[@id='createNewMenu']/a")).click();
			driver.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	@Test
	public void tc004_SalesForce_Classic_NewAccount() {
		WebDriver driver = null;
		try {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			driver.get(salesForceUrl);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys("sivaharasankar@gmail.com");
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys("@mmA002330");
			driver.findElement(By.id("Login")).click();
			
			if(driver.findElements(By.className("switch-to-lightning")).size()>0)
				driver.findElement(By.className("switch-to-lightning")).click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//			wait.
			driver.findElement(By.xpath("//span[@class='uiImage']")).click();
			driver.findElement(By.linkText("Switch to Salesforce Classic")).click();
			driver.findElement(By.className("allTabsArrow")).click();
			driver.findElement(By.xpath("//a[contains(@class,'dashboardBlock')]")).click();
			driver.findElement(By.xpath("//input[contains(@title,'New Dashboard')]")).click();
			
			driver.findElement(By.xpath("//em[@class='x-btn-arrow']")).click();
			driver.findElement(By.xpath("//span[text()='Wide']")).click();
			
			WebElement pieChartIcon = driver.findElement(By.id("analytics:chart-pie"));
			WebElement dashboard1 = driver.findElement(By.xpath("(//div[contains(@class,'x-panel-body-noheader')])[19]"));
			
			Actions ac = new Actions(driver);
			ac.dragAndDrop(pieChartIcon, dashboard1).perform();
			
			driver.findElement(By.id("dash_description")).sendKeys("Dashboard Description");
			
			WebElement pieChartTitle = driver.findElement(By.xpath("//input[@class='comp_title over']"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			//js.executeScript("arguments[0].click();", pieChartTitle);
			//js.executeScript("arguments[0].value='PieChart Title'", pieChartTitle);

			driver.findElement(By.xpath("//input[@class='comp_title empty']")).sendKeys("This is PieChart Title");
			
			driver.findElement(By.xpath("//input[@class='comp_footer']")).sendKeys("this is footer1");
			
			WebElement horizontalBarChart = driver.findElement(By.id("analytics:chart-bar"));
			ac.dragAndDrop(horizontalBarChart, dashboard1).perform();
			
			driver.findElement(By.xpath("//input[@class='comp_title empty']")).sendKeys("This is HorizontalBarChart Title");
			driver.findElement(By.xpath("//input[@class='comp_footer']")).sendKeys("this is footer2");
			
			driver.findElement(By.xpath("//img[@alt='Delete']")).click();
			
			driver.switchTo().alert().accept();
			
			driver.findElement(By.xpath("//button[text()='Save']")).click();
			
			driver.switchTo().alert().accept();
			
			
			
			Thread.sleep(30000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
		

}
