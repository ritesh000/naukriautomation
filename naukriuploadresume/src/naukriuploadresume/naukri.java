package naukriuploadresume;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.remote.server.handler.UploadFile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class naukri {

	public static String baseurl = "https://www.naukri.com/";
	public static String driverbrowser = "webdriver.chrome.driver";
	public static String driverurl = "C:/Users/rites/Desktop/chrome83/chromedriver.exe";

	public static WebDriver driver;

	@BeforeTest
	public void setBaseUrl() {
		System.setProperty(driverbrowser, driverurl);
		driver = new ChromeDriver();
		driver.get(baseurl);
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void login() throws InterruptedException {

		driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']"))
				.sendKeys("riteshmalav95@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys("ritesh016");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@class='btn-primary loginButton']")).click();
		Thread.sleep(4000);
	}

	@Test(priority = 2)
	public void moveprofilrpage() throws InterruptedException {
		Thread.sleep(4000);
		Actions actions = new Actions(driver);
		WebElement profile = driver.findElement(By.xpath("//div[contains(text(),'My Naukri')]"));
		actions.moveToElement(profile).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Edit Profile')]")).click();
		Thread.sleep(3000);

	}

	@Test(priority = 3)
	public void uploadresume() throws InterruptedException {

     driver.findElement(By.className("uploadBtn")).click();
     
     driver.switchTo().activeElement().sendKeys("C:/Users/rites/Desktop/Resume.pdf");
      
      
	}

	@AfterTest
	public void close() throws InterruptedException {
		int i;

		for (i = 0; i < 5; i++) {
			Thread.sleep(4000);
			driver.navigate().refresh();
		}
		driver.quit();
	}
}
