package Academy.E2EProject;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.loginPage;
import resources.BaseClass;

public class HomePage extends BaseClass{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	@AfterTest
	public void teardown() {
		driver.close();
	}
	@BeforeTest
	public void tearUP() throws Exception {
		driver = initializeDriver();
		driver.get("http://www.qaclickacademy.com/");
		log.info("Home page declaration");
	}

	@Test(dataProvider="getData")
	
	public void basePageNavigation(String Username, String Password) throws Exception {
		
		LandingPage lp = new LandingPage(driver);
		lp.getLogin().click();
		 loginPage log = new loginPage(driver);
		 log.Email().sendKeys(Username);
		 log.Password().sendKeys(Password);
		 
		 
		 
	}
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][2];
		data[0][0]= "Notrestricted@gmail.com";
		data[0][1]= "Coventry@2020";

		
		return data;
	}
}
