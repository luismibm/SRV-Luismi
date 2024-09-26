import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


interface Alerta {
    String getMissatge();

    default int getMinuts() {
        return 0;
    }

    int getSegons();
}

class Temporitzador {
    List<Thread> threadList = new ArrayList<>();

    Temporitzador programar(Alerta alerta) {
        threadList.add(Thread.ofVirtual().start(() -> {
            try {
                Thread.sleep(alerta.getSegons() * 1000);
            } catch (Exception e) {
            }
            System.out.println("¡ALERTA! " + alerta.getMissatge());
        }));

        return this;
    }

    public void esperarQueAcabenLesAlertes() throws InterruptedException {
        for (Thread thread : threadList) thread.join();
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Temporitzador temporitzador = new Temporitzador();

        while (true) {
            System.out.print("Mensaje: ");
            String missatge = sc.nextLine();
            if (missatge.isBlank()) {
                break;
            }

            System.out.print("Segundos: ");
            int segons = Integer.parseInt(sc.nextLine());

            temporitzador.programar(new Alerta() {
                @Override
                public String getMissatge() {
                    return missatge;
                }

                @Override
                public int getSegons() {
                    return segons;
                }
            });
        }

        temporitzador.esperarQueAcabenLesAlertes();
    }
}