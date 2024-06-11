import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
public class TicTacToe implements ActionListener {

  Random random = new Random();
  JFrame frame = new JFrame();
  JPanel TPanel = new JPanel();
  JPanel T2Panel = new JPanel();
  JPanel BPanel =new JPanel();
  JLabel TField = new JLabel();
  JLabel T2Field = new JLabel();
  JButton back = new JButton("<-Back");
  JButton[] buttons = new JButton[9];
  boolean player1;
  ImageIcon frameIcon = new ImageIcon("Images/Untitled.png");
    TicTacToe(){
    // working on the return button
back.setFocusable(false);
back.addActionListener(this);
back.setCursor(new Cursor(Cursor.HAND_CURSOR));
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setSize(5000,1000);
    frame.getContentPane().setBackground(new Color(60,60,70));
    frame.setLayout(new BorderLayout());
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    frame.setIconImage(frameIcon.getImage());

    TField.setBackground(new Color(25,25,25));
    TField.setForeground(new Color(25,255,25));
    TField.setFont(new Font("sanserif", Font.BOLD, 40));
    TField.setHorizontalAlignment(JLabel.CENTER);
    TField.setText("Tic-Tac-Toe");
    TField.setOpaque(true);
    

    T2Field.setBackground(new Color(25,25,25));
    T2Field.setForeground(new Color(25,255,0));
    T2Field.setFont(new Font("sanserif", Font.BOLD, 40));
    T2Field.setHorizontalAlignment(JLabel.CENTER);
    T2Field.setText("");
    T2Field.setOpaque(true);

    TPanel.setLayout(new BorderLayout());
    TPanel.setBounds(0,0,500,70);

    T2Panel.setLayout(new BorderLayout());
    T2Panel.setBounds(0,0,500,50);

    BPanel.setLayout(new GridLayout(3,3));
    BPanel.setBackground(new Color(150,150,150));
    frame.add(BPanel);
    
    
    for(int i=0; i<9;i++){
      buttons[i] = new JButton();
      BPanel.add(buttons[i]);
      buttons[i].setFont(new Font("Italic", Font.ITALIC, 100));
      buttons[i].setFocusable(false);
      buttons[i].addActionListener(this);
    }
    
    TPanel.add(back, BorderLayout.WEST);
    TPanel.add(TField);
    T2Panel.add(T2Field);
    frame.add(TPanel, BorderLayout.NORTH);
    frame.add(T2Panel,  BorderLayout.SOUTH);

  firstTurn();

  }
  public void TakeAChillPeal(){
    try {
      Thread.sleep(1500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void TakeAChillPeal2(){
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  @Override
  public void actionPerformed(ActionEvent e) {
   for(int i=0; i<9; i++){
    if (e.getSource()== buttons[i]) {
      if (player1) {
        if (buttons[i].getText()=="") {
          buttons[i].setForeground(new Color(255,0,0));
          sound1();
          buttons[i].setText("X");
          player1=false;
          T2Field.setText("O Turn");
          check();
        }
      }
      else{
        if (buttons[i].getText()=="") {
          buttons[i].setForeground(new Color(0,0,255));
          sound1();
          buttons[i].setText("O");
          player1=true;
          T2Field.setText("X Turn");
          check();

      }
    }
    
   }
   }
   if (e.getSource()==back) {
    frame.dispose();
    new adminHomepage();
  }
  }
  

  public void firstTurn(){
    TakeAChillPeal();
  if (random.nextInt(2)==0) {
    player1=true;
    T2Field.setText("it's X Turn");
  }
  else{
    player1=false;
    T2Field.setText("it's O Turn");
  }
  }

  public void check(){
    if ((buttons[0].getText()=="X" && buttons[1].getText()=="X"
    && buttons[2].getText()=="X" )) {
      X_wins(0,1,2);
    }
    if ((buttons[3].getText()=="X" && buttons[4].getText()=="X"
    && buttons[5].getText()=="X" )) {
      X_wins(3,4,5);
    }
    if ((buttons[6].getText()=="X" && buttons[7].getText()=="X"
    && buttons[8].getText()=="X" )) {
      X_wins(6,7,8);
    }
    if ((buttons[1].getText()=="X" && buttons[4].getText()=="X"
    && buttons[7].getText()=="X" )) {
      X_wins(1,4,7);
    }
    if ((buttons[0].getText()=="X" && buttons[3].getText()=="X"
    && buttons[6].getText()=="X" )) {
      X_wins(0,3,6);
    }
    if ((buttons[2].getText()=="X" && buttons[5].getText()=="X"
    && buttons[8].getText()=="X" )) {
      X_wins(2,5,8);
    }
    if ((buttons[0].getText()=="X" && buttons[4].getText()=="X"
    && buttons[8].getText()=="X" )) {
      X_wins(0,4,8);
    }
    if ((buttons[0].getText()=="X" && buttons[4].getText()=="X"
    && buttons[8].getText()=="X" )) {
      X_wins(0,4,8);
    }
    if ((buttons[2].getText()=="X" && buttons[4].getText()=="X"
    && buttons[6].getText()=="X" )) {
      X_wins(2,4,6);
    }

    
// checking if O won

    if ((buttons[0].getText()=="O" && buttons[1].getText()=="O"
    && buttons[2].getText()=="O" )) {
      O_wins(0,1,2);
    }
    if ((buttons[3].getText()=="O" && buttons[4].getText()=="O"
    && buttons[5].getText()=="O" )) {
      O_wins(3,4,5);
    }
    if ((buttons[6].getText()=="O" && buttons[7].getText()=="O"
    && buttons[8].getText()=="O" )) {
      O_wins(6,7,8);
    }
    if ((buttons[1].getText()=="O" && buttons[4].getText()=="O"
    && buttons[7].getText()=="O" )) {
      O_wins(1,4,7);
    }
    if ((buttons[0].getText()=="O" && buttons[3].getText()=="O"
    && buttons[6].getText()=="O" )) {
      O_wins(0,3,6);
    }
    if ((buttons[2].getText()=="O" && buttons[5].getText()=="O"
    && buttons[8].getText()=="O" )) { 
      O_wins(2,5,8);
    }
    if ((buttons[0].getText()=="O" && buttons[4].getText()=="O"
    && buttons[8].getText()=="O" )) {
      O_wins(0,4,8);
    }
    if ((buttons[0].getText()=="O" && buttons[4].getText()=="O"
    && buttons[8].getText()=="O" )) {
      O_wins(0,4,8);
    }
    if ((buttons[2].getText()=="X" && buttons[4].getText()=="X"
    && buttons[6].getText()=="X" )) {
      X_wins(2,4,6);
    }

    
    
    //checking if it is a tie
    // if ((buttons[0].getText()=="O" && buttons[1].getText()=="O"
    // && buttons[5].getText()=="O" )) {
    //   Tie_wins(null,null,null);
    // }vv
    // if ((buttons[3].getText()=="O" && buttons[7].getText()=="O"
    // && buttons[5].getText()=="O" )) {
    //   Tie_wins(null,null,null);
    // }
    // if ((buttons[2].getText()=="O" && buttons[7].getText()=="O"
    // && buttons[8].getText()=="O" )) {
    //   Tie_wins(null,null,null);
    // }
    // if ((buttons[1].getText()=="O" && buttons[4].getText()=="O"
    // && buttons[3].getText()=="O" )) {
    //   Tie_wins(null,null,null);
    // }
    // if ((buttons[1].getText()=="O" && buttons[4].getText()=="O"
    // && buttons[6].getText()=="O" )) {
    //   Tie_wins(null,null,null);
    // }
    // if ((buttons[2].getText()=="O" && buttons[5].getText()=="O"
    // && buttons[8].getText()=="O" )) { 
    //   O_wins(2,5,8);
    // }
    // if ((buttons[0].getText()=="O" && buttons[4].getText()=="O"
    // && buttons[8].getText()=="O" )) {
    //   O_wins(0,4,8);
    // }
    // if ((buttons[0].getText()=="O" && buttons[4].getText()=="O"
    // && buttons[8].getText()=="O" )) {
    //   O_wins(0,4,8);
    // }


  }
  public void Tie_wins(Object object, Object object2, Object object3) {
    
  }
  public void X_wins(int a, int b, int c){
    buttons[a].setBackground(new Color(25,255,0));
    buttons[b].setBackground(new Color(25,255,0));
    buttons[c].setBackground(new Color(25,255,0));



    for(int i=0; i<9; i++){
      buttons[i].setEnabled(false);
    }
    
    sound();
    TField.setText("X Wins, What a game!");
    T2Field.setText("Congratulations!");


    reRun();
    
    

  }
  
  public void O_wins(int a, int b, int c){
    buttons[a].setBackground(new Color(25,255,0));
    buttons[b].setBackground(new Color(25,255,0));
    buttons[c].setBackground(new Color(25,255,0));


    for(int i=0; i<9; i++){
      buttons[i].setEnabled(false);
    }
    
    sound();
    if(buttons[a] == null && buttons[b] == null && buttons[c] == null){
      T2Field.setText("It's a TIE!");
    }
    TField.setText("O Wins, What a game!");
    T2Field.setText("Congratulations!");


    
    reRun();
    

  }

public void reRun(){
  int n = JOptionPane.showConfirmDialog(frame, "Would you like a rematch", 
  "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (n == JOptionPane.YES_OPTION) 
        {
          frame.dispose();
          
          new TicTacToe();

        }
        else{
          if (n== JOptionPane.NO_OPTION) {
            int b = JOptionPane.showConfirmDialog(frame, "Do you want to Exit?", 
            "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (b == JOptionPane.YES_OPTION) 
        {
          frame.dispose();
        }
          }
        }

}

public void sound(){
        try {
            File wavFile = new File("sounds/mixkit-instant-win-2021.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(wavFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            System.out.println("Error with playing sound.");
            e.printStackTrace();
        }
    }

    public void sound1(){
      try {
          File wavFile = new File("sounds/mixkit-arcade-game-jump-coin-216.wav");
          AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(wavFile);
          Clip clip = AudioSystem.getClip();
          clip.open(audioInputStream);
          clip.start();
      } catch (Exception e) {
          System.out.println("Error with playing sound.");
          e.printStackTrace();
      }
  }
  public static void main(String[] args) {
    new TicTacToe();
  }
}




  


