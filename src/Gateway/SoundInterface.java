package Gateway;

import Controller.DecibelMaxController;

public interface SoundInterface {
    void run(DecibelMaxController controller);
    void close();
}
