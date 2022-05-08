//Checking.java

import java.io.*;
import java.util.*;

public class Checking implements Serializable {
  protected double balance;
  protected String accType;
  public Checking(){
    balance=0;
    accType="Checking Account";
  }
  public Checking(double balance){
    this.balance=balance;
    accType="Checking Account";
  }//end constructor

  public double getBalance(){
    return balance;}
  public double addBalance(double amount){
    balance+=amount;
    return balance;}

  public String toString(){
    return balance+accType;
  }
 
  public void menu(){
    boolean keepGoing = true;
    while(keepGoing){
      Scanner sc = new Scanner(System.in);
      System.out.println(accType+" menu\n"+"1) Display info"+"\n2)withdrawl/deposite"+"\n3)exit");
      String a = sc.nextLine();
      if(a.equals("1")){//display
        System.out.println(" your Balance is:"+balance);
      }//end if
         
      else if(a.equals("2")){//withdrawl/deposite
        System.out.println("amount you wish to deposite or the amount to withdrawl:");
        if(sc.hasNextDouble()){
          double amount=sc.nextDouble();
          if(balance+amount<0){
            System.out.println("Oops, please check your balance");
          }//end if
          else{
              addBalance(amount);
          }//end else
        }//end if
      }//else if
     
       else if (a.equals("3")){//exit
        break;
      }//end else if
      else{//out of bound input
        System.out.println("I don't understand");
         keepGoing = false;
      }//end else
  
   }//end while
  } //end menu

}//end Checking 
