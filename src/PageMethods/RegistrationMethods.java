package PageMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import PageElements.*;


public class RegistrationMethods {

    WebDriver driver;
    String Account;
    
    public RegistrationMethods(WebDriver driver){

        this.driver = driver;

    }

    public void SetFirstName(String FirstName){

        driver.findElement(RegistrationElements.FirstName).sendKeys(FirstName);
    }
    
    public void SetLastName(String LastName){

        driver.findElement(RegistrationElements.LastName).sendKeys(LastName);
    }
    
    public void SetPassword(String Password){

        driver.findElement(RegistrationElements.Password).sendKeys(Password);
    }
    
    public void SetFirstName2(String FirstName2){

        driver.findElement(RegistrationElements.FirstName2).sendKeys(FirstName2);
    }
    
    public void ClearFirstname2Text(){

    	driver.findElement(RegistrationElements.FirstName2).clear();
    }
    public void ClearLastName2Text(){

    	driver.findElement(RegistrationElements.LastName2).clear();
    }
    
    public void SetLastName2(String LastName2){

        driver.findElement(RegistrationElements.LastName2).sendKeys(LastName2);
    }
    
    public void SetAddress(String Address){

        driver.findElement(RegistrationElements.Address).sendKeys(Address);
    }
    
    public void SetCity(String City){

        driver.findElement(RegistrationElements.City).sendKeys(City);
    }
    
    public void ChooseState(String State){

       Select StateSelected= new Select(driver.findElement(RegistrationElements.State));
       StateSelected.selectByVisibleText(State);
    }
    
    public void SetZipCode(String ZipCode){

        driver.findElement(RegistrationElements.ZipCode).sendKeys(ZipCode);
    }
    
    public void SetMobile(String Mobile){

        driver.findElement(RegistrationElements.Mobile).sendKeys(Mobile);
    }
    
    public void SetAlias(String Alias){

        driver.findElement(RegistrationElements.Alias).sendKeys(Alias);
    }
    public void ClearAlias(){

        driver.findElement(RegistrationElements.Alias).clear();
    }
    public void Submit(){

        driver.findElement(RegistrationElements.Submit).click();;
    }

    public String GetAccountName(){

    return Account = driver.findElement(RegistrationElements.AccountName).getText().toString();
    }
    public void SignOut(){

    	driver.findElement(RegistrationElements.SignOut).click();
        }
}
