
import javax.swing.*;
import javax.swing.border.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CalorieIntake implements ActionListener{
    JFrame baseFrame = new JFrame("Calorie Intake");
    JPanel panel = new JPanel(new GridLayout(4,1));
    JButton returnbtn = new JButton("Return");

    JPanel datePanel = new JPanel(new GridLayout(1, 3));
    private LocalDate date = LocalDate.now();
    JLabel dateLabel = new JLabel(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), SwingConstants.CENTER);
    JButton yesterdayBTN = new JButton("<");
    JButton tomorrowBTN = new JButton(">");

    JPanel caloriePanel = new JPanel(new GridLayout(2,4));//2,4);
    JLabel[] caloriesLabels = new JLabel[8];

    JPanel mealPanel = new JPanel(new GridLayout(1,4));
    JLabel[] mealLabels = new JLabel[4];
    String[] mealSections = {"Breakfast:", "Lunch:", "Dinner:", "Snack:"};

    JPanel optionPanel = new JPanel(new GridLayout(1,2));
    JButton[] optionButtons = new JButton[2];
    String[] optionNames = {"Calculate budget","Calorie budget"};

    JPanel returnPanel = new JPanel(new BorderLayout());
    Font font = yesterdayBTN.getFont();


    //Border topBottomBorder = new BorderFactory.createMatteBorder(1,0,1,0, Color.BLACK);

    public CalorieIntake(){

        yesterdayBTN.setFont(new Font(font.getFontName(), Font.PLAIN, 19));
        tomorrowBTN.setFont(new Font(font.getFontName(), Font.PLAIN, 19));
        dateLabel.setFont(new Font(font.getFontName(), Font.PLAIN, 19));
        returnbtn.setFont(new Font(font.getFontName(), Font.PLAIN, 19));
        returnPanel.setPreferredSize(new Dimension(450, 90));
        yesterdayBTN.addActionListener(this);
        tomorrowBTN.addActionListener(this);
      //  optionButtons[1].addActionListener(this);
        yesterdayBTN.setBackground(Color.decode("#FDFDAF"));//lighter hex
        tomorrowBTN.setBackground(Color.decode("#FDFDAF"));
        datePanel.setBackground(Color.decode("#FFFFFF"));//white 
        optionPanel.setBackground(Color.decode("#FFFFFF"));
        mealPanel.setBackground(Color.decode("#FFFFFF"));
        caloriePanel.setBackground(Color.decode("#FFFFFF"));
        returnbtn.setBackground(Color.decode("#FDFDAF"));
    
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        datePanel.add(yesterdayBTN);
        datePanel.add(dateLabel);
        datePanel.add(tomorrowBTN);

       // Budget b = new Budget() ;
        String[] caloriesTitle = {"Budget -","Food +","Exercise =","New Budget", "1,500","1,468","353","1,853"};
        panel.add(datePanel);
        for (int x = 0; x<caloriesLabels.length; x++){
            caloriesLabels[x] = new JLabel(caloriesTitle[x]);
            caloriesLabels[x].setBorder(new MatteBorder(1,0,1,0, Color.BLACK));
            caloriesLabels[x].setBackground(Color.decode("#FFFFFF"));
            caloriePanel.add(caloriesLabels[x]);
            caloriesLabels[x].setFont(new Font(font.getFontName(), Font.PLAIN, 19));

        }
        panel.add(caloriePanel);
        

        for (int x = 0; x<mealLabels.length; x++){
            mealLabels[x] = new JLabel(mealSections[x]);
            mealLabels[x].setBorder(new MatteBorder(1,0,1,0, Color.BLACK));
            mealLabels[x].setBackground(Color.decode("#FFFFFF"));
            mealPanel.add(mealLabels[x]);
            mealLabels[x].setFont(new Font(font.getFontName(), Font.PLAIN, 19));

        }
        panel.add(mealPanel);

        for (int x = 0; x<optionButtons.length; x++){
            optionButtons[x] = new JButton(optionNames[x]);
            optionButtons[x].setBackground(Color.decode("#FDFD31"));//darker yellow hex
            optionButtons[x].addActionListener(this);
            optionPanel.add(optionButtons[x]);
            optionButtons[x].setFont(new Font(font.getFontName(), Font.PLAIN, 19));

        }
        returnPanel.add(optionPanel);


        returnbtn.addActionListener(this);
        returnPanel.add(returnbtn, BorderLayout.SOUTH);
        panel.add(returnPanel);

        baseFrame.setSize(450,324);
        baseFrame.add(panel);
        baseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        baseFrame.setResizable(false);
        baseFrame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(returnbtn)){
            WomenWindow wowindow = new WomenWindow();
            baseFrame.dispose();
        }
        else if(e.getSource().equals(yesterdayBTN)){
            date = date.minusDays(1);
            dateLabel.setText(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }
        else if(e.getSource().equals(tomorrowBTN)){
            date = date.plusDays(1);
                dateLabel.setText(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }else if(e.getSource().equals(optionButtons[0])){
            if (java.awt.Desktop.isDesktopSupported()) {
                try {
                    java.awt.Desktop.getDesktop().browse(new java.net.URI("https://tdeecalculator.net/"));
                } catch (java.io.IOException | java.net.URISyntaxException ex) {
                    System.out.println(ex.getMessage());
                }
            }

        }else if(e.getSource().equals(optionButtons[1])){
           Budget budget = new Budget();
           baseFrame.dispose();

        }
    }

    public JPanel createPanel(int height){
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(450, height));
        return panel;
    }
}