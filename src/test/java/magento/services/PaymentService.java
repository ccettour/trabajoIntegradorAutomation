package magento.services;

import magento.DriverActions;
import magento.DriverManager;
import magento.pages.PaymentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentService {
    private PaymentPage paymentPage;

    public PaymentService(){
        this.paymentPage = new PaymentPage();
    }

    public void confirmarCompra(){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loading-mask")));
        DriverActions.click(this.paymentPage.getBtnPlaceOrder());
    }
}
