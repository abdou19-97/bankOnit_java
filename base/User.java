//User.java
import java.util.*;
import java.io.*;

public class User implements Serializable{
  String accountNumber, pin;
  Checking checking;
  Savings saving;
  public User(){ 
  }

  public User(String accNum,String pin){
    accountNumber=accNum;
    pin=pin;
    checking=new Checking();
    saving  =new Savings();
  }
  public void applyInterest(int r){
    saving.applyInterest(r);
  }
  public String getAccountNumber(){
     return accountNumber;
  }
  public String getPin(){
     return pin;
  }
  public String getUserData(){
    return accountNumber+" "+pin+" "
    +" Checking "+checking.getBalance()
    +" Saving: "+saving.getBalance();
  }
  public String toString(){

    return accountNumber+pin
    +checking.toString()
    +saving.toString();
  }

  public void userMenu(){
    boolean keepGoing = true;
    while(keepGoing){
      Scanner input = new Scanner(System.in);
      System.out.println("Welcome to the menu"+accountNumber
      +"\n1)cheking accounter\n2)saving account\n3)exit"); 
      String s= input.nextLine();
      if(s.equals("1")){//checking account
        checking.menu();
      }
      else if(s.equals("2")){//saving acconut
        saving.menu();
      } else if(s.toUpperCase().equals("3")){
        keepGoing = false;
      } 
   }
 }//end userMenu 
   
  public boolean userLogin(String accNum){
      Scanner input = new Scanner(System.in);
      System.out.println("pin: ");
      if(input.hasNextLine()){
        if(input.nextLine().equals(pin)){
          userMenu();
          return true;
       }else{
          System.out.println("Oops, login failed!");
        }
     }
    
     return false;//else return false
  }
}//end User

  

