import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.*;
import java.net.*;
import java.awt.*;

public class HealthImplications implements ActionListener {
    JFrame baseFrame = new JFrame("Health Implications");
    JPanel panel = new JPanel(); 

    //JPanel centerJPanel = new JPanel();

    JLabel pcos, adenomyosis, endometriosis, bleedingDisorder ;
    JPanel infoPanel = new JPanel(new GridLayout(1,4));
    JPanel pcosPanel =  new JPanel();
    JPanel endPanel =  new JPanel();
    JPanel bdPanel =  new JPanel();
    JPanel adPanel =  new JPanel();

    JButton returnbtn = new JButton("Return");
    JPanel returnPanel =  new JPanel();
    Font font = returnbtn.getFont();

    
    public HealthImplications(){

        returnbtn.addActionListener(this);
        returnPanel.setBackground(Color.decode("#FDFDAF"));
        returnbtn.setBackground(Color.decode("#FDFD31"));
        returnbtn.setFont(new Font(font.getFontName(), Font.PLAIN, 19));

        pcos = new JLabel("<html><u>PCOS</u></html>");
        linkAttachment(pcos, "https://my.clevelandclinic.org/health/diseases/8316-polycystic-ovary-syndrome-pcos");
        pcos.setFont(new Font(font.getFontName(), Font.PLAIN, 19));
        borderCreation(pcos);
        pcos.setPreferredSize(new Dimension(100,300));
        pcosPanel.add(pcos);
        pcosPanel.setBackground(Color.decode("#FDFD31"));

        adenomyosis = new JLabel("<html><u>ADENO- MYOSIS</u></html>");
        linkAttachment(adenomyosis, "https://my.clevelandclinic.org/health/diseases/14167-adenomyosis");
        adenomyosis.setFont(new Font(font.getFontName(), Font.PLAIN, 19));
        borderCreation(adenomyosis);
        adenomyosis.setPreferredSize(new Dimension(100,300));
        adenomyosis.setHorizontalAlignment(SwingConstants.LEFT);
        adPanel.add(adenomyosis);
        adPanel.setBackground(Color.decode("#FDFD31"));

        endometriosis = new JLabel("<html><u>ENDOME- TRIOSIS</u></html>");
        linkAttachment(endometriosis, "https://my.clevelandclinic.org/health/diseases/10857-endometriosis");
        endometriosis.setFont(new Font(font.getFontName(), Font.PLAIN, 19));
        borderCreation(endometriosis);
        endometriosis.setPreferredSize(new Dimension(100,300));
        endometriosis.setHorizontalAlignment(SwingConstants.LEFT);
        endPanel.add(endometriosis);
        endPanel.setBackground(Color.decode("#FDFDAF"));


        bleedingDisorder = new JLabel("<html><u>BLEE- DING DISO- RDER</u></html>");
        linkAttachment(bleedingDisorder, "https://www.healthline.com/health/bleeding-disorders");
        bleedingDisorder.setFont(new Font(font.getFontName(), Font.PLAIN, 19));
        borderCreation(bleedingDisorder);
        bleedingDisorder.setPreferredSize(new Dimension(100,300));
        bdPanel.add(bleedingDisorder);
        bdPanel.setBackground(Color.decode("#FDFDAF"));
    
        infoPanel.add(adPanel);
        infoPanel.add(bdPanel);
        infoPanel.add(endPanel);
        infoPanel.add(pcosPanel);

        JScrollPane scrollpane = new JScrollPane(infoPanel);
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        returnPanel.add(returnbtn);
        panel.add(scrollpane);
        panel.add(Box.createHorizontalGlue());
        panel.add(returnPanel);
        panel.add(Box.createHorizontalGlue());

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
    }

    public void linkAttachment(JLabel label, String url){
        label.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() > 0) {
                    // Open the link in the default browser
                    if (java.awt.Desktop.isDesktopSupported()) {
                        try {
                            java.awt.Desktop.getDesktop().browse(new java.net.URI(url));
                        } catch (java.io.IOException | java.net.URISyntaxException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                }
            }
        });
    }

    public void borderCreation(JLabel label){
        Border compoundBorder = BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.BLACK), // Outer line border
            BorderFactory.createEmptyBorder(5, 10, 5, 10) // Inner empty border for padding
        );
        label.setBorder(compoundBorder);

    }
    
}