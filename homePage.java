import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


public class homePage implements ActionListener {
JFrame frame = new JFrame();
ImageIcon frameIcon = new ImageIcon("Images/Untitled.png");
JPanel buttonsPanel = new JPanel();
JPanel TPanel = new JPanel();
JLabel label = new JLabel();
JButton[] buttons = new JButton[4];
JLabel userLabel = new JLabel();
JLayeredPane BPanel = new JLayeredPane();
ImageIcon home = new ImageIcon("Images/home.png");
ImageIcon setting = new ImageIcon("Images/settings.png");
ImageIcon notification = new ImageIcon("Images/envelope.png");
ImageIcon profile = new ImageIcon("Images/user.png");

public void buttons(){
  for(int i=0; i<4;i++){
    buttons[i] = new JButton();
    buttonsPanel.add(buttons[i]);
    buttons[i].setFocusable(false);
    buttons[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
    buttons[i].addActionListener(this);
    buttons[i].setHorizontalAlignment(JButton.CENTER);
    buttons[i].setVerticalAlignment(JButton.BOTTOM);
    buttons[i].setBorder(BorderFactory.createRaisedSoftBevelBorder());
  }
  
    buttons[0].setText("Home");
    buttons[0].setIcon(home);
    buttons[1].setText("Notification");
    buttons[1].setIcon(notification);
    buttons[2].setText("Settings");
    buttons[2].setIcon(setting);
    buttons[3].setText("Profile");
    buttons[3].setIcon(profile);
}

homePage(){
// working on the
userLabel.setOpaque(true);
userLabel.setBackground(Color.BLUE);
userLabel.setBounds(200,90,80,80);
    BPanel.setBounds(0,85,500,650);
    BPanel.add(userLabel);
    frame.add(BPanel);

//working on the button panel
buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,4));
buttonsPanel.setPreferredSize(new Dimension(100,30));




buttons();

// working on ht e panel for the company name
TPanel.setLayout(new BorderLayout());
        TPanel.setPreferredSize(new Dimension(500, 80));
        label.setBackground(new Color(25, 25, 255));
        label.setForeground(Color.black);
        label.setFont(new Font("sanserif", Font.BOLD, 35));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setText("Realm Bank");
        label.setOpaque(true);
        TPanel.add(label, BorderLayout.CENTER);
        frame.add(TPanel, BorderLayout.NORTH);

  // initializing and setting the frame features
  frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setSize(500,650);
    frame.getContentPane().setBackground(new Color(0xfafafa));
    frame.setVisible(true);
    frame.setIconImage(frameIcon.getImage());
    frame.setTitle("Realm Bank");
    frame.setResizable(true);
    
frame.add(TPanel, BorderLayout.NORTH);
frame.add(buttonsPanel, BorderLayout.SOUTH);

frame.setLocationRelativeTo(null);

}


  public static void main(String[] args) {
    new homePage();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == buttons[3]) {
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.showOpenDialog(null);
    }
  }
}
