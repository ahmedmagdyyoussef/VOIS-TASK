package PageMethods;

import org.openqa.selenium.WebDriver;
import PageElements.*;


public class CartCheckOutMethods {

    WebDriver driver;
    String Account;
    
    public CartCheckOutMethods(WebDriver driver){

        this.driver = driver;

    }

   
    public void AddToCart(){

    	driver.findElement(CartCheckOutElements.AddToCart).click();
        }
    public void ProceedToCheckout(){

    	driver.findElement(CartCheckOutElements.Proceed).click();
    	driver.findElement(CartCheckOutElements.ProceedToCheckOut).click();
    	driver.findElement(CartCheckOutElements.ProceedToCheckOutSecond).click();
    	driver.findElement(CartCheckOutElements.TermsCheckBox).click();
    	driver.findElement(CartCheckOutElements.ProceedToCheckOutThird).click();

        }
    public void Pay(){

    	driver.findElement(CartCheckOutElements.PayByCheck).click();

        }
    public void ConfirmOrder(){

    	driver.findElement(CartCheckOutElements.ConfirmOrder).click();

        }
    public String GetSuccessMessage(){

    return	driver.findElement(CartCheckOutElements.SuccessMessage).getText();

        }
}

