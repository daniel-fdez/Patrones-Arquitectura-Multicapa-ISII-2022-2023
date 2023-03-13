/*
    PROPÓSITO: se desea otener un modelo de aplicación que agregue objetos transferencia (transers) de distintos componentes de negocio
    CONSECUENCIAS:
        -Ventajas: 
            -Separa la lógica de negocio y simplifica la lógica de cliente
            -Reduce el acoplamiento entre clientes y el modelo de la aplicación
            -Mejora el rendimiento de la red y del cliente
        -Inconvenientes: puede introducti datos desactualizados
*/

public class TBestOfShop {
    protected TCustomer bestCustomer;
    protected TProduct bestProduct;
    protected TBrand bestBrand;
    //...
}

public class ShopTOA{
    TBestOfShop bestOfShop(){
        //...
        TCustomer customer = CustomerDAO.best();
        TProduct product = ProductDAO.best();
        TBrand brand = BrandDAO.best();
        return new TBestOfShop(customer, product, brand);
    }
    //...
}