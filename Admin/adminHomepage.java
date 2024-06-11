import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import Database.SqlStatements;

public class adminHomepage implements ActionListener{
JFrame frame = new JFrame();
  JPanel TPanel = new JPanel();
  JLabel label = new JLabel();
  JButton[] button = new JButton[8];
  ImageIcon frameIcon = new ImageIcon("Images/Untitled.png");
  SqlStatements st = new SqlStatements();
  JPanel formPanel = new JPanel();
  JPanel buttonPanel = new JPanel();
  JPanel form = new JPanel();
  ImageIcon home = new ImageIcon("Images/home.png");
  ImageIcon profile = new ImageIcon("Images/user.png");
  ImageIcon history = new ImageIcon("Images/time-past.png");
ImageIcon data = new ImageIcon("Images/priority-arrows.png");
public static Color color1;
static JLabel userLabel = new JLabel();
public void buttons(){

  for(int i=0; i<8;i++){
    button[i] = new JButton();
    buttonPanel.add(button[i]);
    button[i].setFocusable(false);
    button[i].setPreferredSize(new Dimension(100,30));
    button[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
    button[i].addActionListener(this);
    button[i].setHorizontalAlignment(JButton.CENTER);
    button[i].setVerticalAlignment(JButton.BOTTOM);
    button[i].setBorder(BorderFactory.createRaisedSoftBevelBorder());
  }
  
    button[0].setText("Home");
    button[0].setIcon(home);
    button[1].setText("Profile");
    button[1].setIcon(profile);
    button[2].setText("Color Theme");
    button[3].setText("Account Managements");
    button[4].setText("View Transactions");
    button[5].setText("View Customer Information");
    button[6].setText("View Employee Information");
    button[7].setText("play game");
}
  public adminHomepage(){
    userLabel.setOpaque(true);
    userLabel.setBackground(Color.lightGray);
    userLabel.setIcon(adminProfile.vel);
    userLabel.setText("set image in profile");
    userLabel.setFont(new Font("Arial", Font.ROMAN_BASELINE,10));
    
    userLabel.setBounds(220,80,90,100);
  // working on ht e panel for the company name
TPanel.setLayout(new BorderLayout());
TPanel.setPreferredSize(new Dimension(500, 80));
label.setBackground(new Color(25, 25, 255));
label.setForeground(Color.black);
label.setFont(new Font("sanserif", Font.BOLD, 35));
label.setHorizontalAlignment(JLabel.CENTER);
label.setText("Realm Bank - Admin");
label.setOpaque(true);
TPanel.add(label, BorderLayout.CENTER);

// working on the buttons
buttonPanel.setBounds(50, 230, 450, 200);
buttonPanel.setBackground(Color.BLUE);
buttonPanel.setLayout(new GridLayout(4, 4, 3, 2));
// working on the form panel
formPanel.setLayout(null);
formPanel.setPreferredSize(new Dimension(500,600));
formPanel.add(buttonPanel);
formPanel.add(userLabel);



// initializing and setting the frame features

frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
frame.setSize(5000,5000);
frame.getContentPane().setBackground(color1);
frame.setVisible(true);
frame.setIconImage(frameIcon.getImage());
frame.setTitle("Realm Bank Admin");
frame.setResizable(true);
frame.setLayout(new BorderLayout());
frame.setLocationRelativeTo(null);

buttonPanel.setBackground(color1);
form.setBackground(color1);
formPanel.setBackground(color1);
form.add(formPanel, BorderLayout.CENTER);
frame.add(form, BorderLayout.CENTER);
frame.add(TPanel, BorderLayout.NORTH);
buttons();
frame.setVisible(true);
  }

  public static void main(String[] args) {
    new adminHomepage();
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == button[1]) {
      frame.dispose();
      new adminProfile();
    }
    if (e.getSource()== button[0]) {
      frame.dispose();
      new adminHomepage();
    }
    if (e.getSource()== button[2]){
      JColorChooser theme = new JColorChooser();
      Color color = JColorChooser.showDialog(theme, "Set theme color", Color.BLACK);
      frame.getContentPane().setBackground(color);
      buttonPanel.setBackground(color);
      form.setBackground(color);
      formPanel.setBackground(color);
      color1= color;
    }
    if (e.getSource()== button[3]) {
      frame.dispose();
      new adminManagement();
    }
    if (e.getSource()== button[4]) {
      frame.dispose();
      new viewTransaction();
    }
    if (e.getSource()== button[5]) {
      frame.dispose();
      new CustomerDetails();
    }
    if (e.getSource()== button[6]) {
      frame.dispose();
      new EmployeeDetails();
    }
    if (e.getSource()== button[7]) {
      frame.dispose();
      new TicTacToe();
    }
  }
}
