package Login;

import Database.SqlStatements;
import Entities.User;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.border.Border;

public class billUI  implements ActionListener {
    JProgressBar bar = new JProgressBar();
    JLabel label = new JLabel();
    JPanel TPanel = new JPanel();
    ImageIcon image = new ImageIcon("src/Images/Untitled.png");
    JFrame frame = new JFrame();
    JLabel massage = new JLabel();
    JButton back = new JButton("<-Back");
    JLabel number = new JLabel("Amount");
    JLabel Title = new JLabel("Service Provider");
    JTextField amount = new JTextField();
    JPanel labePanel = new JPanel();
    JButton pay = new JButton();
    JComboBox<String> serviceProviders = new JComboBox<>(new String[]{"Water Board", "Ikeja electricity company", "PhEDc"});
    Border border = BorderFactory.createLineBorder(Color.BLUE, 4);
    User user;
    String pass;
    SqlStatements sq = new SqlStatements();
    billUI(User user){
        this.user = user;
        labePanel.setBounds(0,130,487,200);
        labePanel.setBorder(BorderFactory.createBevelBorder(2));
        labePanel.setBorder(border);

        Title.setBounds(125,230,125,20);
        serviceProviders.setBounds(125,350,230,20);
        number.setBounds(125,380,125,20);
        amount.setBounds(125,400,230,20);
// working on the massage label
        massage.setBounds(170,500,230,25);
// working on the return button
        back.setBounds(0,80,80,25);
        back.setFocusable(false);
        back.addActionListener(this);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        // working on the pay button
       pay.setBounds(150,480,180,25);
        pay.setFocusable(false);
        pay.addActionListener(this);
        pay.setText("Confirm Pay");
        pay.setCursor(new Cursor(Cursor.HAND_CURSOR));
        // working on the progress bar
        bar.setValue(0);
        bar.setBounds(0, 598,500,15);
        bar.setStringPainted(true);
        bar.setFont(new Font("sana-strikethrough", Font.BOLD, 12));
        bar.setForeground(Color.BLUE);
        bar.setBackground(Color.black);
// working on ht e panel for the company name
        TPanel.setLayout(new BorderLayout());
        TPanel.setBounds(0,0,500, 80);
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
        frame.setIconImage(image.getImage());
        frame.setTitle("Realm Bank");
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.add(labePanel);
        frame.add(Title);
        frame.add(serviceProviders);
        frame.add(amount);
        frame.add(number);
        frame.add(massage);
        frame.add(TPanel);
        frame.add(back);
        frame.add(pay);
        frame.add(bar);
        frame.setVisible(true);
        bar();
    }
    // working on the progress bar
    public void bar(){
        bar.setIndeterminate(true);
        bar.setString("Waiting...");
    }
    // working on the massage method
    private void showMessage(String message) {
        massage.setText(message);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== back) {
            frame.dispose();
            new homePage(user);
        }
        if (e.getSource()== pay){
            if (amount.getText().isEmpty()){
                amount.setBackground(Color.RED);
                massage.setText("Please enter an amount");
                massage.setForeground(Color.RED);
            }else if(!Pattern.matches("[0-9]{4}", amount.getText())){
                massage.setText("Please insert a valid amount");
                massage.setForeground(Color.RED);
            }
            else{
                massage.setText(null);
                pass = JOptionPane.showInputDialog("Your Transaction Pin");
                if (pass.equals(user.pin)) {
                    massage.setForeground(Color.BLUE);
                    int n = JOptionPane.showConfirmDialog(frame, "Are you sure you want to approve this transaction of "+ amount,  "Confirm", JOptionPane.YES_NO_OPTION);
                    if(n == JOptionPane.YES_OPTION){
                        double amt = Double.parseDouble(amount.getText());
                        user.balance -= amt;
                        String statement = String.format("Update account set balance = '%s' where customerId = '%s'",user.balance, user.customerID);
                        sq.Update(statement);
                        statement = String.format("Insert into transaction(accountNumber, transactionType, amount, transactionDate, receiver) values ('%s', '%s', '%s', '%s', '%s')", user.accountNumber, "recharge", amt, LocalDate.now(),number);
                        sq.insert(statement);
                        showMessage("Transaction Successful");
                        bar.setString("Transaction Approved");
                    }else if (n==JOptionPane.NO_OPTION) {
                        // revert transaction
                        showMessage("Transaction Terminated Successfully");
                        bar.setString("Terminated");
                    }
            }else {
                    massage.setForeground(Color.red);
                    showMessage("Invalid Transaction Pin");
                }
            }
        }
    }
    public static void main(String[] args) {
//        new billUI(null);
        User user = new User();
        new billUI(user);
    }
}