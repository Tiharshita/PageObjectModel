package Base;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarBase {
	
public WebDriver driver;
	
	
	public CarBase(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//*[@id=\"root\"]/div[2]/div/div[2]/div/h1")
	private WebElement carTitle;

	public String getCarTitle() {
		
		return carTitle.getText();
	}

	@FindBy(xpath="//div/div/div/a/h3")
	private List<WebElement> carNames;
	
	@FindBy(xpath="//div/div[3]/div/span/span[1]")
	private List<WebElement> carPrices;
	
	
	public void getCarNameAndPrices() {
		
		
		for(int i=0; i<carPrices.size(); i++) {
			
			
			System.out.println(carNames.get(i).getText()+"----Car Price is :-- "+carPrices.get(i).getText());
			
		}
		
		
	}
	
	
}


