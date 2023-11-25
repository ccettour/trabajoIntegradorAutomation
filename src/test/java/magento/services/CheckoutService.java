package magento.services;

import magento.DriverActions;
import magento.pages.CheckoutPage;

public class CheckoutService {
    private CheckoutPage checkoutPage;

    public CheckoutService(){
        this.checkoutPage = new CheckoutPage();
    }

    public void continuarCompra(){
        DriverActions.click(this.checkoutPage.getBtnGoCheckout());
    }
}
