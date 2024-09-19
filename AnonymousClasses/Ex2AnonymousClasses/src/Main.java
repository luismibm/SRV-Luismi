class Notification {
    void show(int num) {
        System.out.println("You have " + num + " new messages");
    }
}

public class Main {
    public static void main(String[] args) {

        Notification notification = new Notification() {
            @Override
            void show(int n) {
                if (n == 1) {
                    System.out.println("You have 1 message");
                } else if (n > 99) {
                    System.out.println("You have +99 messages");
                } else {
                    System.out.println("You have " + n + " messages");
                }
            }
        };

        notification.show(1);
        notification.show(10);
        notification.show(99);
        notification.show(100);
        notification.show(135);

    }
}