package magento.services;

import magento.DriverActions;
import magento.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class HomeService {
    private WebDriver driver;
    private HomePage homePage;

    public HomeService(WebDriver driver){
        this.driver=driver;
        this.homePage=new HomePage();
    }

    public void elegirRadiantTee() {
        DriverActions.click(this.homePage.getLinkRadiantTee());
    }

}
