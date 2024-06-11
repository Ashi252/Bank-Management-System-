import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import Database.SqlStatements;

public class adminProfile implements ActionListener {
    public static ImageIcon vel;
    JFrame frame = new JFrame();
  JPanel TPanel = new JPanel();
  JLabel label = new JLabel();
  ImageIcon frameIcon = new ImageIcon("Images/Untitled.png");
  SqlStatements st = new SqlStatements();
  JPanel formPanel = new JPanel();
  JPanel form = new JPanel();
  JLabel userLabel = new JLabel();
  JButton logout = new JButton();
  JButton changeImage = new JButton();
  JLabel FirstName,LastName,DOB,Email,gender,Address,ContactNumber,accountNumber,accountType,LoanAmount,interestRate,startDate,endDate,openDate;
  JButton back = new JButton("<-Back");
  public adminProfile(){
    changeImage.setFocusable(false);
    changeImage.setText("Profile Image");
    changeImage.setForeground(Color.blue);
    changeImage.setBounds(290,530,117,20);
    changeImage.addActionListener(this);
    changeImage.setCursor(new Cursor(Cursor.HAND_CURSOR));

    logout.setFocusable(false);
    logout.setText("logout");
    logout.setForeground(Color.red);
    logout.setBounds(200,530,80,20);
    logout.addActionListener(this);
    logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
// Setting the ImageIcon to the label
userLabel.setIcon(vel);

userLabel.setOpaque(true);
userLabel.setBackground(Color.lightGray);
userLabel.setBounds(200,0,90,100);
// working on the user details
FirstName = new JLabel();
FirstName.setBounds(100, 100,230,25);
FirstName.setText("First Name: "+ userDB.FirstName);

LastName = new JLabel();
LastName.setBounds(100, 130, 230, 25);
LastName.setText("Last Name: "+ userDB.LastName);

DOB = new JLabel();
DOB.setBounds(100, 160, 230, 25);
DOB.setText("Date of Birth: "+ userDB.DOB);

Email = new JLabel();
Email.setBounds(100, 190, 230,25);
Email.setText("Email: "+ userDB.Email);

gender = new JLabel();
gender.setBounds(100, 220, 230, 25);
gender.setText("Gender: "+ userDB.gender);

Address = new JLabel();
Address.setBounds(100,250,230,25);
Address.setText("Address: "+ userDB.Address);

ContactNumber = new JLabel();
ContactNumber.setBounds(100,280,230,25);
ContactNumber.setText("Contact Number: "+ userDB.ContactNumber);

accountNumber = new JLabel();
accountNumber.setBounds(100,310,230,25);
accountNumber.setText("Account Number: "+ userDB.accountNumber);

accountType = new JLabel();
accountType.setBounds(100,340,230,25);
accountType.setText("Account Type: "+ userDB.accountType);

LoanAmount = new JLabel();
LoanAmount.setBounds(100, 370, 230, 25);
LoanAmount.setText("Loan Amount "+ userDB.LoanAmount);

interestRate = new JLabel();
interestRate.setBounds(100,400,230, 25);
interestRate.setText("Interest Rate: "+ userDB.interestRate);

startDate = new JLabel();
startDate.setBounds(100,430, 230,25);
startDate.setText("Loan Started on: "+ userDB.startDate);

endDate = new JLabel();
endDate.setBounds(100, 460, 230, 25);
endDate.setText("Loan End's on: "+ userDB.endDate);

openDate = new JLabel();
openDate.setBounds(100,490,230,25);
openDate.setText("Account Created on: "+ userDB.openDate);
// working on the return button
back.setFocusable(false);
back.addActionListener(this);
back.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
TPanel.add(back, BorderLayout.WEST);
formPanel.setLayout(null);
formPanel.add(userLabel);
formPanel.add(changeImage);
formPanel.add(logout);
formPanel.add(Address);
formPanel.add(FirstName);
formPanel.add(LastName);
formPanel.add(Email);
formPanel.add(DOB);
formPanel.add(accountNumber);
formPanel.add(accountType);
formPanel.add(startDate);
formPanel.add(endDate);
formPanel.add(openDate);
formPanel.add(interestRate);
formPanel.add(LoanAmount);
formPanel.add(ContactNumber);
formPanel.add(gender);
formPanel.add(logout);
formPanel.setPreferredSize(new Dimension(500,600));


        form.setBackground(adminHomepage.color1);
        formPanel.setBackground(adminHomepage.color1);

// initializing and setting the frame features

frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
frame.setSize(5000,5000);
frame.getContentPane().setBackground(adminHomepage.color1);
frame.setVisible(true);
frame.setIconImage(frameIcon.getImage());
frame.setTitle("Realm Bank Admin");
frame.setResizable(true);
frame.setLayout(new BorderLayout());
frame.setLocationRelativeTo(null);

// setting default image
if (userLabel.getIcon() == null) {
  defaultImage();
}
// adding all components to the frame

// frame.add(pin);
// frame.add(pintxt);
form.add(formPanel, BorderLayout.CENTER);
frame.add(form, BorderLayout.CENTER);
frame.add(TPanel, BorderLayout.NORTH);
frame.setVisible(true);
  }
  private void openImage() {
    // Creating a file chooser
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    fileChooser.setAcceptAllFileFilterUsed(false);
    fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif"));

    // Showing the file chooser dialog
    int result = fileChooser.showOpenDialog(frame);
    if (result == JFileChooser.APPROVE_OPTION) {
        // Getting the selected file
        File selectedFile = fileChooser.getSelectedFile();
        
        // Loading the file as an ImageIcon
        ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
        Image s = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon v = new ImageIcon(s);
        
        // Setting the ImageIcon to the label
        userLabel.setIcon(v);
        homePage.userLabel.setText(null);
        vel = v;
        
    }
    
}
  public void defaultImage(){
    // setting default user image
    ImageIcon imagepath =new ImageIcon("Images/user.png");
    Image se = imagepath.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
    vel  = new ImageIcon(se);
    userLabel.setIcon(vel);
    }
public static void main(String[] args) {
  new adminProfile();
}
@Override
public void actionPerformed(ActionEvent e) {
  if (e.getSource()== back) {
    frame.dispose();
    new adminHomepage();
  }
  if (e.getSource()==changeImage) {
    openImage();
  }
  if (e.getSource()==logout) {
    frame.dispose();
    new adminLogIn();
  }
}
}
