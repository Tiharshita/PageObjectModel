package TestCases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import Base.basePage;
import BaseTest.TestBase;
import Pages.HomePage;
import Pages.NewCars;
import Utilities.DataUtil;

public class FindNewCarsTest extends TestBase {
	
	
	
	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	public void findNewCarTest(String browser, String runMode, String carBrand, String carBrandTitle) throws InterruptedException {
		
		if(runMode.equals("N")) {
			
			throw new SkipException("Skipping the test as the run mode is No");
		}
		
		
		setUp(browser);
		
		HomePage home = new HomePage(driver);
		NewCars car = home.goToFindNewCars();
		
		
		if(carBrand.equals("bmw")) {
			
			car.gotoBMW();
			
		}else if(carBrand.equals("kia")) {
			
			car.gotoKia();
			
		}else if(carBrand.equals("honda")) {
			
			car.gotoHonda();
			
		}else if(carBrand.equals("toyota")) {
			
			car.gotoToyota();
			
		}
		
		
		String carTitle = basePage.carBase.getCarTitle();
		System.out.println(carTitle);
		
		Assert.assertEquals(carTitle, carBrandTitle);
		
		//BasePage.topNav.gotoNewCars();
		
		Thread.sleep(2000);
		
		
		
		
	}

}
