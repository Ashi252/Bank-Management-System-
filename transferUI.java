package Login;

import Database.SqlStatements;
import Entities.User;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.LocalDate;
import java.util.Date;

public class transferUI extends JFrame implements ActionListener {
    ImageIcon image = new ImageIcon("src/Images/Untitled.png");
    JPanel TPanel = new JPanel();
    JLabel label = new JLabel();
    JLabel account = new JLabel("Account Number");
    JLabel customerName = new JLabel();
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
    User customer;
    SqlStatements sq = new SqlStatements();
    String receiverId;

    transferUI(User customer){
        this.customer = customer;
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
        account.setBounds(125,250,140,20);
        accountNumber.setBounds(125,270,230,20);
        accountNumber.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                customerName.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (Banks.getSelectedItem().equals("Realm Bank")) {
                    String statement = String.format("select customerId from account where accountNumber = '%s'", accountNumber.getText());
                    String[] customerData;
                    customerData = sq.selectCustomerData(statement);
                    System.out.println(customerData[1]);
                    receiverId = customerData[1];
                    if (sq.select(statement)) {
                        if (!accountNumber.getText().equals(customer.accountNumber)) {
                            customerData = sq.selectCustomerData(String.format("Select fistName, lastName from customer where customerId = '%s' ", customerData[1]));
                            customerName.setText(customerData[1] + " " + customerData[2]);
                            customerName.setForeground(Color.RED);
                        } else {
                            customerName.setText("Invalid customer");
                        }
                    }
                }else if(accountNumber.getText().length() != 10){
                    customerName.setText("Invalid");
                }
            }
        });
        customerName.setBounds(125, 290, 230, 20);
// working on the select bank and bank component
        selectBank.setBounds(125,210,140,20);
        Banks.setBounds(125,230,230,20);

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
        pinLabel.setBounds(125, 310, 140, 20);
        pin.setBounds(125, 330, 230, 20);

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
        this.add(customerName);
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
        String password = String.valueOf(pin.getPassword());
        String Account = accountNumber.getText().trim();
        int amt = Integer.parseInt(amount.getText().trim());
        String bank = (String) Banks.getSelectedItem();

        if (Account.isEmpty() || amt == 0 || password.length() == 0) {
            showMessage("Please fill in all fields.");
            return true;
        }
        else if (password.length() != 4) {
            showMessage("pin must be 4 digits long.");
            pin.setBackground(Color.RED);
            return true;
        }
        else{

            approve(password, Account, amt, bank);
        }


////checking if pin is valid and matches the user pin in the db
//// if (password != userDB.pin) {
////   showMessage("Invalid Pin.");
//// }
//// else if (password == userDB.pin) {
//        approve();
//// }


        return true;
    }




    // processing the transaction, checking if the information corresponds with the db
    private boolean approve(String password, String account, int amt, String bank){

        int n = JOptionPane.showConfirmDialog(this, "Are you sure you want to approve this transaction of "+ amount.getText(), "Confirm", JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION) {
            if(bank.equals("Realm Bank")){
                if (password.equals(customer.pin) && amt < customer.balance && !customerName.equals("")) {
                    customer.balance -= amt;
                    String statement = String.format("Update account set balance = '%s' where customerId = '%s'",customer.balance, customer.customerID);
                    sq.Update(statement);
                    statement = String.format("Update account set balance = '%s' where customerId = '%s'", amt, receiverId);
                    if(sq.Update(statement)) {
                        statement = String.format("Insert into transaction(accountNumber, transactionType, amount, transactionDate, receiver) values '%s', '%s', '%s', '%s', '%s'", customer.accountNumber, "debit", amt, LocalDate.now(),account);
                        sq.insert(statement);
                        successfulTrans();
                    }else{
                        unsuccessfulTransaction();
                    }
                } else {
                   unsuccessfulTransaction();
                }
            }else{
                if(account.length() == 10 && amt < customer.balance && password.equals(customer.pin)){
                    customer.balance -= amt;
                    String statement = String.format("Update account set balance = '%s' where customerId = '%s'",customer.balance, customer.customerID);
                    if(sq.Update(statement)) {
                        statement = String.format("Insert into transaction(accountNumber, transactionType, amount, transactionDate, receiver) values '%s', '%s', '%s', '%s', '%s'", customer.accountNumber, "debit", amt, LocalDate.now(),account);
                        sq.insert(statement);
                        successfulTrans();
                    }else{
                        unsuccessfulTransaction();
                    }
                }else {
                    unsuccessfulTransaction();
                }
            }


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
            new homePage(customer);
        }
        if (e.getSource()== transfer) {
            check();
        }
        if (e.getSource()== back) {
            this.dispose();
            new homePage(customer);
        }
    }

    public void successfulTrans(){
        System.out.println(customer.balance);
        showMessage("Transaction Successful");
        bar.setString("Transaction Approved");
    }

    public void unsuccessfulTransaction(){
        showMessage("Transaction Unsuccessful");
        bar.setString("Transaction Unapproved");
    }
    public static void main(String[] args) {
        User user = new User();
        new transferUI(user);
    }
}
