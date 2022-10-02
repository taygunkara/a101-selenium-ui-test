package a101.home;

import a101.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
	
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By acceptCookiesLocator = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
    private final By mainMenuLocator = By.xpath("//a[@data-pk='37a6c1c8-a180-4b87-9ec9-3a29f6453a0c']");
    private final By lowerCategoryLocator = By.xpath("//a[@title='Dizaltı Çorap']");
    
    public void acceptCookies(){
        waitUntilItemShowsUp(acceptCookiesLocator);
        clickElement(acceptCookiesLocator);
    }
    
    public String getTittle() {
        return getTittleOfPage();
    }
    
    public void goToCategory(){
        waitUntilItemShowsUp(mainMenuLocator);
        mouseMovement(mainMenuLocator);
        clickElement(lowerCategoryLocator);
    }
    
    public void refresh() {
        driver.navigate().refresh();
    }
}
