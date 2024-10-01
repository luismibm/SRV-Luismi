import java.util.List;

interface Action {
    abstract void doAction(Producto p);
}

record Producto(String nombre, int precio) {}

class Almacen {

    List<Producto> productos;

    Almacen(List<Producto> productos) { this.productos = productos; }

    void forEachProduct(Action a) {
        for (Producto p : productos) {
            a.doAction(p);
        }
    }

}


public class Main {
    public static void main(String[] args) {

        Almacen almacen = new Almacen(List.of(new Producto("lapiz", 5), new Producto("boli", 6), new Producto("libro", 10)));

        almacen.forEachProduct(p-> System.out.println(p));

    }
}