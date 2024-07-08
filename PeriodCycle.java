import javax.swing.*;
import javax.swing.plaf.basic.BasicTableHeaderUI.MouseInputHandler;

import org.w3c.dom.events.MouseEvent;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;


public class PeriodCycle implements ActionListener {
    JFrame baseFrame = new JFrame("Period Cycle");
    //String title = new String("Period Cycle");

    JPanel basePanel = new JPanel();
    JPanel centerJPanel = new JPanel(new GridLayout(2,1));
    
    JLabel infoTitle = new JLabel("More Information");
    JPanel infobasePanel = new JPanel(new GridLayout(2,1));
    JPanel infoPanel = new JPanel(new GridLayout(2,1));
    JButton trackingCal = new JButton("Track Period");


    JButton[] periodPhases =  new JButton[4];
    String[] phasesTitle = {"Follicular Phase", "Ovulation", "Luteal Phase", "Menstrual Phase"};

    JPanel returnPanel = new JPanel(new GridLayout(1, 2));
    JButton returnbtn = new JButton("Return");
    public PeriodCycle(){
        //baseFrame.setTitle(title);

        Font font = infoTitle.getFont();
        returnbtn.setFont(new Font(font.getFontName(), Font.PLAIN, 19));
        trackingCal.setFont(new Font(font.getFontName(), Font.PLAIN, 19));
        //decreaseButton.setFont(new Font(font.getFontName(), Font.PLAIN, 30));


        returnbtn.setBackground(Color.decode("#8E6EEF"));
        trackingCal.setBackground(Color.decode("#8E6EEF"));
        basePanel.setBackground(Color.decode("#E0D6FF"));
        infoPanel.setBackground(Color.decode("#E0D6FF"));
        infobasePanel.setBackground(Color.decode("#E0D6FF"));

        trackingCal.addActionListener(this);

        
        infoTitle.setHorizontalAlignment(SwingConstants.CENTER);
        infoTitle.setVerticalAlignment(SwingConstants.CENTER);
        infoTitle.setFont(new Font(font.getFontName(), Font.PLAIN, 19));

        infobasePanel.add(infoTitle);

        for (int y = 0; y<periodPhases.length; y++){
            periodPhases[y] = new JButton(phasesTitle[y]);
            periodPhases[y].setFont(new Font(font.getFontName(), Font.PLAIN, 19));
            periodPhases[y].addActionListener(this);
            infoPanel.add(periodPhases[y]);
        }
        infobasePanel.add(infoPanel);

        periodPhases[0].setBackground(Color.decode("#FFE5EC"));
        periodPhases[1].setBackground(Color.decode("#FFB3C6"));
        periodPhases[2].setBackground(Color.decode("#FFE5EC"));
        periodPhases[3].setBackground(Color.RED);
  
        returnbtn.addActionListener(this);
        returnPanel.add(trackingCal);
        returnPanel.add(returnbtn);

        centerJPanel.add(infobasePanel);
        centerJPanel.add(returnPanel);

        basePanel.add(centerJPanel);
        baseFrame.setSize(450,324);
        baseFrame.add(basePanel);
        baseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        baseFrame.setVisible(true);

    }

    public void linkAttachment(String url){
        if (java.awt.Desktop.isDesktopSupported()) {
            try {
                java.awt.Desktop.getDesktop().browse(new java.net.URI(url));
            } catch (java.io.IOException | java.net.URISyntaxException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(returnbtn)){
            WomenWindow wowindow = new WomenWindow();
            baseFrame.dispose();
        }else if(e.getSource().equals(periodPhases[0])){
            linkAttachment("https://my.clevelandclinic.org/health/body/23953-follicular-phase");
        }else if(e.getSource().equals(periodPhases[1])){
            linkAttachment("https://my.clevelandclinic.org/health/articles/23439-ovulation");
        }else if(e.getSource().equals(periodPhases[2])){
            linkAttachment("https://my.clevelandclinic.org/health/articles/24417-luteal-phase");
        }else if(e.getSource().equals(periodPhases[3])){
            linkAttachment("https://my.clevelandclinic.org/health/articles/10132-menstrual-cycle");
        }else if(e.getSource().equals(trackingCal)){
            new CalendarApp();
            baseFrame.dispose();
        }
    }

    

    
}
