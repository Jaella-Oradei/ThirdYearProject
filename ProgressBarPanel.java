import javax.swing.*;
import java.awt.*;

public class ProgressBarPanel extends JPanel {
    private int goal = 100; // The goal value
    private int currentProgress = 0; // Current progress

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawProgressBar(g);
    }

    private void drawProgressBar(Graphics g) {
        int progressBarWidth = getWidth() - 20; // Width of the progress bar
        int progressBarHeight = 20; // Height of the progress bar
        // Calculate the width of filled cells in the progress bar
        int filledCellsWidth = (int) ((double) currentProgress / goal * progressBarWidth);
        // Draw the background of the progress bar
        g.setColor(Color.white);
        g.fillRect(10, 10, progressBarWidth, progressBarHeight);
        // Draw the filled part of the progress bar
        g.setColor(Color.decode("#E0D6FF"));
        g.fillRect(10, 10, filledCellsWidth, progressBarHeight);
        // Draw the border of the progress bar
        g.setColor(Color.BLACK);
        g.drawRect(10, 10, progressBarWidth, progressBarHeight);
    }

    // Method to update the progress and repaint the panel
    public void updateProgress(int progress) {
        currentProgress = progress;
        repaint();
    }
}