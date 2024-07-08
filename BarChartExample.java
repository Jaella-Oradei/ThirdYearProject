import javax.swing.*;
import java.awt.*;
//edit whole code 
public class BarChartExample extends JFrame {
    
    private int[] data; // Data for the bar chart
    private String[] labels;

    public BarChartExample() {
        setTitle("Bar Chart Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Sample data (you can replace this with your own data)
        data = new int[24];
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 100); // Random data for demonstration
        }
        labels =  new String[data.length];
        for(int x = 0; x< data.length; x++){
            labels[x] = String.valueOf(x+1);
        }
        
        BarChartPanel barChartPanel = new BarChartPanel(data, labels);
        add(barChartPanel);
        
        pack();
        setVisible(true);
    }

    // JPanel subclass for drawing the bar chart
    class BarChartPanel extends JPanel {

        private int[] data; // Data for the bar chart
        private String[] labels ;

        public BarChartPanel(int[] data, String[] labels) {
            this.data = data;
            this.labels = labels;
            setPreferredSize(new Dimension(800, 400)); // Set preferred size
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            // Calculate bar width and gap between bars
            int barWidth = getWidth() / (data.length * 2); /// data.length;
            int gap = barWidth / 2;

            // Find maximum value in data for scaling
            int max = 0;
            for (int value : data) {
                if (value > max) {
                    max = value;
                }
            }

            // Draw bars
            for (int i = 0; i < data.length; i++) {
                int barHeight = (int) ((double) data[i] / max * getHeight()); // Scale the bar height
                int x = i *(barWidth * 2) + gap;
                //int x = i * barWidth + gap;
                int y = getHeight() - barHeight;
                g.setColor(Color.blue);
                g.fillRect(x, y, barWidth, barHeight);
                //g.fillRect(x, y, barWidth - gap, barHeight);

                g.setColor(Color.red);
                g.drawRect(x, getHeight(), barWidth, 20); 

                g.setColor(Color.black);
                int labelX = x + barWidth / 2 - g.getFontMetrics().stringWidth(labels[i]) / 2; // Center the label under the bar
                int labelY = getHeight() + 15;
                g.drawString(labels[i], labelX, labelY); // Draw label below each bar
                
                // Debug output to verify label positions
                //System.out.println("Label " + labels[i] + " drawn at (" + labelX + ", " + labelY + ")");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BarChartExample();
        });
    }
}