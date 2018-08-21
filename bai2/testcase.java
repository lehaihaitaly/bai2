package bai2;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
 

public class testcase {	
	@Test
	public void test() throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
		String path = "https://encodable.com/uploaddemo/";
		String file_location = "C:\\Users\\Phong Vu\\Downloads\\UploadFile.PNG";
		driver.get(path);
		WebElement chooseFile = driver.findElement(By.id("uploadname1"));
		chooseFile.sendKeys(file_location);
		driver.findElement(By.name("subdir1")).click();
		driver.findElement(By.xpath("//select[@name='subdir1']/option[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("newsubdir1")).sendKeys("nashtech1254353");
		Thread.sleep(3000);
		driver.findElement(By.id("formfield-email_address")).sendKeys("nashtech@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.id("formfield-first_name")).sendKeys("nashtech");
		Thread.sleep(3000);
		driver.findElement(By.id("uploadbutton")).click();
		Thread.sleep(3000);
		WebDriverWait myWait = new WebDriverWait(driver, 50000);
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fcuploadsummary")));
		String bodyText = driver.getPageSource();
		Assert.assertEquals("nashtech@gmail.com", bodyText.contains("nashtech@gmail.com"));
		Assert.assertEquals("UploadFile.PNG", bodyText.contains("UploadFile.PNG"));
		Assert.assertEquals("nashtech", bodyText.contains("nashtech"));	}
	
}
