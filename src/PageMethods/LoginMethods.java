package PageMethods;
import PageElements.*;

import org.openqa.selenium.WebDriver;

public class LoginMethods {
    WebDriver driver;

    public LoginMethods(WebDriver driver){

        this.driver = driver;

    }

        public void InsertMail(String email){

             driver.findElement(LoginElements.Email).sendKeys(email);

        }
        public void PressCreatAccount(){

            driver.findElement(LoginElements.CreateAccount).click();

       }
        public void InsertLoginMail(String email){

            driver.findElement(LoginElements.LoginMail).sendKeys(email);

       }
        public void InsertPassword(String password){

            driver.findElement(LoginElements.Password).sendKeys(password);

       }
        public void PressonSubmit(){

            driver.findElement(LoginElements.Submit).click();

       }
        public void PressOnReturnHome(){

            driver.findElement(LoginElements.ReturnToHome).click();

       }
}
