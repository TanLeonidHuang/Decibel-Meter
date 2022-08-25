package Gateway;

import javax.sound.sampled.*;

import Controller.DecibelMaxController;

public class Sound implements SoundInterface{

    protected TargetDataLine targetLine = null;
    
    public void run(DecibelMaxController controller) {
        boolean running = true;
        AudioFormat audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100, 16, 2, 4, 44100, false);
        DataLine.Info dataInfo = new DataLine.Info(TargetDataLine.class, audioFormat);
        if(!AudioSystem.isLineSupported(dataInfo)) {
            System.out.println("Not Supported");
        }

        try {
            targetLine = (TargetDataLine) AudioSystem.getLine(dataInfo);
            targetLine.open();
            targetLine.start();
        } catch (LineUnavailableException ex) {
            System.out.println("The TargetDataLine is unavailable");
        }
        int level = 0;
        byte tempBuffer[] = new byte[6000];
        try {
            while(running) {
                if (targetLine.read(tempBuffer, 0, tempBuffer.length) > 0) {
                    level = calculateRMSLevel(tempBuffer);
                    if (controller.max(level)) {
                        System.out.println(level);
                    } else {
                        System.out.println("Too loud");
                        running = false;
                    }
                }
            }
        } catch(Exception ex) {
            System.out.println(ex);
            System.exit(0);
        }
    }
    

    public static int calculateRMSLevel(byte[] audioData) {
        long lSum = 0;
        for(int i = 0; i < audioData.length; i++)
            lSum = lSum + audioData[i];

        double dAvg = lSum / audioData.length;

        double sumMeanSquare = 0d;
        for(int j = 0; j < audioData.length; j++)
            sumMeanSquare = sumMeanSquare + Math.pow(audioData[j] - dAvg, 2d);

        double averageMeanSquare = sumMeanSquare / audioData.length;
        return (int)(Math.pow(averageMeanSquare, 0.5d) + 0.5) - 50;
    }

    public void close() {
        this.targetLine.close();
    }
    
}
