import java.sql.*;

public class userDB {
  public static Integer customerID;
  public static String FirstName;
  public static String LastName;
  public static String DOB;
  public static String Email;
  public static String gender;
  public static String Address;
  public static String ContactNumber;
  public static char[] UserPass;
  public static String accountNumber;
  public static String accountType;
  public static double balance;
  public static Date openDate;
  public static int transactionID;
  public static String transactionType;
  public static double amount;
  public static Date transactionDate;
  public static Time transactionTime;
  public static double LoanAmount;
  public static double interestRate;
  public static Date startDate;
  public static Date endDate;

  private void showMessage(String message) {
    logIn.Massage.setText(message);
  }


userDB(){
// variable declaration
  String Contacts;
  char[] theWord;

// assigning values from the login input fields to the variables
  Contacts =logIn.textField.getText();
  theWord = logIn.Password.getPassword();

  //informing the user that the system is validating
  logIn.bar.setString("Validating...");

// DB connection
  String url = "jdbc:mysql://localhost:3306/Luminous";
    String username = "Ashi";
    String password = "Ashi252";

// working on the login protocol and DB query
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection myCon = DriverManager.getConnection(url, username, password);
      Statement statement = myCon.createStatement();
      ResultSet  r = statement.executeQuery("select * from Customer where column_name = contactNumber ");
      ResultSet  r2 = statement.executeQuery("select * from Customer where column_name = password");

//checking if user data exists in DB and retrieving user information
    if (Contacts != ContactNumber) {
      while (r.next()) {
        ContactNumber = r.getString("contactNumber");
      if (Contacts == ContactNumber) {
        while (r2.next()) {
          UserPass = (char[]) r.getObject("password");
          if (theWord == UserPass) {
            showMessage("LogIn Successful");
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection myConnection = DriverManager.getConnection(url, username, password);
      Statement mystatement = myConnection.createStatement();
      ResultSet  rs = mystatement.executeQuery("select * from Customer where contactNumber"+Contacts);
      ResultSet rs2 = mystatement.executeQuery("select * from Account where contactNumber"+ Contacts);
      ResultSet rs3 = mystatement.executeQuery("select * from Transaction where contactNumber"+ Contacts);
      ResultSet rs4 = mystatement.executeQuery("select * from Loan where contactNumber" + Contacts);

      while (rs.next()) {
        customerID= rs.getInt("customerID");
        FirstName = rs.getString("fistname");
        LastName = rs.getString("lastname");
        DOB = rs.getString("dob");
        gender = rs.getString("gender");
        ContactNumber = rs.getString("contactNumber");
        Address = rs.getString("address");
        Email = rs.getString("email ");
        UserPass = (char[]) rs.getObject("password ");
      }
      while (rs2.next()) {
        customerID = rs2.getInt("customerID");
        accountNumber = rs2.getString("accountNumber");
        accountType = rs2.getString("accountType");
        balance =rs2.getDouble("balance");
        openDate = rs2.getDate("openDate");
      }
      while (rs3.next()) {
        accountNumber = rs3.getString("accountNumber");
        transactionID = rs3.getInt("transactionId");
        transactionType = rs3.getString("transactionType");
        amount = rs3.getDouble("amount");
        transactionDate = rs3.getDate("transactionDate");
        transactionTime = rs3.getTime("transactionTime");
      }
      while (rs4.next()) {
      LoanAmount = rs4.getDouble("loanAmount");
      interestRate = rs4.getDouble("interestRate");
      startDate = rs4.getDate("startDate");
      endDate = rs4.getDate("endDate");
      }
      myCon.close();
      new homePage();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    break;
          }else if(!r2.next() && theWord != UserPass){
            showMessage("Wrong Password");
            break;
          }
        }
      }
      if (!r.next() && !r2.next()) {
        showMessage("Login Field: check Phone and Password field");
        logIn.bar.setString("please sign up if you don't have an account");
        break;
      }
        }
      }
    
    myCon.close();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      System.out.println("Error: with Login protocol " + e.getMessage());
    } catch (SQLException e1) {
      e1.printStackTrace();
    }
}
  public static void main(String[]args ) throws SQLException{
    new userDB();
}
}