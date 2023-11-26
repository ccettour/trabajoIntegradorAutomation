package magento.services;

import magento.DriverActions;
import magento.pages.ThankYouPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ThankYouService {
    private ThankYouPage thankYouPage;

    public ThankYouService() {
        this.thankYouPage=new ThankYouPage();
    }

    public String getTitleText(){
        return DriverActions.getText(this.thankYouPage.getTitulo());
    }

    public Boolean isVisibleCreateAccount(){
        return DriverActions.isVisible(this.thankYouPage.getBtnCreateAccount());
    }

    public Boolean isEnableContinueShopping(){
        return DriverActions.isEnabled(this.thankYouPage.getBtnContinueShopping());
    }

    //public String getOrderText(){return DriverActions.getText(this.thankYouPage.getNroOrden());}
    public Boolean orderNumberIsANumber(){
        return esNumero(obtenerOrderNumber(this.thankYouPage.getNroOrden()));
    }

    public String obtenerOrderNumber(By element){
        String elemento = DriverActions.getText(element);
        String[] palabras = elemento.split("\\s+");
        String numeroOrden = null;
        for (String palabra:palabras) {
            if(palabra.matches("\\d+\\.?")){
                numeroOrden=palabra;
                break;
            }
        }
        return numeroOrden;
    }

    public Boolean esNumero(String cadena){
        try{
            Double.parseDouble(cadena);
            return true;
        } catch(NumberFormatException nfe){
            return false;
        }
    }
}
