package test;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import PageMethods.*;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ConfigurationManuplation.*;

public class LoginTest {

   
    WebDriver driver;
    String   Email;
    String Password;
    homemethods home;
    LoginMethods login;
    RegistrationMethods registration;
    String ActualAccountName;
	private String FirstName;
	private String LastName;
	ConfigFileReader Config;
	int counter;

@BeforeTest
    public void setup(){

		Config=new ConfigFileReader();
    	System.setProperty("webdriver.chrome.driver", Config.GetDriverLocation());
    	driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Config.GetPortalURL());
        driver.manage().window().maximize();
    
    }

   
public void FillData() throws IOException {
    String filePath = System.getProperty("user.dir")+"\\src\\Excel\\TestData.xlsx";

	FileInputStream fs = new FileInputStream(filePath);
	
	   try (XSSFWorkbook workbook = new XSSFWorkbook(fs)) {
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		Password=sheet.getRow(1).getCell(2).toString();
		Email=sheet.getRow(1).getCell(11).toString();
		FirstName= sheet.getRow(1).getCell(0).toString();
		LastName= sheet.getRow(1).getCell(1).toString();
		System.out.println("softAssert Method Was Executed" +Email + counter );

		
	}
		
	
}
    @Test(priority=0)
    public void Login() throws InterruptedException 
    {
    	LoginSteps(driver);
    	Thread.sleep(4000);
    	Assert.assertEquals(ActualAccountName, FirstName + " " + LastName); //Verify that user logged in successful
    }
    public void LoginSteps(WebDriver driver) {
    	home =new homemethods(driver);
    	login =new LoginMethods(driver);
    	registration=new RegistrationMethods(driver);
    	//navigate to login page
    	home.PressOnSign();
    	//We will fill the data form from Excel File
    	try {
			FillData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     	login.InsertLoginMail(Email);
    	login.InsertPassword(Password);
    	login.PressonSubmit();
        ActualAccountName=registration.GetAccountName(); //Get the account Name
     
	}
    @AfterTest
    public void DriverClose()
    {
  	  driver.close();
    }
}