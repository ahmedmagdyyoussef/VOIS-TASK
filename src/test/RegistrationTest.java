package test;

import org.testng.annotations.Test;

import ConfigurationManuplation.ConfigFileReader;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import PageMethods.*;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RegistrationTest {

    String FirstName;
    String LastName;
    String FirstName2;
    String LastName2;
    String Address;
    String Alias;
    String City;
    String State;
    String Password;
    String Mobile;
    String ZipCode;
    String Email;
    Row r;
    WebDriver driver;

    RegistrationMethods registration;
String ActualAccountName;
    homemethods home;
    LoginMethods login;
	ConfigFileReader Config;


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
    String filePath = System.getProperty("user.dir")+"\\src\\TestData.xlsx";

    
	FileInputStream fs = new FileInputStream(filePath);
	
	   try (XSSFWorkbook workbook = new XSSFWorkbook(fs)) {
		XSSFSheet sheet = workbook.getSheetAt(0);

	    

		
	FirstName= sheet.getRow(1).getCell(0).toString();
		LastName= sheet.getRow(1).getCell(1).toString();
		Password=sheet.getRow(1).getCell(2).toString();
		FirstName2=sheet.getRow(1).getCell(3).toString();
		LastName2=sheet.getRow(1).getCell(4).toString();
		Address=sheet.getRow(1).getCell(5).toString();
		City=sheet.getRow(1).getCell(6).toString();
		State= (sheet.getRow(1).getCell(7).toString());
		ZipCode=sheet.getRow(1).getCell(8).toString();
		Mobile=sheet.getRow(1).getCell(9).toString();
		Alias=sheet.getRow(1).getCell(10).toString();
		Email=sheet.getRow(1).getCell(11).toString();
	}
		
	
}
    @Test(priority=0)
    public void Register_New_User() throws Exception 
    {
        
    	
    	home =new homemethods(driver);
    	login =new LoginMethods(driver);
    	registration =new RegistrationMethods(driver);
    	//navigate to login page
    	home.PressOnSign();
    	//Add the email 
    	//We will fill the registration form from Excel File
    	try {
			FillData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     try {
     	login.InsertMail(Email);
    	login.PressCreatAccount();
    	
     	registration.SetFirstName(FirstName);
    	}catch (Exception e) {
    		throw new Exception("Could not add this mail as this one already used before"); 
    	}
    	registration.SetLastName(LastName);
    	registration.SetPassword(Password);
    	registration.ClearFirstname2Text();
    	registration.ClearLastName2Text();
    	registration.ClearAlias();
    	registration.SetFirstName2(FirstName2);
    	registration.SetLastName2(LastName2);
    	registration.SetAddress(Address);
    	registration.ChooseState(State);
    	registration.SetCity(City);
    	registration.SetZipCode(ZipCode);
    	registration.SetMobile(Mobile);
    	registration.SetAlias(Alias);
    	registration.Submit();
        ActualAccountName=registration.GetAccountName(); //Get the account Name
        registration.SignOut();
      
        Assert.assertEquals(ActualAccountName, FirstName + " " + LastName); //Verify that user logged in successful
       
    }
  @AfterTest
  public void DriverClose()
  {
	  driver.close();
  }
}
