import java.util.List;

interface Filtre {
    boolean filtrar(int numero);
}

record Estudiante(String name, int nota){}

class MostradorDeAlumnos(List<Estudiante> students, Filtre filtro) {
    void mostrar(){

    }
}

public class Main {
    public static void main(String[] args) {

        List<Estudiante> students = List.of (
                new Estudiante("Daniel", 9),
                new Estudiante("Ikeri", 8),
                new Estudiante("Martín", 6),
                new Estudiante("Luismi", 4)
        );

    }
}