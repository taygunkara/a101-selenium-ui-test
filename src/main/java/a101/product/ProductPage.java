package a101.product;

import a101.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
	
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private final By selectedValueLocator = By.cssSelector(".selected-variant-text");
    private final By addToCartButtonLocator = By.cssSelector(".add-to-basket");
    private final By goToCartPageLocator = By.linkText("Sepeti Görüntüle");
    
    public String getValueName(){
        return findElement(selectedValueLocator).getText();
    }
    
    public void addProductToCart() {
        clickElement(addToCartButtonLocator);
    }
    
    public void goToCartPage() {
        clickElement(goToCartPageLocator);
    }
}
