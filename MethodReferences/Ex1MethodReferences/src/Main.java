import java.util.ArrayList;
import java.util.List;

interface MyLambda<A> {
    A doMyLambda(String name);
}

class CreadorDeObjetos {
    static <T> List<T> crear(MyLambda<T> lambda, List<String> names) {
        List<T> objects = new ArrayList<>();

        for(String name : names) {
            objects.add(lambda.doMyLambda(name));
        }

        return objects;
    }
}

record Ciudad (String name) {}

class Album {
    String titulo;
    Album(String titulo){ this.titulo = titulo; }
    public String toString() { return "Album{titulo='" + titulo + "'}"; }
}

class Coche {
    String marca;
    Coche(String marca){ this.marca = marca; }
    public String toString() { return "Coche{marca='" + marca + "'}"; }
}


public class Main {
    public static void main(String[] args) {

        // Crea les llistes
        var ciudades = CreadorDeObjetos.crear(Ciudad::new, List.of("Valencia", "Madrid", "Barcelona"));

        // Imprimeix-les
        ciudades.forEach(System.out::println); // Method Reference
        ciudades.forEach(ciudad -> System.out.println(ciudad.toString())); // Lambda Expression

    }
}