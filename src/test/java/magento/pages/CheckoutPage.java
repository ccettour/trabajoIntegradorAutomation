package magento.pages;

import org.openqa.selenium.By;

public class CheckoutPage {
    private final By btnGoCheckout = By.xpath("//span[normalize-space()='Proceed to Checkout']");

    public By getBtnGoCheckout() {
        return btnGoCheckout;
    }
}
