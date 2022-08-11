package pageObjectModel;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
 
public class amazonMain {
	public static WebDriver driver;
	@Test(priority=1)
	public void amazonTest1()
	{
		WebDriverManager.chromedriver().setup(); 
		driver= new ChromeDriver();
		driver.get("https://www.amazon.in/");
		//driver.manage().window().maximize();
		//amazonSearch amazon1=new amazonSearch(driver);
		amazonSearch amazon1= PageFactory.initElements(driver,amazonSearch.class);
		amazon1.search("headphone");	

	}
	
	@Test(priority=2)
	public void amazonTest2()
	{
		amazonSearchLinks search=new amazonSearchLinks(driver);
		 List<String> actuallist=search.featureCheck();
		 System.out.println(actuallist);
		List<String> expectedlist=new ArrayList<>(Arrays.asList("Featured","Price: Low to High","Price: High to Low","Avg. Customer Review","Newest Arrivals"));
		Assert.assertEquals(actuallist,expectedlist);
	}

	@Test(priority=3)
	public void amazonTest3()
	{
		
		amazonSearchLinks search=new amazonSearchLinks(driver);
		 List <String> actuallist=search.departmentCheck();
		 System.out.println(actuallist);
		 List <String> expectedlist=new ArrayList<>(Arrays.asList("Audio Headphones","On-Ear Headphones","In-Ear Headphones","Over-Ear Headphones","PC Gaming Peripherals","PC Game Headsets"));
		 Assert.assertEquals(actuallist,expectedlist);
	}
	@Test(priority=4)
	public void amazonTest4()
	{
		amazonSearchLinks search=new amazonSearchLinks(driver);
		 List<String> actuallist=search.priceCheck();
		 System.out.println(actuallist);
		List<String> expectedlist=new ArrayList<>(Arrays.asList("Under ₹1,000","₹1,000 - ₹5,000","₹5,000 - ₹10,000","₹10,000 - ₹20,000","Over ₹20,000"));
		Assert.assertEquals(actuallist,expectedlist);
	}


}
