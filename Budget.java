import javax.swing.*;
import javax.swing.border.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Budget implements ActionListener{

    JFrame baseFrame = new JFrame("CALORIE BUDGET");
    JPanel panel = new JPanel(new GridLayout(2,1));

    JButton returnbtn= new JButton("Return");
    JButton confirmBtn = new JButton("OK");

    JButton increaseButton = new JButton("▲");
    JButton decreaseButton = new JButton("▼");
    JPanel buttonSettingPanel = new JPanel(new GridLayout(2,1));

    JPanel centerPanel = new JPanel(new GridLayout(2,1));
    JPanel caloriePanel = new JPanel(new GridLayout(1,2));

    JLabel calorieLabel = new JLabel("2000");
    int calorieCOunter = 2000;
    File calorieFile = new File("calorie.txt");

    String stringCounter;

    JPanel rPanel = new JPanel();

    
    public Budget(){
        returnbtn.addActionListener(this);
        confirmBtn.addActionListener(this);
        increaseButton.addActionListener(this);
        decreaseButton.addActionListener(this);

        rPanel.setBackground(Color.decode("#E0D6FF"));
        caloriePanel.setBackground(Color.decode("#E0D6FF"));

        increaseButton.setBackground(Color.decode("#8E6EEF"));
        decreaseButton.setBackground(Color.decode("#8E6EEF"));

        returnbtn.setBackground(Color.decode("#8E6EEF"));
        confirmBtn.setBackground(Color.decode("#77DD77"));


        if (calorieFile.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(calorieFile))) {
                calorieCOunter = Integer.parseInt(reader.readLine());
            } catch (Exception e) {
                e.printStackTrace();
            }
  
        }else {
            calorieCOunter = 2000;
        }
        calorieLabel = new JLabel(String.valueOf(calorieCOunter));
        Font calorieFont = calorieLabel.getFont();
        calorieLabel.setFont(new Font(calorieFont.getFontName(), Font.PLAIN, 50));
        returnbtn.setFont(new Font(calorieFont.getFontName(), Font.PLAIN, 30));
        confirmBtn.setFont(new Font(calorieFont.getFontName(), Font.PLAIN, 30));
        increaseButton.setFont(new Font(calorieFont.getFontName(), Font.PLAIN, 30));
        decreaseButton.setFont(new Font(calorieFont.getFontName(), Font.PLAIN, 30));
        

        centerPanel.add(caloriePanel);
        centerPanel.add(confirmBtn);

        buttonSettingPanel.add(increaseButton);
        buttonSettingPanel.add(decreaseButton);

        caloriePanel.add(calorieLabel, BorderLayout.EAST);
        caloriePanel.add(buttonSettingPanel);

        panel.add(centerPanel);
        rPanel.add(returnbtn, BorderLayout.EAST);
        panel.add(rPanel);

        baseFrame.setSize(450,324);
        baseFrame.add(panel);
        baseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        baseFrame.setResizable(false);
        baseFrame.setVisible(true);
        
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(returnbtn)){
           CalorieIntake ci = new CalorieIntake();
            baseFrame.dispose();
        } else if(e.getSource().equals(increaseButton)){
            //calorieIncrease(10);
            calorieCOunter = calorieCOunter+10;
            stringCounter = String.valueOf(calorieCOunter);
            calorieLabel.setText(stringCounter);
           // getCalorie();
        }
        else if(e.getSource().equals(decreaseButton)){
           // calorieDecrease(10);
           if (calorieCOunter >= 10) {
            calorieCOunter -=10;
            calorieLabel.setText(String.valueOf(calorieCOunter));
           }
            
        }else if(e.getSource().equals(confirmBtn)){
           // System.out.println("saved");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(calorieFile))) {
            stringCounter = String.valueOf(calorieCOunter);
                writer.write(stringCounter);
                JOptionPane.showMessageDialog(baseFrame, "Your new caloric budget is now: " + stringCounter);
            } catch (Exception ed) {
                // TODO: handle exception
                ed.printStackTrace();
            }
        }
    }


}
