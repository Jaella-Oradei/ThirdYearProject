import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.*;
import java.time.format.*;
import java.util.*;

public class CalendarApp extends JFrame implements ActionListener {
    //JFrame frame = new JFrame("Calendar");
    JPanel displayPanel = new JPanel(new GridLayout(2,1));
    JButton returButton = new JButton("Return");
    JPanel rPanel = new JPanel();
    private JButton[] dayButtons = new JButton[35]; 
    private JLabel[] dayLabels =  new JLabel[7];
    JPanel daysPanel = new JPanel(new GridLayout(0, 7));
    private JLabel monthYearLabel  = new JLabel("", SwingConstants.CENTER);
    private int currentMonth;
    private int currentYear;
    JPanel calendarPanel = new JPanel(new BorderLayout());
    JPanel titlePanel = new JPanel(new GridLayout(1, 7)); 
    JPanel monthYearPanel = new JPanel(new GridLayout(2,1));
    String[] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    
    private static final String BUTTON_STATE_FILE = "button_states.txt";
    private Map<Integer, Boolean> buttonStates = new HashMap<>();

    public CalendarApp() {
        setTitle("Track Period");
        loadButtonStates();


        monthYearPanel.add(monthYearLabel, BorderLayout.NORTH);
        returButton.addActionListener(this);
        //dayLabels[i].setBackground(Color.decode("#FFFFFF"));
        titlePanel.setBackground(Color.decode("#E0D6FF"));
        rPanel.setBackground(Color.decode("#E0D6FF"));
        calendarPanel.setBackground(Color.decode("#E0D6FF"));
        monthYearPanel.setBackground(Color.decode("#E0D6FF"));
        returButton.setBackground(Color.decode("#8E6EEF"));



        for (int i = 0; i < 7; i++) {
            dayLabels[i] = new JLabel(daysOfWeek[i], SwingConstants.LEFT);
            titlePanel.add(dayLabels[i]);
            dayLabels[i].setBackground(Color.decode("#FFFFFF"));

        }
        monthYearPanel.add(titlePanel ,BorderLayout.SOUTH);

        calendarPanel.add(monthYearPanel, BorderLayout.NORTH);

        // Panel for days
        for (int i = 0; i < dayButtons.length; i++) {
            dayButtons[i] = new JButton("");
            dayButtons[i].setMargin(new Insets(0, 0, 0, 0));
            dayButtons[i].setFocusPainted(false);
            dayButtons[i].setBackground(Color.decode("#FFFFFF"));
            dayButtons[i].addMouseListener(new Clicking());//(new Clicking());
            //dayButtons[i].addActionListener(new DayButtonListener() {
                
           
            daysPanel.add(dayButtons[i]);
            if (buttonStates.containsKey(i) && buttonStates.get(i)) {
                dayButtons[i].setBackground(Color.RED);
            }
        
        }
        calendarPanel.add(daysPanel, BorderLayout.CENTER);

        // Set current month and year
        setCurrentMonthYear(LocalDate.now().getMonthValue(), LocalDate.now().getYear());
        rPanel.add(returButton, BorderLayout.SOUTH);

        // Display the calendar
        updateCalendar();
        displayPanel.add(calendarPanel);
        displayPanel.add(rPanel);
        add(displayPanel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(returButton)){
            PeriodCycle pc = new PeriodCycle();
            dispose();
        }
    }

    private void updateCalendar() {
        // Get the first day of the month
        LocalDate firstDayOfMonth = LocalDate.of(currentYear, currentMonth, 1);
        int startDayOfWeek = firstDayOfMonth.getDayOfWeek().getValue(); // 1-7, Monday-Sunday

        // Set the month and year label
        monthYearLabel.setText(firstDayOfMonth.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH) + " " + currentYear);

        // Clear previous month's days
        for (JButton button : dayButtons) {
            button.setText("");
            button.setEnabled(false);
        }

        // Populate the buttons with the days of the month
        LocalDate date = firstDayOfMonth;
        int dayOfMonth = 1;
        for (int i = startDayOfWeek - 1; i < startDayOfWeek - 1 + date.lengthOfMonth(); i++) {
            dayButtons[i].setText(Integer.toString(dayOfMonth));
            dayButtons[i].setEnabled(true);
            dayOfMonth++;
        }
    }

    private void setCurrentMonthYear(int month, int year) {
        currentMonth = month;
        currentYear = year;
       // return 
    }

    private class DayButtonListener implements ActionListener {
        private Map<JButton, Integer> clickingCount = new HashMap<>();

        public void actionPerformed(ActionEvent e) {
            
            JButton button = (JButton) e.getSource();
            int day = Integer.parseInt(button.getText());
            button.setBackground(Color.RED);
            int clickCount =  clickingCount.getOrDefault(button, 0);
            if(clickCount % 2 == 0){
                button.setBackground(Color.RED);
            } else {
                button.setBackground(Color.WHITE);
            }
            clickCount++;
            clickingCount.put(button, clickCount);

            //JOptionPane.showMessageDialog(CalendarApp.this, "You clicked on day " + day);
        }
    }
    private class Clicking extends MouseAdapter {
        public void mouseClicked(MouseEvent event){
            JButton button = (JButton) event.getSource();
            int index = Arrays.asList(dayButtons).indexOf(button);
            int day = Integer.parseInt(button.getText());
            if (event.getClickCount() == 2) {
                // Toggle button background color
                if (button.getBackground() == Color.RED) {
                    button.setBackground(Color.WHITE);
                    buttonStates.put(index, false);
                } else {
                    button.setBackground(Color.RED);
                    buttonStates.put(index, true);
                }
                // Save button states to file
                saveButtonStates();
            } else if (event.getClickCount() == 3) {
                JOptionPane.showMessageDialog(CalendarApp.this, "You clicked on day " + day);
            }
        }
    }

    private void loadButtonStates() {
        try (BufferedReader reader = new BufferedReader(new FileReader(BUTTON_STATE_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int index = Integer.parseInt(parts[0]);
                boolean state = Boolean.parseBoolean(parts[1]);
                buttonStates.put(index, state);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveButtonStates() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BUTTON_STATE_FILE))) {
            for (Map.Entry<Integer, Boolean> entry : buttonStates.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalendarApp::new);
    }
}