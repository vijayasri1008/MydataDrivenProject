package pageObjectModel;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class amazonSearchLinks {
	WebDriver driver;
	
	public amazonSearchLinks(WebDriver driver)
	{
		this.driver=driver;

	}
	By featureClick=By.id("a-autoid-0-announce");
	By insideOptions=By.xpath("//ul[@role='listbox']/li/a");
	By departmentLink=By.xpath("//ul[@aria-labelledby=\"n-title\"]/li/span/a");//ul[@aria-labelledby="p_90-title"]/li/span/a
	By price=By.xpath("//ul[@aria-labelledby=\"p_36-title\"]/li/span/a[position()<=5]");
	
	public List<String> featureCheck() 
	{
		driver.findElement(featureClick).click();
		List<WebElement> featureList=driver.findElements(insideOptions);
		List<String> featurelist1=new ArrayList<>();
		for(WebElement ele:featureList)
		{
			String text=ele.getText();
			featurelist1.add(text);
		}
		return featurelist1;
	}
	public List<String> departmentCheck() 
	{
		List<WebElement> featureList=driver.findElements(departmentLink);
		List<String> featurelist1=new ArrayList<>();
		for(WebElement ele:featureList)
		{
			String text=ele.getText();
			featurelist1.add(text);
		}
		return featurelist1;
	}
	public List<String> priceCheck() 
	{
		List<WebElement> priceList=driver.findElements(price);
		List<String> pricelist1=new ArrayList<>();
		for(WebElement ele:priceList)
		{
			String text=ele.getText();
			pricelist1.add(text);
		}
		System.out.println(pricelist1);
		return pricelist1;
	}
}
