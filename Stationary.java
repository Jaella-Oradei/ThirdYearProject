
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Stationary implements ActionListener {
    JFrame baseFrame = new JFrame("Stationary");
    JPanel panel = new JPanel(new GridLayout(4,1));
    JButton returnbtn = new JButton("Return");


    JPanel standingPanel = new JPanel();
    JLabel standLabel = new JLabel("Standing Label");

    JPanel sleepPanel = new JPanel();
    JLabel sleepLabel = new JLabel("Sleep");

    JPanel heartpanel = new JPanel();
    JLabel heartLabel = new JLabel("Heart Rate: ");

    int heartCounter = 0;

    public Stationary(){

        standLabel.setHorizontalAlignment(SwingConstants.CENTER);
        standLabel.setVerticalAlignment(SwingConstants.CENTER);
        standingPanel.add(standLabel);

        sleepLabel.setHorizontalAlignment(SwingConstants.CENTER);
        sleepLabel.setVerticalAlignment(SwingConstants.CENTER);
        sleepPanel.add(sleepLabel);

        heartLabel.setHorizontalAlignment(SwingConstants.CENTER);
        heartLabel.setVerticalAlignment(SwingConstants.CENTER);
        heartpanel.add(heartLabel);



        returnbtn.addActionListener(this);
        panel.add(standingPanel);
        panel.add(sleepLabel);
        panel.add(heartLabel);
        panel.add(returnbtn);
        baseFrame.setSize(450,324);
        baseFrame.add(panel);
        baseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        baseFrame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(returnbtn)){
            WomenWindow wowindow = new WomenWindow();
            baseFrame.dispose();
            //baseFrame.setVisible(false);
        }
    }

    
}
