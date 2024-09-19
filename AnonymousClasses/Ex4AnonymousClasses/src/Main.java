import java.util.ArrayList;
import java.util.List;


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

        new Temporitzador()
                .programar(new Alerta() {
                    @Override
                    public String getMissatge() {
                        return "Hora d'anar al cole";
                    }

                    @Override
                    public int getSegons() {
                        return 5;
                    }
                })
                .programar(new Alerta() {
                    @Override
                    public String getMissatge() {
                        return "Hora de desdejunar";
                    }

                    @Override
                    public int getSegons() {
                        return 1;
                    }
                })
                .esperarQueAcabenLesAlertes();

    }
}