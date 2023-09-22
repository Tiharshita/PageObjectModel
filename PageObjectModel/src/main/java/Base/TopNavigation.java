package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TopNavigation {
	
	
public WebDriver driver;
	
	
	public TopNavigation(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	public void gotoNewCars() {
		
	}
	
	
	public void gotoCarLoans() {
		
		
	}
	
}

