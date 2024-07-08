import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BarChartWithoutPaint extends JFrame {

    private ArrayList<String> awards;

    public BarChartWithoutPaint(ArrayList<String> awards) {
        this.awards = awards;

        setTitle("Awards");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create and populate awards panel
        JPanel awardsPanel = new JPanel(new GridLayout(0, 1));
        for (String award : awards) {
            JLabel awardLabel = new JLabel(award);
            awardsPanel.add(awardLabel);
        }

        // Add awards panel to the frame
        add(awardsPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Example usage
        ArrayList<String> userAwards = new ArrayList<>();
        userAwards.add("First Place");
        userAwards.add("Marathon Finisher");
        userAwards.add("10K Badge");
        
        SwingUtilities.invokeLater(() -> new BarChartWithoutPaint(userAwards));
    }
}