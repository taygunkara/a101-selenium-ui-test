package a101.shopping;

import a101.BaseTest;
import a101.cart.CartPage;
import a101.category.CategoryPage;
import a101.home.HomePage;
import a101.payment.PaymentPage;
import a101.product.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Shopping extends BaseTest {
	
    HomePage homePage;
    CategoryPage categoryPage;
    ProductPage productPage;
    CartPage cartPage;
    PaymentPage paymentPage;
    
    private final String expectedTitleName = "A101 HARCA HARCA BİTMEZ";
    private final String expectedValueName = "Seçılen Renk: SİYAH";
    private final String expectedColorName = "SİYAH";
    private final String expectedURL = "https://www.a101.com.tr/orders/checkout/";


    @Test
    public void endToEndShoppingTest() throws InterruptedException {

        homePage = new HomePage(driver);
        homePage.acceptCookies();
        Assert.assertEquals(homePage.getTittle(),
                expectedTitleName);

        categoryPage = new CategoryPage(driver);
        productPage = new ProductPage(driver);
        homePage.refresh();
        homePage.goToCategory();
        categoryPage.selectFirstProduct();
        Assert.assertEquals(productPage.getValueName(),
                expectedValueName);

        cartPage = new CartPage(driver);
        productPage.addProductToCart();
        productPage.goToCartPage();
        Assert.assertEquals(cartPage.getProductColor(),
                expectedColorName);

        cartPage.confirmCart();
        cartPage.continueWithoutMember();
        cartPage.sendEmail();
        cartPage.fillTheAddress();
        cartPage.selectCityTownDistrict();
        cartPage.selectCargo();
        paymentPage = new PaymentPage(driver);
        Assert.assertEquals(paymentPage.getUrl(),
                expectedURL);

    }
}
