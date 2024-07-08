// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.*;
// import java.time.LocalDate;
// import java.time.format.DateTimeFormatter;

// public class DateChange {
//     private LocalDate currentDate;

//     public DateChange() {
//         // Initialize the current date to today's date
//         currentDate = LocalDate.now();
        
//         // Create the JFrame
//         JFrame frame = new JFrame("Date Change Example");
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//         // Create the JLabel to display the current date
//         JLabel dateLabel = new JLabel(currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), SwingConstants.CENTER);
//         dateLabel.setFont(new Font("Arial", Font.PLAIN, 20));
//         frame.add(dateLabel, BorderLayout.CENTER);

//         // Create the JPanel for the buttons
//         JPanel buttonPanel = new JPanel(new GridLayout(1, 2));

//         // Create the previous day button
//         JButton prevDayButton = new JButton("Previous Day");
//         prevDayButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 currentDate = currentDate.minusDays(1);
//                 dateLabel.setText(currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//             }
//         });
//         buttonPanel.add(prevDayButton);

//         // Create the next day button
//         JButton nextDayButton = new JButton("Next Day");
//         nextDayButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 currentDate = currentDate.plusDays(1);
//                 dateLabel.setText(currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//             }
//         });
//         buttonPanel.add(nextDayButton);

//         frame.add(buttonPanel, BorderLayout.SOUTH);

//         frame.pack();
//         frame.setVisible(true);
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(new Runnable() {
//             @Override
//             public void run() {
//                 new DateChange();
//             }
//         });
//     }
// }

