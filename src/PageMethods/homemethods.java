package PageMethods;
import PageElements.*;

import org.openqa.selenium.WebDriver;

public class homemethods {
    WebDriver driver;

    public homemethods(WebDriver driver){

        this.driver = driver;

    }

    //Get the User name from Home Page

        public void PressOnSign(){

             driver.findElement(HomeElements.Signin).click();
        }
        public void PressOnItem(){

        	driver.findElement(HomeElements.Item).click();
			
       }
}
