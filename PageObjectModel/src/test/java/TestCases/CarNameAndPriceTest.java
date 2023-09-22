package TestCases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import Base.basePage;
import BaseTest.TestBase;
import Pages.HomePage;
import Pages.NewCars;
import Utilities.DataUtil;

public class CarNameAndPriceTest extends TestBase {

	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	public void carNameAndPrice(String browser, String runMode, String carBrand) {

		if (runMode.equals("N")) {

			throw new SkipException("Skipping the test as the run mode is No");
		}

		setUp(browser);

		HomePage home = new HomePage(driver);
		NewCars car = home.goToFindNewCars();

		if (carBrand.equals("bmw")) {

			car.gotoBMW();

		} else if (carBrand.equals("kia")) {

			car.gotoKia();

		} else if (carBrand.equals("honda")) {

			car.gotoHonda();

		} else if (carBrand.equals("toyota")) {

			car.gotoToyota();

		}

		basePage.carBase.getCarNameAndPrices();

	}

}

