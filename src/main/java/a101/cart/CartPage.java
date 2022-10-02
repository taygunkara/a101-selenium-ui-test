package a101.cart;

import a101.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
	
    public CartPage(WebDriver driver) {
        super(driver);
    }

    private final By cartProductColorLocator = By.cssSelector(".d-inline-block");
    private final By confirmCartLocator = By.cssSelector(".button.green.checkout-button");
    private final By continueWithoutMemberLocator = By.cssSelector(".auth__form__proceed");
    private final By emailLocator = By.name("user_email");
    private final By emailConfirmLocator = By.cssSelector("button.button:nth-child(3)");
    private final By createAddressLocator = By.xpath("//a[@title='Yeni adres oluştur']");
    private final By addressNameLocator = By.name("title");
    private final By firstNameLocator = By.name("first_name");
    private final By lastNameLocator = By.name("last_name");
    private final By phoneNumberLocator = By.name("phone_number");
    private final By cityLocator = By.name("city");
    private final By townLocator = By.name("township");
    private final By districtLocator = By.name("district");
    private final By addressLocator = By.name("line");
    private final By postcodeLocator = By.name("postcode");
    private final By saveButtonLocator = By.cssSelector(".button.green.js-set-country");
    private final By saveAndContinueButtonLocator = By.cssSelector(".button.block.green.js-proceed-button");
    private final By cargoLocator = By.cssSelector(".js-shipping-list > li:nth-child(1) > label");


    public final String addressName = "Home Address";
    public final String postcode = "34975";
    public String getProductColor(){
        return getText(cartProductColorLocator);
    }
    
    public void confirmCart() {
        clickElement(confirmCartLocator);
    }
    
    public void continueWithoutMember() {
        clickElement(continueWithoutMemberLocator);
    }
    
    public void sendEmail() {
        type(emailLocator, setRandomEmail());
        clickElement(emailConfirmLocator);
    }
    
    public void fillTheAddress() {
        clickElement(createAddressLocator);
        type(addressNameLocator, addressName);
        type(firstNameLocator, setRandomName());
        type(lastNameLocator, setRandomLastName());
        type(phoneNumberLocator, setPhoneNumber());
        type(addressLocator, setRandomAddress());
        // type(postcodeLocator, postcode);
    }
    
    public void selectCityTownDistrict() throws InterruptedException {
        selectAddressItem(cityLocator);
        selectAddressItem(townLocator);
        selectAddressItem(districtLocator);
        clickElement(saveButtonLocator);
    }

    public void selectCargo() {
        clickElement(cargoLocator);
        clickElement(saveAndContinueButtonLocator);
    }
}
