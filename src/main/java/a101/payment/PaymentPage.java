package a101.payment;

import a101.BasePage;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage {
	
    public PaymentPage(WebDriver driver) {
        super(driver);
    }
    
    public String getUrl() {
        return getPageUrl();
    }
}
