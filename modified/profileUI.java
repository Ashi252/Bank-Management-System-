


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.JOptionPane;

import Database.User;
// import userrepo.homePage;
// import userrepo.userDB;

public class profileUI implements ActionListener {
  JFrame frame = new JFrame();
  JLabel label = new JLabel();
  JPanel TPanel = new JPanel();
  JButton logout = new JButton();
  JButton changeImage =  new JButton();
  JLabel FirstName,LastName,DOB,Email,gender,Address,ContactNumber,accountNumber,accountType,LoanAmount,interestRate,startDate,endDate,openDate;
  ImageIcon image = new ImageIcon("Images/Untitled.png");
  JButton back = new JButton("<-Back");
  JButton delete = new JButton();
  JButton update = new JButton();
  JLabel userLabel = new JLabel();
  ActionListener l;
  String pin = "12345678";
  String pass;

  public static ImageIcon vel;

  public profileUI(User customer){
    // Setting the ImageIcon to the label
    userLabel.setIcon(vel);

    userLabel.setOpaque(true);
    userLabel.setBackground(Color.lightGray);
    userLabel.setBounds(390,102,90,100);

// working on the delete button
delete.setFocusable(false);
delete.setText("Delete");
delete.setForeground(Color.red);
delete.setBounds(100,580,80,20);
delete.addActionListener(this);
delete.setCursor(new Cursor(Cursor.HAND_CURSOR));

update.setFocusable(false);
update.setText("Update");
update.setForeground(Color.blue);
update.setBounds(300,580,80,20);
update.addActionListener(this);
update.setCursor(new Cursor(Cursor.HAND_CURSOR));
    logout.setFocusable(false);
    logout.setText("logout");
    logout.setForeground(Color.red);
    logout.setBounds(200,580,80,20);
    logout.addActionListener(this);
    logout.setCursor(new Cursor(Cursor.HAND_CURSOR));

    changeImage.setFocusable(false);
    changeImage.setText("Profile Image");
    changeImage.setForeground(Color.blue);
    changeImage.setBounds(380,80,117,20);
    changeImage.addActionListener(this);
    changeImage.setCursor(new Cursor(Cursor.HAND_CURSOR));
// working on the user details
FirstName = new JLabel();
FirstName.setBounds(100, 130,230,25);
FirstName.setText("First Name: "+ userDB.FirstName);
FirstName.setBackground(Color.cyan);
FirstName.setOpaque(true);

LastName = new JLabel();
LastName.setBounds(100, 160, 230, 25);
LastName.setText("Last Name: "+ userDB.LastName);

DOB = new JLabel();
DOB.setBounds(100, 190, 230, 25);
DOB.setText("Date of Birth: "+ userDB.DOB);

Email = new JLabel();
Email.setBounds(100, 220, 230,25);
Email.setText("Email: "+ userDB.Email);

gender = new JLabel();
gender.setBounds(100, 250, 230, 25);
gender.setText("Gender: "+ userDB.gender);

Address = new JLabel();
Address.setBounds(100,280,230,25);
Address.setText("Address: "+ userDB.Address);

ContactNumber = new JLabel();
ContactNumber.setBounds(100,310,230,25);
ContactNumber.setText("Contact Number: "+ userDB.ContactNumber);

accountNumber = new JLabel();
accountNumber.setBounds(100,340,230,25);
accountNumber.setText("Account Number: "+ userDB.accountNumber);

accountType = new JLabel();
accountType.setBounds(100,370,230,25);
accountType.setText("Account Type: "+ userDB.accountType);

LoanAmount = new JLabel();
LoanAmount.setBounds(100, 400, 230, 25);
LoanAmount.setText("Loan Amount: "+ userDB.LoanAmount);

interestRate = new JLabel();
interestRate.setBounds(100,430,230, 25);
interestRate.setText("Interest Rate: "+ userDB.interestRate);

startDate = new JLabel();
startDate.setBounds(100,460, 230,25);
startDate.setText("Loan Started on: "+ userDB.startDate);

endDate = new JLabel();
endDate.setBounds(100, 490, 230, 25);
endDate.setText("Loan End's on: "+ userDB.endDate);

openDate = new JLabel();
openDate.setBounds(100,520,230,25);
openDate.setText("Account Created on: "+ userDB.openDate);
// working on the return button
back.setBounds(0,80,80,25);
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
        label.setText("Realm Bank");
        label.setOpaque(true);
        TPanel.add(label, BorderLayout.CENTER);
        frame.add(TPanel, BorderLayout.NORTH);
// setting default image
  if (userLabel.getIcon() == null) {
    defaultImage();
  }

  // initializing and setting the frame features
  
  frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setSize(500,650);
    frame.getContentPane().setBackground(homePage.color1);
    frame.setVisible(true);
    frame.setIconImage(image.getImage());
    frame.setTitle("Realm Bank");
    frame.setResizable(false);
    frame.setLayout(null);
    frame.setLocationRelativeTo(null);
    frame.add(FirstName);
    frame.add(LastName);
    frame.add(DOB);
    frame.add(Email);
    frame.add(gender);
    frame.add(Address);
    frame.add(ContactNumber);
    frame.add(accountNumber);
    frame.add(accountType);
    frame.add(LoanAmount);
    frame.add(interestRate);
    frame.add(startDate);
    frame.add(endDate);
    frame.add(openDate);
    frame.add(logout);
    frame.add(changeImage);
    frame.add(delete);
    frame.add(update);
    frame.add(back);
    frame.add(userLabel);
  }
public void defaultImage(){
// setting default user image
ImageIcon imagepath =new ImageIcon("Images/user.png");
Image se = imagepath.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
vel  = new ImageIcon(se);
userLabel.setIcon(vel);
}
  public static void main(String[] args) {
    new profileUI(null);
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


  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource()== back) {
      frame.dispose();
      new homePage(null);
    }
    if (e.getSource()==changeImage) {
      openImage();
    }
    if (e.getSource()==logout) {
      frame.dispose();
      new logIn();
    }
    if (e.getSource()==delete) {
      if (loanUI.level== "Active") {
        JOptionPane.showMessageDialog(frame,"Sorry, can't delete this account,pay your outstanding loan. Please ");
      }
      else{
        int i =JOptionPane.showConfirmDialog(frame,"Are you sure you want to delete this account");
        if (i == JOptionPane.YES_OPTION) {
          pass = JOptionPane.showInputDialog("Enter your 8 digits password");
          if (pass.equals(pin)) {
            // the SQL statement to delete this account from the database
            frame.dispose();
            JOptionPane.showMessageDialog(frame,"Account deleted successfully");
            new logIn();
            
          }
          else{
            JOptionPane.showMessageDialog(frame,"Wrong password");
          }
        }
      }
    }
    if (e.getSource()== update) {
        if (loanUI.level== "Active") {
          JOptionPane.showMessageDialog(frame,"Sorry, can't delete this account,pay your outstanding loan. Please ");
        }
        else{
          int i =JOptionPane.showConfirmDialog(frame,"Are you sure you want to update this account");
          if (i == JOptionPane.YES_OPTION) {
            pass = JOptionPane.showInputDialog("Enter your 8 digits password");
            if (pass.equals(pin)) {
              frame.dispose();
              new updatePage();
            }
            else{
              JOptionPane.showMessageDialog(frame,"Wrong password");
            }
          }
        }
    }
  }
}

