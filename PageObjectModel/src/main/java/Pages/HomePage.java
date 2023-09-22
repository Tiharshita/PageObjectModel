package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


import Base.basePage;

public class HomePage extends basePage {
	
	



	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	public void searchCar() {
		
		
	}
	
	
	@FindBy(xpath = "//div[normalize-space()='NEW CARS']")
	public WebElement menu;
	
	 @FindBy(xpath = "//div[contains(text(),'Find New Cars')]")
	public WebElement findNewCars;
	
	
	public NewCars goToFindNewCars() {
		
		
		Actions action = new Actions(driver);
		action.moveToElement(menu).perform();
		
		findNewCars.click();
		
		return new NewCars(driver);
	}
	
	
	public void goToBuyUsedCars() {
		
		
		
	}

}

