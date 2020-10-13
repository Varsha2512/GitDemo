package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws Exception
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Chaudhary Varsha\\eclipse-workspace\\corejava\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		String urlName = prop.getProperty("url");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.firefox.driver", "D:\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public void getScreenShotPath(String testCaseName, WebDriver driver2) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destFile));
	}

}
