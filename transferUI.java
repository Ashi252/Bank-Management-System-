import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;


public class transferUI extends JFrame implements ActionListener {
ImageIcon image = new ImageIcon("Images/Untitled.png");
JPanel TPanel = new JPanel();
JLabel label = new JLabel();
JLabel account = new JLabel("Account Number");
JLabel selectBank = new JLabel("Select Bank");
JLabel pinLabel = new JLabel("Pin");
JLabel massage = new JLabel();
JButton cancel = new JButton("Cancel");
JButton transfer = new JButton("Approve");
JButton back = new JButton("Back");
JTextField amount = new JTextField();
JLabel amountLabel = new JLabel("Amount");
JPasswordField pin = new JPasswordField();
JProgressBar bar = new JProgressBar();
JTextField accountNumber = new JTextField();
JComboBox<String> Banks = new JComboBox<>(new String[]{"Realm Bank", "UBA", "First Bank", "ECO Bank", "OPay", "Palm Pay", "Access Bank", "WEMA Bank", "PayPal", "GT Bank", "Kuda"});

transferUI(){
// working on the return button
back.setBounds(0,80,80,25);
back.setFocusable(false);
back.addActionListener(this);
back.setCursor(new Cursor(Cursor.HAND_CURSOR));
// working on the progress bar
bar.setValue(0);
bar.setBounds(0, 598,500,15);
bar.setStringPainted(true);
bar.setFont(new Font("sana-strikethrough", Font.BOLD, 12));
bar.setForeground(Color.BLUE);
bar.setBackground(Color.black);
// working on the massage label:
massage.setBounds(125,120,230,20);
// working on the amount component:
amountLabel.setBounds(125,150,140,20);
amount.setBounds(125,170,140,30);
// working on the account  and account number field
  account.setBounds(125,210,140,20);
  accountNumber.setBounds(125,230,230,20);
// working on the select bank and bank component
  selectBank.setBounds(125,260,140,20);
  Banks.setBounds(125,280,230,20);
  
// working on the transfer button
  transfer.setBounds(150, 400, 90, 25);
  transfer.setCursor(new Cursor(Cursor.HAND_CURSOR));
  transfer.setFocusable(false);
  transfer.addActionListener(this);
  // working on the cancel button
  cancel.setBounds(250, 400, 90, 25);
  cancel.setCursor(transfer.getCursor());
  cancel.setFocusable(false);
  cancel.addActionListener(this);
// working on the pin field
  pinLabel.setBounds(125, 320, 140, 20);
  pin.setBounds(125, 340, 230, 20);

  TPanel.setLayout(new BorderLayout());
  TPanel.setPreferredSize(new Dimension(500, 80));
  label.setBackground(new Color(25, 25, 255));
  label.setForeground(Color.black);
  label.setFont(new Font("sanserif", Font.BOLD, 35));
  label.setHorizontalAlignment(JLabel.CENTER);
  label.setText("Realm Bank");
  label.setOpaque(true);
  TPanel.add(label, BorderLayout.CENTER);
  this.add(TPanel, BorderLayout.NORTH);

  

  this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  this.setSize(500,650);
  this.getContentPane().setBackground(new Color(0xfafafa));
  this.setVisible(true);
  this.setIconImage(image.getImage());
  this.setTitle("Realm Bank");
  this.setResizable(false);
  this.setLayout(null);
  this.setLocationRelativeTo(null);
  
  this.add(back);
  this.add(massage);
  this.add(amountLabel);
  this.add(amount);
  this.add(selectBank);
  this.add(Banks);
  this.add(accountNumber);
  this.add(account);
  this.add(cancel);
  this.add(transfer);
  this.add(pinLabel);
  this.add(pin);
  this.add(bar);
bar();

}
private void showMessage(String message) {
  massage.setText(message);
  }

public boolean check(){
  char[] password = pin.getPassword();
  String Account = accountNumber.getText().trim();
  String amt = amount.getText().trim();
  
if (Account.isEmpty() || amt.isEmpty() || password.length == 0) {
    showMessage("Please fill in all fields.");
    return true;
}
else{
  showMessage(null);
}
if (password.length >4 || password.length <4) {
  showMessage("pin must be 4 digits long.");
  pin.setBackground(Color.RED);
  return true;
}
else{
  pin.setBackground(Color.white);
}
if (amt.isEmpty()) {
  amount.setBackground(Color.red);
  showMessage("Please enter an amount.");
}
else{
  amount.setBackground(Color.white);
  showMessage(null);
}
if (Account.isEmpty()) {
  accountNumber.setBackground(Color.red);
  showMessage("Please enter an account number.");
}
else{
  accountNumber.setBackground(Color.white);
  showMessage(null);
}
//checking if pin is valid and matches the user pin in the db
// if (password != userDB.pin) {
//   showMessage("Invalid Pin.");
// }
// else if (password == userDB.pin) {
  approve();
// }


  return true;
}




// processing the transaction, checking if the information corresponds with the db
private boolean approve(){

  int n = JOptionPane.showConfirmDialog(this, "Are you sure you want to approve this transaction of "+ amount.getText(), "Confirm", JOptionPane.YES_NO_OPTION);
if (n == JOptionPane.YES_OPTION) {
  showMessage("Transaction Successful");
  bar.setString("Transaction Approved");

}else if (n==JOptionPane.NO_OPTION) {
  showMessage("Transaction Terminated Successfully");
  bar.setString("Terminated");
  // revert transaction
}
  return true;
}


public void bar(){
  bar.setIndeterminate(true);
bar.setString("Waiting...");
}
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource()== cancel) {
      this.dispose();
      new homePage();
    }
    if (e.getSource()== transfer) {
      check();
    }
    if (e.getSource()== back) {
      this.dispose();
      new homePage();
    }
  }
  public static void main(String[] args) {
    new transferUI();
  }
}
