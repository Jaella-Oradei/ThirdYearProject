import javax.swing.*;
import java.awt.*;

public class BarChartPanel extends JPanel {
    private static final int BAR_WIDTH = 10; // Width of each bar
    private static final int SPACING = 5; // Spacing between bars
    private static final int CHART_HEIGHT = 300; // Height of the chart area
    private static final int CHART_WIDTH = 600; // Width of the chart area
    private static final int AXIS_MARGIN = 20; // Margin for axis labels

    private int[] data; // Array of data values for each bar
    private String[] labels; // Array of labels for each bar

    public BarChartPanel(int[] data, String[] labels) {
        this.data = data;
        this.labels = labels;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Calculate the maximum data value
        int maxDataValue = 0;
        for (int value : data) {
            maxDataValue = Math.max(maxDataValue, value);
        }

        // Calculate the height scale factor
        double scaleFactor = (double) CHART_HEIGHT / maxDataValue;

        // Draw the bars
        int x = AXIS_MARGIN;
        for (int i = 0; i < data.length; i++) {
            int barHeight = (int) (data[i] * scaleFactor);
            int y = CHART_HEIGHT - barHeight;
            g.setColor(Color.blue);
            g.fillRect(x, y, BAR_WIDTH, barHeight);
            g.setColor(Color.black);
            g.drawString(labels[i], x, CHART_HEIGHT + AXIS_MARGIN);
            x += BAR_WIDTH + SPACING;
        }

        // Draw the y-axis labels
        int y = CHART_HEIGHT;
        for (int i = 0; i <= maxDataValue; i += 2000) {
            g.drawString(String.valueOf(i), AXIS_MARGIN - 40, y);
            y -= 2000 * scaleFactor;
        }

        // Draw the x-axis labels
        for (int i = 0; i < labels.length; i++) {
            int labelX = AXIS_MARGIN + i * (BAR_WIDTH + SPACING) + BAR_WIDTH / 2 - g.getFontMetrics().stringWidth(labels[i]) / 2;
            g.drawString(labels[i], labelX, CHART_HEIGHT + AXIS_MARGIN * 2);
        }

        // Draw the x-axis line
        g.drawLine(AXIS_MARGIN, CHART_HEIGHT, AXIS_MARGIN + CHART_WIDTH, CHART_HEIGHT);

        // Draw the y-axis line
        g.drawLine(AXIS_MARGIN, 0, AXIS_MARGIN, CHART_HEIGHT);
    }

    public static void main(String[] args) {
        int[] data = {2000, 4000, 6000, 8000, 10000, 12000, 14000, 16000, 18000, 20000, 22000, 24000,
                26000, 28000, 30000, 32000, 34000, 36000, 38000, 40000, 42000, 44000, 46000};

        String[] labels = {"0", "2", "4", "6", "8", "10", "12", "14", "16", "18", "20", "22", "24"};

        JFrame frame = new JFrame("Bar Chart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.getContentPane().add(new BarChartPanel(data, labels));
        frame.setVisible(true);
    }
}