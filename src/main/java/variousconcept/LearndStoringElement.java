package variousconcept;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LearndStoringElement {
	
	WebDriver driver;
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	@Test
	public void LoginTest() {
		
	
	WebElement USERNAME_ELEMENT = driver.findElement(By.xpath("//*[@id=\"username\"]"));
	WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//*[@id=\"password\"]"));
	WebElement SIGNIN_BUTTON_ELEMENT = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));
	
	USERNAME_ELEMENT.clear();
	USERNAME_ELEMENT.sendKeys("demo@techfios.com");
	PASSWORD_ELEMENT.sendKeys("abc123");
	SIGNIN_BUTTON_ELEMENT.click();
	
	
	
	WebElement DASHBOARD_HEADER_ELEMENT =  driver.findElement(By.xpath("//h2[contains(text(), 'Dashboard')]"));
	WebElement BANK_ELEMENT = driver.findElement(By.xpath("//span[contains(text(), 'Bank & Cash')]"));
	WebElement NEWACCOUNT_ELEMENT = driver.findElement(By.xpath("//a[contains(text(), 'New Account')]"));
    
    Assert.assertEquals("Wrong Page","Dashboard", DASHBOARD_HEADER_ELEMENT.getText());
	BANK_ELEMENT.click();
	
	WebDriverWait wait = new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.visibilityOf(NEWACCOUNT_ELEMENT));
	NEWACCOUNT_ELEMENT.click();
	
	WebElement NewAccount_Element = driver.findElement(By.xpath("//h2[contains(text(), 'Accounts')]"));
	WebElement Account_Title_Element = driver.findElement(By.xpath("//label[contains(text(), 'Account Title')]"));
	Assert.assertEquals("Wrong page", NewAccount_Element, Account_Title_Element);
	
	Account_Title_Element.sendKeys("sharmin");
	
	
	
	}
	@After
	public void teardown() {
	
		
	}
	
	
	
	
	

}

