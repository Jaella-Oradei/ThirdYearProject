
import javax.swing.*;
import javax.swing.border.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CalorieIntakeMen implements ActionListener{
    JFrame baseFrame = new JFrame("Calorie Intake");
    JPanel panel = new JPanel(new GridLayout(4,1));
    JButton returnbtn = new JButton("Return");

    JPanel datePanel = new JPanel(new GridLayout(1, 3));
    private LocalDate date = LocalDate.now();
    JLabel dateLabel = new JLabel(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), SwingConstants.CENTER);
    JButton yesterdayBTN = new JButton("<");
    JButton tomorrowBTN = new JButton(">");

    //String budget, exercise, food, target;

    JPanel caloriePanel = new JPanel(new GridLayout(2,4));//2,4);
    JLabel[] caloriesLabels = new JLabel[8];
    String[] caloriesTitle = {"Target -","Food +","Exercise =","Budget","1,500","700","250","1750"};

    JPanel mealPanel = new JPanel(new GridLayout(1,4));
    JLabel[] mealLabels = new JLabel[4];
    String[] mealSections = {"Breakfast:", "Lunch:", "Dinner:", "Snack:"};

    JPanel optionPanel = new JPanel(new GridLayout(1,2));
    JButton[] optionButtons = new JButton[2];
    String[] optionNames = {"Calculate budget","Calorie budget"};

    JPanel returnPanel = new JPanel(new BorderLayout());
    Font font = yesterdayBTN.getFont();


    public CalorieIntakeMen(){
        yesterdayBTN.setFont(new Font(font.getFontName(), Font.PLAIN, 19));
        tomorrowBTN.setFont(new Font(font.getFontName(), Font.PLAIN, 19));
        dateLabel.setFont(new Font(font.getFontName(), Font.PLAIN, 19));
        returnbtn.setFont(new Font(font.getFontName(), Font.PLAIN, 19));
 
        returnPanel.setPreferredSize(new Dimension(450, 90));
        yesterdayBTN.addActionListener(this);
        tomorrowBTN.addActionListener(this);
        yesterdayBTN.setBackground(Color.decode("#C9D5FD"));
        tomorrowBTN.setBackground(Color.decode("#C9D5FD"));
        datePanel.setBackground(Color.decode("#FFFFFF"));
        optionPanel.setBackground(Color.decode("#FFFFFF"));
        mealPanel.setBackground(Color.decode("#FFFFFF"));
        caloriePanel.setBackground(Color.decode("#FFFFFF"));
        returnbtn.setBackground(Color.decode("#C9D5FD"));
    
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        datePanel.add(yesterdayBTN);
        datePanel.add(dateLabel);
        datePanel.add(tomorrowBTN);

        panel.add(datePanel);
        for (int x = 0; x<caloriesLabels.length; x++){
            caloriesLabels[x] = new JLabel(caloriesTitle[x]);
            caloriesLabels[x].setBorder(new MatteBorder(1,0,1,0, Color.BLACK));
            caloriesLabels[x].setBackground(Color.decode("#FFFFFF"));
            caloriesLabels[x].setFont(new Font(font.getFontName(), Font.PLAIN, 19));


            //periodPhases[x].addActionListener(this);
            caloriePanel.add(caloriesLabels[x]);
        }
        panel.add(caloriePanel);
        

        for (int x = 0; x<mealLabels.length; x++){
            mealLabels[x] = new JLabel(mealSections[x]);
            mealLabels[x].setBorder(new MatteBorder(1,0,1,0, Color.BLACK));
            mealLabels[x].setBackground(Color.decode("#FFFFFF"));
            mealLabels[x].setFont(new Font(font.getFontName(), Font.PLAIN, 19));


            //periodPhases[x].addActionListener(this);
            mealPanel.add(mealLabels[x]);
        }
        panel.add(mealPanel);


        for (int x = 0; x<optionButtons.length; x++){
            optionButtons[x] = new JButton(optionNames[x]);
            optionButtons[x].setBackground(Color.decode("#5061C5"));
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
            MenWindow menWindow = new MenWindow();
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
            //System.out.println("SMALL WINDOW HERE");
            if (java.awt.Desktop.isDesktopSupported()) {
                try {
                    java.awt.Desktop.getDesktop().browse(new java.net.URI("https://tdeecalculator.net/"));
                } catch (java.io.IOException | java.net.URISyntaxException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            //linkAttachment(optionButtons[0], "https://my.clevelandclinic.org/health/diseases/15603-low-testosterone-male-hypogonadism");
        }else if(e.getSource().equals(optionButtons[1])){
            BudgetMEN budget = new BudgetMEN();
            baseFrame.dispose();
 
        }
    }
    public JPanel createPanel(int height){
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(450, height));
        return panel;
    }
}