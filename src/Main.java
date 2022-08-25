import Controller.DecibelMaxController;
import Gateway.Sound;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        Sound recorder = new Sound();
        DecibelMaxController controller = new DecibelMaxController();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter DB max: ");
        int userInput = scanner.nextInt();
        controller.userInput(userInput);
        final Runnable r = new Runnable() {
            @Override
            public void run() {
                recorder.run(controller);
                Runtime.getRuntime().addShutdownHook(new Thread() {
                    @Override
                    public void run() {
                        recorder.close();
                    }
                });
            }
        };
        new Thread(r).start();
    }
}

