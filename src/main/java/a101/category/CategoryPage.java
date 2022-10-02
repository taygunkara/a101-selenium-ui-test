package a101.category;

import a101.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryPage extends BasePage {
	
    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    private final By productLocator = By.xpath("//article[@data-sku='25000759001']");

    public void selectFirstProduct() {
        clickElement(productLocator);
    }
}
