class Persona {
    @Override
    public String toString() {
        return "toString() of Persona";
    }
}

class Alumno extends Persona {}

public class Main {

    static void imprimirJerarquiaDeClasses(Class<?> c) {
        System.out.print(c.getName() + (c.getSuperclass() != null ? "  >  " : "\n"));
        if (c.getSuperclass() == null) return;
        imprimirJerarquiaDeClasses(c.getSuperclass());
    }

    public static void main(String[] args) {

        Alumno alumno1 = new Alumno(){
            @Override
            public String toString() {
                return "toString() of Alumno";
            }
        };

        imprimirJerarquiaDeClasses(alumno1.getClass());

    }
}