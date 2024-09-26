import java.util.List;

interface Filtre {
    boolean filtrar(Estudiante student);
}

record Estudiante(String name, int nota){}

class MostradorDeAlumnos {
    void mostrar(List<Estudiante> students, Filtre filtro){
        for (Estudiante student : students) {
            if (filtro.filtrar(student)) {
                System.out.println(student);
            }
        }
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

        MostradorDeAlumnos mostradorDeAlumnos = new MostradorDeAlumnos();
        mostradorDeAlumnos.mostrar(students, s -> s.nota() >= 5);
        mostradorDeAlumnos.mostrar(students, s -> s.name().contains("c"));
        mostradorDeAlumnos.mostrar(students, s -> true);

    }
}