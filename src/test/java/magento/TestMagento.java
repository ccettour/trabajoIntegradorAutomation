package magento;

import magento.pages.ThankYouPage;
import magento.services.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestMagento {

    @BeforeMethod
    public void setup() {
        DriverManager.create("chrome");
        DriverManager.getDriver().get("https://magento.softwaretestingboard.com/");
    }

    @Test
    public void comprarRadiantTee(){
        HomeService homeService = new HomeService(DriverManager.getDriver());
        //2. Seleccionar la prenda "Radiant Tee".
        homeService.elegirRadiantTee();

        RadiantTeeService radiantTeeService = new RadiantTeeService();
        //3. Configurar las opciones de la prenda: a. Tamaño: L b. Color: Azul c. Cantidad: 2
        radiantTeeService.configurarOpciones(2);

        //4. Hacer clic en "Add to Cart".
        radiantTeeService.agregarAlCarrito();

        //5. Hacer clic en el enlace "shopping cart".
        radiantTeeService.verCarrito();

        CheckoutService checkoutService = new CheckoutService();
        //6. Hacer clic en "Proceed to Checkout".
        checkoutService.continuarCompra();

        ShippingService shippingService = new ShippingService();
        //7. Completar el formulario de dirección de envío con los datos deseados.
        //8. Seleccionar la primera opción en los Métodos de Envío.
        shippingService.completarDatos("nelson.campos@ggmail.com","Nelson","Campos","QA","Calle Falsa 123","Cordoba","California",90210,"US",351888888);

        //9. Hacer clic en "Next".
        shippingService.irAlUltimoPaso();

        PaymentService paymentService = new PaymentService();
        //10. Hacer clic en "Place Order".
        paymentService.confirmarCompra();


        //Validaciones:
        ThankYouService thankYouService = new ThankYouService();
        //El título es igual a "Thank you for purchase!"
       //Assert.assertEquals(thankYouService.getTitleText(), "Thank you for your purchase!", "El texto no coincide.");


        //El botón "Continue Shopping" está habilitado.
       Assert.assertTrue(thankYouService.isEnableContinueShopping());


        //El botón "Create an Account" está visible.
       Assert.assertTrue(thankYouService.isVisibleCreateAccount());


        //El número de la orden (Your order # is:) es un número

    }
}
