package PageElements;

import org.openqa.selenium.By;

public class CartCheckOutElements {
    
    public static By AddToCart = By.name("Submit");
    public static By Proceed = By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a");
    public static By ProceedToCheckOut = By.xpath("/html/body/div/div[2]/div/div[3]/div/p[2]/a[1]");
    public static By ProceedToCheckOutSecond = By.xpath("/html/body/div/div[2]/div/div[3]/div/form/p/button");
    public static By ProceedToCheckOutThird = By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/p/button");
    public static By TermsCheckBox = By.name("cgv");
    public static By PayByCheck = By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[3]/div[2]/div/p/a");
    public static By ConfirmOrder = By.xpath("/html/body/div/div[2]/div/div[3]/div/form/p/button");
    public static By SuccessMessage = By.xpath("/html/body/div/div[2]/div/div[3]/div/p[1]");



    
}
