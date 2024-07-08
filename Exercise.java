
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Exercise implements ActionListener {
    JFrame baseFrame = new JFrame("Exercise");
    JPanel underPanel = new JPanel(new GridLayout(2,1));
    JPanel panel = new JPanel(new GridLayout(2,2));
    JPanel cPanel = new JPanel();
    JButton returnbtn = new JButton("Return");

    JPanel cardioPanel = new JPanel(new BorderLayout());
    JButton cardioBtn = new JButton("CARDIO");

    JPanel strengthPanel =  new JPanel(new BorderLayout());
    JButton StrengthBtn = new JButton("STRENGTH");


    JPanel flexiblePanel = new JPanel(new BorderLayout());
    JButton flexibleBtn = new JButton("FLEXIBILITY");

    JPanel functionalPanel = new JPanel(new BorderLayout());
    JButton functionalBtn = new JButton("FUNCTIONAL");
    JPanel rJPanel = new JPanel();

    Font font = cardioBtn.getFont();


    public Exercise(){
        returnbtn.addActionListener(this);
        cardioBtn.setIcon(loadPicture("pictures/001.png"));
        StrengthBtn.setIcon(loadPicture("pictures/002.png"));
        flexibleBtn.setIcon(loadPicture("pictures/003.png"));
        functionalBtn.setIcon(loadPicture("pictures/004.png"));
        returnbtn.setFont(new Font(font.getFontName(), Font.PLAIN, 19));
        cardioBtn.setFont(new Font(font.getFontName(), Font.PLAIN, 19));
        StrengthBtn.setFont(new Font(font.getFontName(), Font.PLAIN, 19));
        flexibleBtn.setFont(new Font(font.getFontName(), Font.PLAIN, 19));
        functionalBtn.setFont(new Font(font.getFontName(), Font.PLAIN, 19));

        cardioBtn.addActionListener(this);
        StrengthBtn.addActionListener(this);
        flexibleBtn.addActionListener(this);
        functionalBtn.addActionListener(this);
       
        cardioPanel.add(cardioBtn);
        strengthPanel.add(StrengthBtn);
        flexiblePanel.add(flexibleBtn);
        functionalPanel.add(functionalBtn);

        cPanel.setBackground(Color.decode("#E0D6FF"));
        rJPanel.setBackground(Color.decode("#E0D6FF"));
        underPanel.setBackground(Color.decode("#E0D6FF"));

        
        returnbtn.setBackground(Color.decode("#FFB3C6"));

        cardioBtn.setBackground(Color.decode("#FFE5EC"));
        StrengthBtn.setBackground(Color.decode("#FFE5EC"));
        flexibleBtn.setBackground(Color.decode("#FFE5EC"));
        functionalBtn.setBackground(Color.decode("#FFE5EC"));

        rJPanel.add(returnbtn, BorderLayout.CENTER);
        panel.add(cardioPanel);
        panel.add(strengthPanel);
        panel.add(flexiblePanel);
        panel.add(functionalPanel);
        underPanel.add(panel);
        underPanel.add(rJPanel);
        cPanel.add(underPanel, BorderLayout.CENTER);
        baseFrame.setSize(450,324);
        baseFrame.add(cPanel, BorderLayout.CENTER);
        baseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        baseFrame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(returnbtn)){
            baseFrame.dispose();
            WomenWindow wowindow = new WomenWindow();
        }else if(e.getSource().equals(cardioBtn)){
            baseFrame.dispose();
            Cardio cardio = new Cardio();
        }else if(e.getSource().equals(StrengthBtn)){
            baseFrame.dispose();
            Strength st = new Strength();
        }else if(e.getSource().equals(flexibleBtn)){
            baseFrame.dispose();
            Flexibility fl = new Flexibility();
        }else if(e.getSource().equals(functionalBtn)){
            baseFrame.dispose();
           Functional functional = new Functional();
        }
    }

    private ImageIcon loadPicture(String filePath) {
        ImageIcon icon = new ImageIcon(filePath);
        Image image = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

    
}
