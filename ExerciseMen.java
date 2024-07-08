
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExerciseMen implements ActionListener {
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

    public ExerciseMen(){
  
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

        returnbtn.addActionListener(this);
        cardioBtn.addActionListener(this);
        StrengthBtn.addActionListener(this);
        flexibleBtn.addActionListener(this);
        functionalBtn.addActionListener(this);
       
       
        cardioPanel.add(cardioBtn);
        strengthPanel.add(StrengthBtn);
        flexiblePanel.add(flexibleBtn);
        functionalPanel.add(functionalBtn);

        cPanel.setBackground(Color.decode("#C4DEA4"));
        rJPanel.setBackground(Color.decode("#C4DEA4"));
        underPanel.setBackground(Color.decode("#C4DEA4"));

        
        returnbtn.setBackground(Color.decode("#CAAD7E"));

        cardioBtn.setBackground(Color.decode("#B6D82"));
        StrengthBtn.setBackground(Color.decode("#B6D82"));
        flexibleBtn.setBackground(Color.decode("#B6D82"));
        functionalBtn.setBackground(Color.decode("#B6D82"));


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
            
            MenWindow menWindow = new MenWindow();
            baseFrame.dispose();
        }
        else if(e.getSource().equals(cardioBtn)){
            baseFrame.dispose();
            CardioMEN cardio = new CardioMEN();
        }
        else if(e.getSource().equals(StrengthBtn)){
            baseFrame.dispose();
            StrengthMEN st = new StrengthMEN();
        }
        else if(e.getSource().equals(flexibleBtn)){
            baseFrame.dispose();
            FlexibilityMEN fl = new FlexibilityMEN();
        }
        else if(e.getSource().equals(functionalBtn)){
            baseFrame.dispose();
           FunctionalMEN functional = new FunctionalMEN();
        }
    }

    private ImageIcon loadPicture(String filePath) {
        ImageIcon icon = new ImageIcon(filePath);
        Image image = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }
}