package Controller;

import UseCase.DecibelMaxManager;

public class DecibelMaxController {
    
    private DecibelMaxManager manager;

    public DecibelMaxController() {
        this.manager = new DecibelMaxManager();
    }

    public boolean max(int input) {
        if (input > manager.getDecibelMax()) {
            return false;
        } return true;
    }

    public void userInput(int input) {
        manager.changeLimit(input);
    }

}
