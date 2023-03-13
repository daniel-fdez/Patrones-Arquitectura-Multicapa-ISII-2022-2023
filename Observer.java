/*
    PROPÓSITO: Define una dependencia de uno a muchos entre objetos, de forma que cuando un objeto cambie de estado se notifique y se
               actualicen automáticamente todos los objetos que dependen de él
    CONSECUENCIAS: 
        -Ventajas: 
            -Permite modificar objetos y observadores de manera independiente
            -Acoplamiento abstracto entre sujeto y observador
            -Capacidad de comunicación mediante difusión
        -Inconvenientes: 
            -Actualizaciones inesperadas
            -Protocolo de actualización simple
*/

public class Subject {
    private List<Observer> observers = new ArrayList<Observer>(); private int state;
    public int getState() { return state; }
    public void setState(int state) {
        this.state = state;
        notifyAllObservers(); 
    }
    public void attach(Observer observer){ observers.add(observer); } 
    public void notifyAllObservers(){ 
        for (Observer observer : observers){ observer.update(this); }
    }
}

// En tutorialspoint el observador tiene un puntero al observable en esta version el observador recibe al observable por parámetro 
public interface Observer { 
    public void update(Subject subject); 
}
public class BinaryObserver implements Observer {
        public void update(Subject subject) {
            System.out.println("Binary String: " + Integer.toBinaryString( subject.getState() ) ); 
    }
}

public class OctalObserver implements Observer {
    public void update(Subject subject) {
        System.out.println( "Octal String: " + Integer.toOctalString( subject.getState() ) );
    } 
}

public class HexaObserver implements Observer {
    public void update(Subject subject) {
        System.out.println( "Hex String: " + Integer.toHexString( subject.getState() ) ); 
    } 
}

public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();
        BinaryObserver bo = new BinaryObserver();
        OctalObserver oo = new OctalObserver();
        HexaObserver ho = new HexaObserver();
        subject.attach(bo);
        subject.attach(oo);
        subject.attach(ho);
        suject.setState(7);
    }
}