package Login;

import Entities.User;

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
// import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;




public class homePage implements ActionListener{
    JFrame frame = new JFrame();
    ImageIcon frameIcon = new ImageIcon("src/Images/Untitled.png");
    JPanel buttonsPanel = new JPanel();
    JPanel TPanel = new JPanel();
    JLabel label = new JLabel();
    JButton[] buttons = new JButton[4];
    JLabel userLabel = new JLabel();
    JButton transferLabel = new JButton();
    JButton transactionHistory = new JButton();
    JButton sports = new JButton();
    JButton PayBills = new JButton();
    JButton dataLabel = new JButton();
    JButton loan = new JButton();
    JLabel welcome = new JLabel();
    JLabel Hi = new JLabel();
    JLabel balances = new JLabel();
    JLayeredPane BPanel = new JLayeredPane();
    ImageIcon home = new ImageIcon("src/Images/home.png");
    ImageIcon setting = new ImageIcon("src/Images/settings.png");
    ImageIcon notification = new ImageIcon("src/Images/envelope.png");
    ImageIcon profile = new ImageIcon("src/Images/user.png");
    ImageIcon transfer = new ImageIcon("src/Images/money-coin-transfer.png");
    ImageIcon win = new ImageIcon("src/Images/trophy-star.png");
    ImageIcon history = new ImageIcon("src/Images/time-past.png");
    ImageIcon data = new ImageIcon("src/Images/priority-arrows.png");
    ImageIcon bills = new ImageIcon("src/Images/hand-bill.png");
    ImageIcon loanBills = new ImageIcon("src/Images/loan.png");
    User customer;

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

    homePage( User customer){
        this.customer = customer;
        balances.setBounds(180,145,120,15);
        balances.setText("Balance: " + customer.balance);
        balances.setForeground(Color.BLUE);
        balances.setFont(new Font(null, Font.BOLD, 12));
        balances.setOpaque(true);
        balances.setBackground(new Color(0xfafafa));
        balances.setFocusable(false);

        Hi.setBounds(180,125,120,13);
        Hi.setText("Hi " + customer.FirstName);
        Hi.setForeground(Color.BLUE);
        Hi.setFont(new Font(null, Font.BOLD, 10));
        Hi.setBackground(new Color(0xfafafa));
        Hi.setOpaque(true);
        Hi.setFocusable(false);

        // Hi.setBorder(BorderFactory.createEtchedBorder());

        welcome.setBounds(0,10,120,15);
        welcome.setText("Welcome " + customer.FirstName);
        welcome.setForeground(Color.BLUE);
        welcome.setFont(new Font(null, Font.BOLD, 12));
        welcome.setOpaque(true);
        welcome.setBackground(new Color(0xfafafa));
        welcome.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));

// working on the Utility components
        transferLabel.setOpaque(true);
        transferLabel.setBounds(20,230,80,50);
        transferLabel.setBorder(BorderFactory.createBevelBorder(0));
        transferLabel.setIcon(transfer);
        transferLabel.setToolTipText("Make a Transfer");
        transferLabel.setHorizontalAlignment(JButton.CENTER);
        transferLabel.setVerticalAlignment(JButton.CENTER);
        transferLabel.addActionListener(this);
        transferLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        transferLabel.setFocusable(false);


        dataLabel.setOpaque(true);
        dataLabel.setBounds(115,230,80,50);
        dataLabel.setBorder(BorderFactory.createBevelBorder(0));
        dataLabel.setIcon(data);
        dataLabel.setToolTipText("Buy mobile Data");
        dataLabel.setHorizontalAlignment(JButton.CENTER);
        dataLabel.setVerticalAlignment(JButton.CENTER);
        dataLabel.addActionListener(this);
        dataLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        dataLabel.setFocusable(false);


        loan.setOpaque(true);
        loan.setBounds(20,300,80,50);
        loan.setBorder(BorderFactory.createBevelBorder(0));
        loan.setIcon(loanBills);
        loan.setToolTipText("Take a Loan");
        loan.setHorizontalAlignment(JButton.CENTER);
        loan.setVerticalAlignment(JButton.CENTER);
        loan.addActionListener(this);
        loan.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loan.setFocusable(false);

        sports.setOpaque(true);
        sports.setBounds(210,230,80,50);
        sports.setIcon(win);
        sports.setToolTipText("Credit your betting account");
        sports.setHorizontalAlignment(JButton.CENTER);
        sports.setVerticalAlignment(JButton.CENTER);
        sports.addActionListener(this);
        sports.setBorder(BorderFactory.createBevelBorder(0));
        sports.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sports.setFocusable(false);

        transactionHistory.setOpaque(true);
        transactionHistory.setBounds(305,230,80,50);
        transactionHistory.setIcon(history);
        transactionHistory.setToolTipText("View Transaction History");
        transactionHistory.setHorizontalAlignment(JButton.CENTER);
        transactionHistory.setVerticalAlignment(JButton.CENTER);
        transactionHistory.addActionListener(this);
        transactionHistory.setBorder(BorderFactory.createBevelBorder(0));
        transactionHistory.setCursor(new Cursor(Cursor.HAND_CURSOR));
        transactionHistory.setFocusable(false);

        PayBills.setOpaque(true);
        PayBills.setBounds(400,230,80,50);
        PayBills.setIcon(bills);
        PayBills.setToolTipText("Pay Bills");
        PayBills.setHorizontalAlignment(JButton.CENTER);
        PayBills.setVerticalAlignment(JButton.CENTER);
        PayBills.addActionListener(this);
        PayBills.setBorder(BorderFactory.createBevelBorder(0));
        PayBills.setCursor(new Cursor(Cursor.HAND_CURSOR));
        PayBills.setFocusable(false);

// working on the userprofileIcon
        userLabel.setOpaque(true);
        userLabel.setBackground(Color.BLUE);
        userLabel.setBounds(200,40,80,80);
        BPanel.setBounds(0,85,500,650);
        BPanel.add(userLabel);
        BPanel.add(transferLabel);
        BPanel.add(dataLabel);
        BPanel.add(sports);
        BPanel.add(transactionHistory);
        BPanel.add(PayBills);
        BPanel.add(welcome);
        BPanel.add(Hi);
        BPanel.add(buttonsPanel);
        BPanel.add(balances);
        BPanel.add(loan);
        frame.add(BPanel);




//working on the button panel
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,4));
        buttonsPanel.setBounds(0,480,500,100);




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
        frame.setResizable(false);

        frame.add(TPanel, BorderLayout.NORTH);


        frame.setLocationRelativeTo(null);

    }


    public static void main(String[] args) {
//        new homePage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttons[3]) {
            // JFileChooser fileChooser = new JFileChooser();
            // fileChooser.showOpenDialog(null);
            frame.dispose();
            new profileUI(customer);
        }

        // making the utilities responsive
        if (e.getSource()== transferLabel) {
            frame.dispose();
            new transferUI(customer);
        }
        if (e.getSource()== dataLabel) {

        }
        if (e.getSource()== sports) {

        }
    }


}