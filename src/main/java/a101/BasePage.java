package a101;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
	
    public WebDriver driver;
    
    public BasePage(WebDriver driver){
        this.driver = driver;
    }
    
    public WebElement findElement(By locator){
        waitUntilItemShowsUp(locator);
        return driver.findElement(locator);
    }
    
    public void clickElement(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        findElement(locator).click();
    }
    
    public String getTittleOfPage(){
        return driver.getTitle();
    }
    
    public void waitUntilItemShowsUp(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    public void mouseMovement(By locator){
        Actions action = new Actions(driver);
        action.moveToElement(findElement(locator)).perform();
    }
    
    public String getText(By locator){
        waitUntilItemShowsUp(locator);
        return findElement(locator).getText();
    }
    
    public String setRandomEmail(){
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }
    
    public String setRandomName(){
        Faker faker = new Faker();
        return faker.name().firstName();
    }
    
    public String setRandomLastName(){
        Faker faker = new Faker();
        return faker.name().lastName();
    }
    public String setRandomAddress(){
        Faker faker = new Faker();
        return faker.address().streetAddress();
    }
    
    public String setPhoneNumber(){
        Faker faker = new Faker();
        return faker.phoneNumber().phoneNumber();
    }
    
    public void selectAddressItem(By locator) throws InterruptedException {
        Thread.sleep(500);
        Select items = new Select(findElement(locator));
        items.selectByIndex(1);
    }
    
    public void type(By locator, String text){
        findElement(locator).sendKeys(text);
    }
    
    public String getPageUrl(){
        return driver.getCurrentUrl();
    }
}
