public class Main {

    abstract static class HolaMon {
        private String frase;

        public abstract void setFrase();

        public void saludar(){
            setFrase();
            System.out.println(frase);
        }
    }

    static class HolaMonAngles extends HolaMon {
        private String frase = "Hello World";
        @Override
        public void setFrase() {

        }
        @Override
        public void saludar() {
            System.out.println(frase);
        }
    }

    public void ferSalutacio() {


    }

    public static void main(String... args) {
        Main myApp = new Main();
        myApp.ferSalutacio();

        HolaMonAngles angles = new HolaMonAngles();
        angles.saludar();

        HolaMon frances = new HolaMon() {
            @Override
            public void setFrase() {

            }
            @Override
            public void saludar() {
                System.out.println("Salut tout le monde");
            }
        };
        frances.saludar();

    }
}