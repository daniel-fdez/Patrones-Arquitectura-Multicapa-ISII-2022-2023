/*
    PROPÓSITO: proporciona una interfaz para crear familias de objetos relacionados o que dependan entre sí, sin especificar sus clases concretas
               Crean objetos pero devuelven interfaces implementados por los objetos creados
    CONSECUENCIAS: 
        -Ventajas: 
            -Aísla las clases concretas de sus clientes
            -Facilita el intercambio de familias de productos
            -Promueve la consistencia entre productos
        -Inconvenientes: 
            -Es difícil dar cabida a nuevos tipos de productos, ya que hay que modificar la factoría
*/

public interface FabricaDeLaberintos {
    public Laberinto hacerLaberinto();
    public Pared hacerPared();
    public Habitacion hacerHabitacion();
    public Puerta hacerPuerta();
}

public class JuegoDelLaberinto {
    //...
    Laberinto crearLaberinto(FabricaDeLaberintos fabrica) {
        Laberinto l = fabrica.hacerLaberinto();
        Habitacion h1 = fabrica.hacerHabitacion();
        Habitacion h2 = fabrica.hacerHabitacion();
        Puerta p = fabrica.hacerPuerta(h1, h2);
        l.anadirHabitacion(h1);
        l.anadirHabitacion(h2);
        h1.establecerLado(Norte, fabrica.hacerPared());
        h1.establecerLado(Este, p);
        h1.establecerLado(Sur, fabrica.hacerPared());
        h1.establecerLado(Oeste, fabrica.hacerPared());
        h2.establecerLado(Norte, fabrica.hacerPared());
        h2.establecerLado(Este, fabrica.hacerPared());
        h2.establecerLado(Sur, fabrica.hacerPared());
        h2.establecerLado(Oeste, p);
        return l;
    }
}

public class FabricaDeLaberintosEncantados implements FabricaDeLaberintos {
//.......
Habitacion hacerHabitacion(int n) { return new HabitacionEncantada(n); }
Puerta hacerPuerta(Habitacion h1, Habitacion h2) { return new PuertaEncantada(h1, h2); }
//........
};

public class FabricaDeLaberintosExplosivos implements FabricaDeLaberintos {
//.......
Habitacion hacerHabitacion(int n) { return new HabitacionExplosiva(n); }
Puerta hacerPuerta(Habitacion h1, Habitacion h2) { return new PuertaExplosiva(h1, h2); }
//........
};

public static void main(String[] args){
    JuegoDelLaberinto juego = new JuegoDelLaberinto();
    FabricaDeLaberintosExplosivos fabrica = new FabricaDeLaberintosExplosivos();
    juego.crearLaberinto(fabrica);
}