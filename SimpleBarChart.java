import javax.swing.*;
import java.awt.*;

public class SimpleBarChart extends JPanel {
    private final int[] data;

    public SimpleBarChart(int[] data) {
        this.data = data;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Determine the maximum value in the data
        int maxValue = 0;
        for (int value : data) {
            if (value > maxValue) {
                maxValue = value;
            }
        }

        int width = getWidth();
        int height = getHeight();
        int barWidth = width / data.length;

        // Draw bars
        for (int i = 0; i < data.length; i++) {
            int x = i * barWidth;
            int barHeight = (int) ((double) data[i] / maxValue * height);
            int y = height - barHeight;
            g.setColor(Color.BLUE);
            g.fillRect(x, y, barWidth, barHeight);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, barWidth, barHeight);
        }

        // Draw x-axis and labels
        g.setColor(Color.BLACK);
        g.drawLine(0, height, width, height);
        for (int i = 0; i < data.length; i++) {
            int x = i * barWidth + barWidth / 2;
            g.drawString(Integer.toString(i + 1), x, height + 15);
        }

        // Draw y-axis and labels
        g.drawLine(0, 0, 0, height);
        for (int i = 0; i <= 10; i++) {
            int y = height - i * height / 10;
            g.drawString(Integer.toString(i * maxValue / 10), -30, y);
        }
    }

    public static void main(String[] args) {
        int[] data = {20, 30, 40, 50, 60, 70, 80, 90, 80, 70, 60, 50, 40, 30, 20, 10, 20, 30, 40, 50, 60, 70, 80, 90};
        SimpleBarChart barChart = new SimpleBarChart(data);
        JFrame frame = new JFrame("Simple Bar Chart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(barChart);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}