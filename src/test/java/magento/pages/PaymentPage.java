package magento.pages;

import org.openqa.selenium.By;

public class PaymentPage {
    private final By btnPlaceOrder = By.xpath("//button[@title='Place Order']");

    public By getBtnPlaceOrder() {
        return btnPlaceOrder;
    }
}
