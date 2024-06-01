package Login;

import Entities.User;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class profileUI implements ActionListener {
    JFrame frame = new JFrame();
    JLabel label = new JLabel();
    JPanel TPanel = new JPanel();
    JLabel FirstName,LastName,DOB,Email,gender,Address,ContactNumber,accountNumber,accountType,LoanAmount,interestRate,startDate,endDate,openDate;
    ImageIcon image = new ImageIcon("src/Images/Untitled.png");
    JButton delete = new JButton();
    JButton update = new JButton();
    JButton back = new JButton("Back");

    public profileUI(User customer){
// working on the user details
        FirstName = new JLabel();
        FirstName.setBounds(100, 130,230,25);
        FirstName.setText("First Name: "+ customer.FirstName);
        FirstName.setBackground(Color.cyan);
        FirstName.setOpaque(true);

        LastName = new JLabel();
        LastName.setBounds(100, 160, 230, 25);
        LastName.setText("Last Name: "+ customer.LastName);

        DOB = new JLabel();
        DOB.setBounds(100, 190, 230, 25);
        DOB.setText("Date of Birth: "+ customer.DOB);

        Email = new JLabel();
        Email.setBounds(100, 220, 230,25);
        Email.setText("Email: "+ customer.Email);

        gender = new JLabel();
        gender.setBounds(100, 250, 230, 25);
        gender.setText("Gender: "+ customer.gender);

        Address = new JLabel();
        Address.setBounds(100,280,230,25);
        Address.setText("Address: "+ customer.Address);

        ContactNumber = new JLabel();
        ContactNumber.setBounds(100,310,230,25);
        ContactNumber.setText("Contact Number: "+ customer.ContactNumber);

        accountNumber = new JLabel();
        accountNumber.setBounds(100,340,230,25);
        accountNumber.setText("Account Number: "+ customer.accountNumber);

        accountType = new JLabel();
        accountType.setBounds(100,370,230,25);
        accountType.setText("Account Type: "+ customer.accountType);

        LoanAmount = new JLabel();
        LoanAmount.setBounds(100, 400, 230, 25);
        String loan = "Loan Amount: ";
        String rate = "Interest Rate: ";
        String beginDate = "Loan Started on: ";
        String finishDate = "Loan end's on: ";
        if(customer.loanAmount == null){
            loan += "Null";
            rate += "Null";
            beginDate += "Null";
            finishDate += "Null";
        }else{
            loan += customer.loanAmount;
            rate += customer.interestRate;
            beginDate += customer.openDate;
            finishDate += customer.endDate;
        }
        LoanAmount.setText(loan);

        interestRate = new JLabel();
        interestRate.setBounds(100,430,230, 25);
        interestRate.setText(rate);

        startDate = new JLabel();
        startDate.setBounds(100,460, 230,25);
        startDate.setText(beginDate);

        endDate = new JLabel();
        endDate.setBounds(100, 490, 230, 25);
        endDate.setText(finishDate);


        openDate = new JLabel();
        openDate.setBounds(100,520,230,25);
        openDate.setText("Account Created on: "+ customer.openDate);
// working on the return button
        back.setBounds(0,80,80,25);
        back.setFocusable(false);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new homePage(customer);
            }
        });
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));

// working on the delete button
        delete.setFocusable(false);
        delete.setText("Delete");
        delete.setForeground(Color.red);
        delete.setBounds(200,580,80,20);
        delete.addActionListener(this);
        delete.setCursor(new Cursor(Cursor.HAND_CURSOR));

        update.setFocusable(false);
        update.setText("Update");
        update.setForeground(Color.blue);
        update.setBounds(300,580,80,20);
        update.addActionListener(this);
        update.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
        frame.setIconImage(image.getImage());
        frame.setTitle("Realm Bank");
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.add(delete);
        frame.add(back);
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
        frame.add(update);
    }

    public static void main(String[] args) {
//        new profileUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== delete) {
            // Sql statement to delete the user account
        }
        if (e.getSource()== back) {
            frame.dispose();
//            new homePage();
        }
        if (e.getSource()== update) {
            frame.dispose();
//            new updatePage();
        }
    }
}
