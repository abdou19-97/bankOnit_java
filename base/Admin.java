//Admin.java
import java.util.*;
import java.io.*;

public class Admin extends User{
      int accNo;
      int pin;
      double balance;
      
      Admin(){
        super("00000", "12345");
      }
       
     public void AdminMenu(){
       
         String menu = "Choose the action:\n"+
            "1. add a user\n"+
            "2. delete a user (account must be empty)\n"+
            "3. list all users\n"+
            "4. apply interest to all savings accounts\n"+
            "5. exit\n";
        System.out.println(menu);

        Scanner input = new Scanner(System.in);
        String num = input.nextln();
      
        if(num == "1"){
           addUser(String ad);
        }
         
        else if(num == "2"){
           deleteUser(String del);
        }

        if(num == "3"){
           listUsers();
        }

        if(num == "4"){
           ApplyIntrest(double intrest);
        }

        if(num == "5"){
           System.out.print("have a great day! ");
        }
      
  
     public void addUser(){
           
          
           Scanner input = new Scanner(System.in);
           
           System.out.println("Add new user ");
           String addUser = input.nextln();
           customers.(accNo, pin, balance);
           System.out.print("New user info: " + Arrays.toString(;

           try {
	    FileOutputStream fi = new FileOutputStream("userData.txt");
	    ObjectOutputStream obIn = new ObjectOutputStream(fi);
	    customers = (Customer[])obIn.writeObject();
 //obIn.writeObject(customers);

    	}catch (Exception e){
	    System.out.println(e.getMessage());
    	}     
      
        obIn.close();   
    }
      
   public void deleteUser(String del){
         
          System.out.println("Delete user ");    
         

           try {
            FileInputStream fi = new FileInputStream("userData.txt");
            ObjectInputStream obIn = new ObjectInputStream(fi);
            //customers = (Customer[])obIn.writeObject();
            obIn.readObject();
            
           }catch (Exception e){
                System.out.println(e.getMessage());
           }
            
           obIn.close();
       
   }


  public void applyIntrest(double ai){
  
 
 }
  
  public void listUser(){
        
       System.out.println("");
 }



