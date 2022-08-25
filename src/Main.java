import Controller.DecibelMaxController;
import UI.UI;

public class Main {

    public static void main(String args[]) {
        DecibelMaxController controller = new DecibelMaxController();
        UI UI = new UI(controller);
        UI.start();

    }
}


