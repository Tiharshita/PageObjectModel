package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class basePage{
	
	public WebDriver driver;
	public static CarBase carBase;
	public static TopNavigation topNav;
	
	
	public basePage(WebDriver driver) {
		
		this.driver = driver;
		carBase = new CarBase(driver);
		topNav = new TopNavigation(driver);
		PageFactory.initElements(driver, this);
	}
	

}

