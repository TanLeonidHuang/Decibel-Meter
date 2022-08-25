package Controller;

import Gateway.*;

public class SoundInputController {
    private DecibelMaxController controller;
    private SoundInterface sound;

    public SoundInputController(DecibelMaxController controller) {
        this.sound = new Sound();
        this.controller = controller;
        }

    public void run() {
        final Runnable r = new Runnable() {
            @Override
            public void run() {
                sound.run(controller);
                Runtime.getRuntime().addShutdownHook(new Thread() {
                    @Override
                    public void run() {
                        sound.close();
                    }
                });
            }
        };
        new Thread(r).start();
    }

}

