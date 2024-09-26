import java.util.List;

record Producto(String nombre, int precio) {}

class Almacen {

    List<Producto> productos;

    Almacen(List<Producto> productos) { this.productos = productos; }
}


public class Main {
    public static void main(String[] args) {

        Almacen almacen = new Almacen(List.of(new Producto("lapiz", 5), new Producto("boli", 6), new Producto("libro", 10)));

    }
}