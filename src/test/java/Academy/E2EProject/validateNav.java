
package Academy.E2EProject;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import pageObject.LandingPage;

import resources.BaseClass;

public class validateNav extends BaseClass{
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
	log.info("Navigated to Navbar");
}

	@Test
	
	public void basePageNavigation() throws Exception {
		
		
		LandingPage l = new LandingPage(driver);
		Assert.assertTrue(l.getNav().isDisplayed());
	}
}
	
	
	
