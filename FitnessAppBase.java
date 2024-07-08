import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FitnessAppBase implements ActionListener {
    JFrame baseFrame = new JFrame("FitnessApp");
    JPanel basePanel = new JPanel();
   // });
    JPanel btnPanel = new JPanel(new GridLayout(2, 1));
    JLabel choice = new JLabel("Please select Gender");

    JButton manBTN = new JButton();
    JButton womanBTN =  new JButton();
    Font font = manBTN.getFont();

    
    public FitnessAppBase(){

        manBTN.setIcon(loadPicture("pictures/male.png"));
        womanBTN.setIcon(loadPicture("pictures/Female.png"));

        basePanel.setBackground(Color.decode("#ffffff"));

        manBTN.setFont(new Font(font.getFontName(), Font.PLAIN, 19));
        womanBTN.setFont(new Font(font.getFontName(), Font.PLAIN, 19));
        choice.setFont(new Font(font.getFontName(), Font.PLAIN, 19));


        btnPanel.setBackground(Color.decode("#5061c5"));
        manBTN.setBackground(Color.decode("#C9D5FD"));
        womanBTN.setBackground(Color.decode("#ECCEE2"));



        manBTN.addActionListener(this);
        womanBTN.addActionListener(this);

        btnPanel.add(manBTN);
        btnPanel.add(womanBTN);

        basePanel.setSize(394,324);
        baseFrame.setSize(394,324);
        //basePanel.add(choice, BorderLayout.CENTER);
        basePanel.add(btnPanel, BorderLayout.CENTER);

        baseFrame.add(basePanel, BorderLayout.CENTER);
        baseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        baseFrame.setResizable(false);
        baseFrame.setLocationRelativeTo(null); 
        baseFrame.setVisible(true);
        
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(manBTN)){
            MenWindow mw =  new MenWindow();
            baseFrame.dispose();
        }else if(e.getSource().equals(womanBTN)){
            WomenWindow ww = new WomenWindow();
            baseFrame.dispose();
        }
    }


    private ImageIcon loadPicture(String filePath) {
        ImageIcon icon = new ImageIcon(filePath);
        Image image = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }
}
