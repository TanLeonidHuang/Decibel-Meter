import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GradPaint {
    
    JFrame frame;
    JPanel panel;
    JSlider slider;
    
    public GradPaint () {
    }
    
    void createAndShowGUI () {
        
        final GradPanel gradPanel = new GradPanel ();
        
        slider = new JSlider (0, 200, 0);
        slider.addChangeListener (new ChangeListener () {
            public void stateChanged (ChangeEvent e) {
                
                double newValue = slider.getValue () / (double) slider.getMaximum ();
                gradPanel.setValue (newValue);
            }
        });
        slider.setAlignmentY(BoxLayout.Y_AXIS);
        
        panel = new JPanel ();
        panel.setLayout (new BoxLayout (panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize (new Dimension (50, 500));
        
        panel.add (gradPanel);
        panel.add (slider);
        
        frame = new JFrame ("GradientPainting Demo");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.add (panel);
        frame.pack ();
        frame.setLocationRelativeTo (null);
        frame.setVisible (true);
    }
    
    public static void main (String[] args) {
        
        SwingUtilities.invokeLater (new Runnable () {
            public void run () {
                new GradPaint ().createAndShowGUI ();
            }
        });
    }
}

class GradPanel extends JPanel {
    
    double value;
    
    public void setValue (double newValue) {
        value = newValue;
        repaint ();
    }
    
    public void paintComponent (Graphics g) {
        
        super.paintComponent (g);
        Graphics2D g2 = (Graphics2D) g;
        
        GradientPaint gPaint = new GradientPaint (0, 0, Color.GREEN,
                getWidth (), 0, Color.RED);
        g2.setPaint (gPaint);
        g2.fillRect (0, 0, (int) (getWidth () * value), getHeight ());
    }
}