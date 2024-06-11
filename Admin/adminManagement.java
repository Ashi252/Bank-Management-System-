import java.util.HashMap;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

import Database.SqlStatements;

public class adminManagement  implements ActionListener{
JFrame frame = new JFrame();
    JTextPane reasonText = new JTextPane();
    JButton delete = new JButton();
    JButton rButton = new JButton();
    JButton  restrict = new JButton();
    JPanel TPanel = new JPanel();
    JPanel TextPanel = new JPanel();
    JPanel Panel3 = new JPanel();
    JLabel label = new JLabel();
    JLabel userID = new JLabel("Customer Account Number/Employee ID");
    JLabel reason = new JLabel("Reason For Your Action");
    JLabel Massage = new JLabel();
    JLabel info = new JLabel();
    JLabel Message = new JLabel();
    JTextField ID = new JTextField();
    ImageIcon frameIcon = new ImageIcon("Images/Untitled.png");
    SqlStatements st = new SqlStatements();
    JPanel formPanel = new JPanel();
    JPanel form = new JPanel();
    JButton back = new JButton("<-Back");
    Border border = BorderFactory.createLineBorder(Color.BLUE, 2);
    String pass;
String pin = "1234";
String Password;
String accountID;
JButton removeRestriction = new JButton("Remove Restriction");
HashMap<String,String> data = new HashMap<>();
  public adminManagement(){
// this are titles used for the login fields
userID.setBounds(150,170,300,25);
reason.setBounds(150,230,200,25);

// working on the return button
back.setFocusable(false);
back.addActionListener(this);
back.setCursor(new Cursor(Cursor.HAND_CURSOR));

// working on the error massage to be displayed if User input are invalid
Massage.setBounds(170,120,250,25);
Massage.setFont(new Font(null, Font.ITALIC,12));
// working on the singUp massage
Message.setBounds(120,100,500,30);
Message.setFont(new Font(null, Font.ITALIC,20));
Message.setText("Customer/ Employee Information");
Message.setForeground(Color.blue);

// working on the phone input field
        ID.setBounds(150,190,230,25);

// working on the password field
        reasonText.setBounds(150,250,230,80);
        reasonText.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        reasonText.setBorder(border);

// working on the logIn button
        delete.setBounds(300, 420, 80, 25);
        delete.setText("Delete");
        delete.setForeground(Color.RED);
        delete.setFocusable(false);
        delete.addActionListener(this);
        delete.setCursor(new Cursor(Cursor.HAND_CURSOR));
// working on the remove RestrictionButton
removeRestriction.setBounds(180, 500, 200, 25);
removeRestriction.setForeground(Color.blue);
removeRestriction.setFocusable(false);
removeRestriction.addActionListener(this);
removeRestriction.setCursor(new Cursor(Cursor.HAND_CURSOR));

// working on the   restrict button
        restrict.setBounds(150, 420, 80, 25);
        restrict.setText("Restrict");
        restrict.setFocusable(false);
        restrict.addActionListener(this);
        restrict.setCursor(new Cursor(Cursor.HAND_CURSOR));

// working on the reset button
        rButton.setBounds(225,460,80,25);
        rButton.setText("Cancel");
        rButton.setFocusable(false);
        rButton.addActionListener(this);
        rButton.setCursor(new Cursor(Cursor.HAND_CURSOR));


// adding all components to the frame
formPanel.setLayout(null);
formPanel.add(userID);
formPanel.add(reason);
formPanel.add(Massage);
formPanel.add(ID);
formPanel.add(reasonText);
formPanel.add(delete);
formPanel.add(info);
formPanel.add(restrict);
formPanel.add(rButton);
formPanel.add(Message, STR);
formPanel.setPreferredSize(new Dimension(500,600));

form.setBackground(adminHomepage.color1);
        formPanel.setBackground(adminHomepage.color1);
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
// adding all components to the frame

// frame.add(pin);
// frame.add(pintxt);
form.add(formPanel, BorderLayout.CENTER);
form.add(removeRestriction);
frame.add(form, BorderLayout.CENTER);
frame.add(TPanel, BorderLayout.NORTH);

frame.setVisible(true);
  }
// this method is used to restrict the customer or employee account as provided by the administrator
private void restrict(){
// Sql statement to retrieve the customer or employee account details based on the account number or employee ID provided and store the result in this variable accountID  and Password and then the SQL statement to delete the customer or employee login Password from the database
Password = "12342";
accountID = "435465787";

        pass = JOptionPane.showInputDialog("Your Password");
        if (pass.equals(pin)) {
        int n = JOptionPane.showConfirmDialog(frame, "Please Confirm Account Restriction ",  "Confirm", JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION) {
        // inserting the data retrieved into the hash map called data
        data.put(accountID, Password);
        data.values();
        JOptionPane.showMessageDialog(frame, "Restriction Complete");
    // checking if the user decides not to approve the process
        }else if (n==JOptionPane.NO_OPTION) {
        JOptionPane.showMessageDialog(frame, "Restriction Process Terminated Successfully");
        }
        }
        else{
        JOptionPane.showMessageDialog(frame, "Invalid Password");
        }
        }

private void delete(){
        pass = JOptionPane.showInputDialog("Your Password");
        if (pass.equals(pin)) {
        int n = JOptionPane.showConfirmDialog(frame, "Please Confirm Account deletion ",  "Confirm", JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION) {
        // Sql statement to delete the customer or employee account details based on the account number or employee ID provided by the Administrator from the database

        JOptionPane.showMessageDialog(frame, "Deleting Process Complete");
    // checking if the user decides not to approve the process
        }else if (n==JOptionPane.NO_OPTION) {
        JOptionPane.showMessageDialog(frame, "Deleting Process Terminated Successfully");
        }
        }
        else{
        JOptionPane.showMessageDialog(frame, "Invalid Password");
        }


}
private void removeRestriction(){
        pass = JOptionPane.showInputDialog("Your Password");
        if (pass.equals(pin)) {
        int n = JOptionPane.showConfirmDialog(frame, "Please Confirm Remove Restriction Process ",  "Confirm", JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION) {
        accountID = ID.getText();
        data.get(accountID);
        // Sql statement to insert the customer or employee accountID and password back into the database

        JOptionPane.showMessageDialog(frame, "Remove Restriction Process Complete");
    // checking if the user decides not to approve the process
        }else if (n==JOptionPane.NO_OPTION) {
        JOptionPane.showMessageDialog(frame, "Remove Restriction Terminated Successfully");
        }
        }
        else{
        JOptionPane.showMessageDialog(frame, "Invalid Password");
        }



}
private void showMessage(String message){
Massage.setText(message);
}
private boolean notice(){
        if (ID.getText().isEmpty() || reasonText.getText().isEmpty()) {
                if (ID.getText().isEmpty()) {
                        ID.setBackground(Color.RED);
                        Massage.setForeground(Color.RED);
                        showMessage("Please enter an Employee or Customer ID.");
                        }
                        else if (reasonText.getText().isEmpty() ) {
                        reasonText.setBackground(Color.RED);
                        Massage.setForeground(Color.RED);
                        showMessage("Please enter a reason for your action.");
                        }
                        if (!reasonText.getText().isEmpty() ){
                        reasonText.setBackground(Color.white);
                        }
                        if (!ID.getText().isEmpty() ){
                                ID.setBackground(Color.white);
                                
                                }
        }
        else{
                restrict();
        }
        
        
        return true;
}
private boolean deletenotice(){
        if (ID.getText().isEmpty() || reasonText.getText().isEmpty()) {
                if (ID.getText().isEmpty()) {
                        ID.setBackground(Color.RED);
                        Massage.setForeground(Color.RED);
                        showMessage("Please enter an Employee or Customer ID.");
                        }
                        else if (reasonText.getText().isEmpty() ) {
                        reasonText.setBackground(Color.RED);
                        Massage.setForeground(Color.RED);
                        showMessage("Please enter a reason for your action.");
                        }
                        if (!reasonText.getText().isEmpty() ){
                        reasonText.setBackground(Color.white);
                        }
                        if (!ID.getText().isEmpty() ){
                                ID.setBackground(Color.white);
                                
                                }
        }
        else{
                delete();
        }
        
        
        return true;
}
private boolean removeRestrictionnotice(){
        if (ID.getText().isEmpty() || reasonText.getText().isEmpty()) {
                if (ID.getText().isEmpty()) {
                        ID.setBackground(Color.RED);
                        Massage.setForeground(Color.RED);
                        showMessage("Please enter an Employee or Customer ID.");
                        }
                        else if (reasonText.getText().isEmpty() ) {
                        reasonText.setBackground(Color.RED);
                        Massage.setForeground(Color.RED);
                        showMessage("Please enter a reason for your action.");
                        }
                        if (!reasonText.getText().isEmpty() ){
                        reasonText.setBackground(Color.white);
                        }
                        if (!ID.getText().isEmpty() ){
                                ID.setBackground(Color.white);
                                
                                }
        }
        else{
                removeRestriction();
        }
        
        
        return true;
}
public static void main(String[] args) {
  new adminManagement();
}

@Override
public void actionPerformed(ActionEvent e) {
if (e.getSource()==back) {
        frame.dispose();
        new adminHomepage();
}
if (e.getSource()== restrict) {
        notice();
}
if (e.getSource()==delete) {
   deletenotice();
}
if (e.getSource()==rButton) {
        JOptionPane.showMessageDialog(frame, "Process Cancelled Redirecting to hamePage...");
        frame.dispose();
        new adminHomepage();
}
if (e.getSource()== removeRestriction) {
removeRestrictionnotice();
}
}
}

