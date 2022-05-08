//Savings.java

import java.util.*;

public class Savings extends Checking {
  
  public Savings(){
    balance=0;
    accType="Saving Account";
  }
  public Savings(double balance){
    this.balance=balance;
    accType="Saving Account";
  }
  public double applyInterest(int t){
    //A=P(1+RT)
    
     balance*=(1+0.05*t);
         return balance;}
             
  }//end Savings
 
