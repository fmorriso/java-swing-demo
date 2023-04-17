import javax.swing.*;
import java.awt.*;

public class GUI implements Runnable
{
    @Override
    public void run()
    {
        final int multipleOf = 10;
        Dimension scaledSize = getScaledSize(0.45, multipleOf);
        System.out.format("Main page size (w: %d, h: %d): %n",scaledSize.width, scaledSize.height);

        String title = String.format("Swing Demo using java version: %s%n", System.getProperty("java.version"));
        HelloDemo frame = new HelloDemo(title, scaledSize);
        frame.setSize(scaledSize);
        frame.setPreferredSize(scaledSize);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // puts the JFrame in the middle of the physical screen
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

    /**
     * Gets a rectangle that is scaled to a percentage of available device screen size,
     * rounded up to the specified multiple.
     *
     * @param pct - the percentage (> 0 and < 1.0) of available device screen size to use.
     * @param multipleOf - value to round up the scaled size to be a multiple of.
     * @return - a Dimension object that holds the scaled width and height.
     */
    private static Dimension getScaledSize(double pct, int multipleOf)
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(screenSize);
        if (pct < 0.1 || pct > 1)
            return screenSize;
        System.out.format("Screen width=%d, height=%d%n", screenSize.width, screenSize.height);
        final int frameHeight = (int) (screenSize.height * pct) / multipleOf * multipleOf;
        final int frameWidth = (int) (screenSize.width * pct) / multipleOf * multipleOf;
        Dimension frameSize = new Dimension(frameWidth, frameHeight);
        System.out.format("scaled frame: width=%d, height=%d%n", frameWidth, frameHeight);
        return frameSize;
    }
}
