package pageObject;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	
	public WebDriver driver;
	By email = By.id("user_email");
	By password = By.id("user_password");
	By login  = By.cssSelector("[type ='submit']");
	
	public loginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement Email() {
		return driver.findElement(email);
		}
	
	public WebElement Password() {
		return driver.findElement(password);
	}
	
	public loginPage Login() {
		driver.findElement(login).click();
		loginPage lp = new loginPage(driver);
		return lp;
	}
}
