package magento.services;

import magento.DriverActions;
import magento.DriverManager;
import magento.pages.ShippingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class ShippingService {
    private ShippingPage shippingPage;

    public ShippingService(){
        this.shippingPage=new ShippingPage();
    }

    public void completarDatos(String email, String nombre, String apellido, String compania, String direccion, String ciudad, String estado, int cp, String pais, long telefono){
        DriverActions.insertText(this.shippingPage.getTxtEmail(), email);
        DriverActions.insertText(this.shippingPage.getTxtFName(), nombre);
        DriverActions.insertText(this.shippingPage.getTxtLName(), apellido);
        DriverActions.insertText(this.shippingPage.getTxtCompany(), compania);
        DriverActions.insertText(this.shippingPage.getTxtStreetAddress(), direccion);
        DriverActions.insertText(this.shippingPage.getTxtCity(), ciudad);
        Select selectState = new Select(DriverManager.getDriver().findElement(By.name("region_id")));
        selectState.selectByVisibleText(estado);
        DriverActions.insertText(this.shippingPage.getTxtCP(), cp+"");
        Select selectCountry = new Select(DriverManager.getDriver().findElement(By.name("country_id")));
        selectCountry.selectByValue(pais);
        DriverActions.insertText(this.shippingPage.getTxtPhone(), telefono+"");
        DriverActions.click(this.shippingPage.getRbShippingMethod());
    }

    public void irAlUltimoPaso(){
        DriverActions.click(this.shippingPage.getBtnNext());
    }
}