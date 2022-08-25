package UseCase;

import Entity.DecibelMax;

public class DecibelMaxManager {
    
    private DecibelMax limit = new DecibelMax();

    public void changeLimit(int newDouble) {
        limit.setDBMax(newDouble);
    }

    public int getDecibelMax() {
        return limit.getDBMax();
    }


}