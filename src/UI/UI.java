package UI;

import Controller.*;
import java.util.Scanner;

public class UI {

    private SoundInputController soundController;
    private DecibelMaxController controller;

    public UI(DecibelMaxController controller) {
        this.controller = controller;
        this.soundController = new SoundInputController(controller);
    }

    public void start() {
        System.out.println("Enter DB max:");
        DecibelMaxController controller = new DecibelMaxController();
        SoundInputController soundController = new SoundInputController(controller);
        Scanner in = new Scanner(System.in);
        int userInt = in.nextInt();
        controller.userInput(userInt);
        soundController.run();
        in.close();
    }
    
}