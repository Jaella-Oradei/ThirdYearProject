// // import org.jfree.chart.ChartFactory;
// // import org.jfree.chart.ChartPanel;
// // import org.jfree.chart.JFreeChart;
// // import org.jfree.data.category.DefaultCategoryDataset;

// import javax.swing.*;
// import java.awt.*;

// public class BarChart extends JFrame {
//     public BarChart(String title) {
//         super(title);

//         // Create dataset
//         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//         for (int i = 0; i < 24; i++) {
//             dataset.addValue(Math.random() * 100, "Category", Integer.toString(i + 1)); // Random data for 24 bars
//         }

//         // Create bar chart
//         JFreeChart chart = ChartFactory.createBarChart(
//                 "Bar Chart Example", // chart title
//                 "X Axis Label", // domain axis label
//                 "Y Axis Label", // range axis label
//                 dataset // data
//         );

//         // Create chart panel
//         ChartPanel chartPanel = new ChartPanel(chart);
//         chartPanel.setPreferredSize(new Dimension(800, 600));
//         setContentPane(chartPanel);
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> {
//             BarChart example = new BarChart("Bar Chart Example");
//             example.setSize(800, 600);
//             example.setLocationRelativeTo(null);
//             example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//             example.setVisible(true);
//         });
//     }
// }