import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class MovementWindow extends JFrame {

    private JPanel hourPanel;

    public MovementWindow() {
        setTitle("Movement Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create panel to display steps for each hour
        hourPanel = new JPanel(new GridLayout(24, 1));

        // Generate random steps data for each hour (for demonstration)
        Random random = new Random();
        for (int hour = 0; hour < 24; hour++) {
            int steps = random.nextInt(10000); // Random steps count
            JLabel hourLabel = new JLabel("Hour " + hour + ": " + steps + " steps");
            hourPanel.add(hourLabel);
        }

        // Add hourPanel to the frame
        add(hourPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MovementWindow::new);
    }
}