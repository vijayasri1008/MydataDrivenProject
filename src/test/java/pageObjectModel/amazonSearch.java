package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class amazonSearch {
	//@FindBy(id="twotabsearchtextbox") WebElement e1;
	@FindBy(how=How.ID,using="twotabsearchtextbox") WebElement e1;
	@FindBy(id="nav-search-submit-button") WebElement e2;
	WebDriver driver;
	public amazonSearch(WebDriver driver)
	{
		this.driver=driver;
	}
	// By searchBox=By.id("twotabsearchtextbox");
	 // By clickOn=By.id("nav-search-submit-button");
	public void search(String searchItem)
	{
		e1.sendKeys(searchItem);
		e2.click();
	}

}
