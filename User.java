package Entities;

import Database.SqlStatements;

import java.sql.ResultSet;
import java.sql.Statement;

public class User {
    public  int customerID;
    public  String FirstName;
    public  String LastName;
    public  String DOB;
    public  String Email;
    public  String gender;
    public  String Address;
    public  String ContactNumber;
    public  String UserPass;
    public  String accountNumber;
    public  String accountType;
    public  double balance;
    public  String openDate;
    Statement st;

    public User(){
        try{
            SqlStatements sql = new SqlStatements();
            st = sql.createConn();
        }catch(Exception e){
            System.out.println("An error occured"+ e);
        }
    }

    public void createCustomer(String phone) {
        try {
            ResultSet rs = st.executeQuery(String.format("Select * from customer where contactNumber = '%s'", phone));
            while (rs.next()) {
                customerID = rs.getInt(1);
                FirstName = rs.getString(2);
                LastName = rs.getString(3);
                DOB = rs.getString(4);
                gender = rs.getString(5);
                ContactNumber = rs.getString(6);
                Address = rs.getString(7);
                Email = rs.getString(8);
                UserPass = rs.getString(9);

                createAccount();
            }

        } catch (Exception e) {

        }
//        System.out.println(customerID);

    }

    public void createAccount(){
        try {
            ResultSet rs = st.executeQuery(String.format("Select * from account where customerId = '%d'", customerID));
            while (rs.next()) {
                accountNumber = rs.getString(1);
                accountType = rs.getString(3);
                balance = rs.getDouble(4);
                openDate = rs.getString(5);
//            System.out.println(accountType);
            }
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        new User().createCustomer("09087342512");
    }
}
