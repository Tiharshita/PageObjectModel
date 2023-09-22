package Rough;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.HomePage;
import Pages.NewCars;


public class FindNewCars {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.carwale.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		HomePage home = new HomePage(driver);
		NewCars car = home.goToFindNewCars();		
		car.gotoBMW();	
			
		
		
		//new HomePage(driver).goToFindNewCars().gotoBMW();
		
		
	}

}
