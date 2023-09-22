package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Base.basePage;


public class NewCars extends basePage{
	
	
	public NewCars(WebDriver driver) {
		super(driver);
		
		// TODO Auto-generated constructor stub
	}

	@FindBy(linkText = "BMW")
	public WebElement bmw;

	public BMWCarsPage gotoBMW() {
		
		bmw.click();
		
		return new BMWCarsPage(driver);
		
	}
	
	@FindBy(linkText = "Toyota")
	public WebElement toyota;
	
	public ToyotaCarPage gotoToyota() {
		
		toyota.click();
		
		return new ToyotaCarPage(driver);
		
	}
	
	
	@FindBy(linkText = "Honda")
	public WebElement honda;
	public HondaCarsPage gotoHonda() {
		
		honda.click();
		
		return new HondaCarsPage(driver);
		
	}
	
	
	@FindBy(linkText = "Kia")
	public WebElement kia;
	public KiaCarsPage gotoKia() {
		
		
		kia.click();
		
		return new KiaCarsPage(driver);
	}

}
