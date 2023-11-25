package magento.services;

import magento.DriverActions;
import magento.pages.RadiantTeePage;

public class RadiantTeeService {
    private RadiantTeePage radiantTeePage;

    public RadiantTeeService(){
        this.radiantTeePage=new RadiantTeePage();
    }

    //3. Configurar las opciones de la prenda: a. Tamaño: L b. Color: Azul c. Cantidad: 2
    public void configurarOpciones(int cantidad){
        DriverActions.click(this.radiantTeePage.getTalleL());
        DriverActions.click(this.radiantTeePage.getColorBlue());
        DriverActions.insertText(this.radiantTeePage.getTxtQty(), cantidad+"");
    }

    //4. Hacer clic en "Add to Cart".
    public void agregarAlCarrito(){
        DriverActions.click(this.radiantTeePage.getBtnAddToCart());
    }

    //5. Hacer clic en el enlace "shopping cart".
    public void verCarrito(){
        DriverActions.click(this.radiantTeePage.getLinkShoppingCart());
    }
}
