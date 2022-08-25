package UseCase;

import Entity.DecibelMax;

public class DecibelMaxManager {
    
    private DecibelMax limit = new DecibelMax();

    public void changeLimit(int newDB) {
        limit.setDBMax(newDB);
    }

    public int getDecibelMax() {
        return limit.getDBMax();
    }


}