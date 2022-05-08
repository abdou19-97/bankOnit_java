//Account.java
mport java.io.*;
public class Account {
  double balance = 0.0;
  String accountNumber = "";

  Account (String accNo, double b){
    accountNumber = accNo;
    balance = b;
  }


  public int Deposit (double dAmount)
  {
    //if(dAmount < 0){
        //return ;
    balance += dAmount;
    //return 0;
  }


  public int Withdraw (double wAmount)
  {
   
    balance -= wAmount;
  }



