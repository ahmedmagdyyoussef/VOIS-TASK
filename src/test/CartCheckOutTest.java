package test;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import PageMethods.*;
import ConfigurationManuplation.*;

public class CartCheckOutTest {

   
    WebDriver driver;
    String   Email;
    String Password;
    homemethods home;
    LoginMethods login;
    CartCheckOutMethods cart;
    RegistrationMethods registration;
    String ActualAccountName;
	ConfigFileReader Config;
	LoginTest loginClass;
	

@BeforeTest
    public void setup(){

		Config=new ConfigFileReader();
		
    	System.setProperty("webdriver.chrome.driver", Config.GetDriverLocation());
        
    	driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(Config.GetPortalURL());
        driver.manage().window().maximize();
        
      
    }
@Test
public void MakeOrder() 
{
    login =new LoginMethods(driver);
	home =new homemethods(driver);
	cart =new CartCheckOutMethods(driver);
	String SuccessMessage;

	loginClass=new LoginTest();
    loginClass.LoginSteps(driver);
    login.PressOnReturnHome();
    home.PressOnItem();
    cart.AddToCart();
    WebDriverWait wait = new WebDriverWait(driver,30);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a")));
    cart.ProceedToCheckout();
    cart.Pay();
    cart.ConfirmOrder();
    SuccessMessage = cart.GetSuccessMessage();
	Assert.assertEquals(SuccessMessage,"Your order on My Store is complete."); //Verify that order placed
    
}
@AfterTest
public void DriverClose()
{
	  driver.close();
}
}

