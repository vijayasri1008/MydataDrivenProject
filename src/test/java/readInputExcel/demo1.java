package readInputExcel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demo1 {
	 WebDriver driver;
	@Test(dataProvider="login",dataProviderClass=dataGiven.class)
	public void test1(Object firstname,Object lastword,Object date) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		  driver= new ChromeDriver();
		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
		WebElement user=driver.findElement(By.name("firstname"));
		user.sendKeys(String.valueOf(firstname));
		WebElement pass=driver.findElement(By.name("lastname"));
		pass.sendKeys(String.valueOf(lastword));
		WebElement submit=driver.findElement(By.id("datepicker"));
		submit.sendKeys(String.valueOf(date));
		Thread.sleep(2000);
		driver.quit();

	}


}
