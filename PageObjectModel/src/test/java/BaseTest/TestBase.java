package BaseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import Utilities.DbManager;
import Utilities.ExcelReader;
import Utilities.MonitoringMail;

public class TestBase {
	
	public WebDriver driver;
	public Properties OR = new Properties();
	public Properties config = new Properties();
	public FileInputStream fis;
	public ExcelReader excel = new ExcelReader("./src/test/resources/excel/testdata.xlsx");
	public Logger log = Logger.getLogger(TestBase.class);
	public MonitoringMail mail = new MonitoringMail();
	public WebDriverWait wait;

	public void setUp(String browser) {

		PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");

		log.info("Test Execution started !!!");

		try {
			fis = new FileInputStream("./src/test/resources/properties/config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(fis);
			log.info("Config properties file loaded !!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (browser.equals("chrome")) {

			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);

			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);

			driver = new ChromeDriver(options);
			log.info("chrome browser launched");
		} else if (browser.equals("firefox")) {

			driver = new FirefoxDriver();
			log.info("Firefox browser launched");
		}

		driver.get(config.getProperty("testsiteurl"));
		log.info("Navigated to : " + config.getProperty("testsiteurl"));

		driver.manage().window().maximize();
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait"))));

		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(config.getProperty("explicit.wait"))));

		try {
			DbManager.setMysqlDbConnection();
			log.info("Database connection established !!!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@AfterMethod
	public void tearDown() {

		if (driver != null) {
			driver.quit();
			log.info("Test execution completed !!!");
		}
	}

}


