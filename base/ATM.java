//ATM.java
import java.io.*;
import java.util.*;

public class ATM implements Serializable {
     //using ArrayList
     protected ArrayList<User> users = new ArrayList<User>();
     protected File userFile = new File("UserData.txt");
          

        //public void listUser();
                                            
     

/*
    //initFile
     public void initFile(){
          
        users[1].initAccuntNum("121314","54321");
        users[2].initAccuntNum("454647","67890");
        users[3].initAccuntNum("354740","90900");
        
        users[1].Deposit(20000.0, "Checking");
        users[2].Deposit(500.0, "Checking");
        users[3].Deposit(1000.0, "Checking");
        
        users[1].Deposit(0.0, "Saving");
        users[2].Deposit(50000.0, "Saving");
        users[3].Deposit(69.99, "Saving");
         
        
        
        try {
	    FileOutputStream fin = new FileOutputStream(userFile);
	    ObjectOutputStream fout = new ObjectOutputStream(fin);
	    fout.writeObject(Customer);
	}
         
        catch (Exception e){
	    System.out.println(e.getMessage());
	}
          
       fout.close();

   } //end initFile
  */  
   //save to file    
   public void SaveFile(){
              
          //using serialization to update the file
          try{
            FileOutputStream fo = new FileOutputStream(userFile);
            ObjectOutputStream obo = new ObjectOutputStream(fo);
            obo.writeObject(users);
          }catch(Exception e){
             System.out.println(e.getMessage());
           }
          //fo.close();      
   }//end saveFile 
            
           
   //Read from the file 
   public void ReadFile(){
      
     try {
         FileInputStream fin = new FileInputStream(userFile);
         ObjectInputStream obi = new ObjectInputStream(fin);
         users = (ArrayList<User>)obi.readObject();
     }catch (Exception e){
      System.out.println(e.getMessage());
    } // end try
 
     //obi.close();
  }//end readFile

 //Login method     
 public void login(){
     boolean keepGoing = true;
        
     while(keepGoing){

        Scanner input = new Scanner(System.in);

        System.out.println("Enter your account number: "); //ask for account number
       if(input.hasNextLine()){   
           String accNum = input.nextLine(); 
         
      
        //check if the user is an admin
           if(accNum.equals("00000")){    
                //ask for pin
                System.out.println("Enter your PIN: ");
               
                if(input.hasNextLine()){
                   if(input.nextLine().equals("12345")){
                     //call the admin menu
                      adminMenu();
                    }//end if
                  }
                  //check if the user is uncknown
                  else{

                       System.out.println("Sorry, the account is unknown, try again!");
                            
                      }//end if
                if(input.hasNextLine()){
                   if(input.nextLine().equals("exit")){
                       System.out.println("Have a great day!");
                        keepGoing = false;
                    }//end if
                 } //end else if
        
         //else the user is a customer
           }else{
 
              for(int i=0; i<users.size(); i++){
             //using get method to specify the user index   
                if(users.get(i).userLogin(accNum)){
                   break;

                  }//end if
               }//end for
            }//end else
        }//end if
       }//end while    
              
      }//end login   
      


      public void adminMenu(){
  
         boolean keepGoing = true;         
        
         String menu = "Choose the action:\n"+
            "1. add a user\n"+
            "2. delete a user (account must be empty)\n"+
            "3. list all users\n"+
            "4. apply interest to all savings accounts\n"+
            "5. exit\n";
      
      while(keepGoing){ 
        System.out.println(menu);

        Scanner input = new Scanner(System.in);
        String num = input.nextLine();
            
       
        if(num.equals("1")){
           addUser();
        }

        else if(num.equals("2")){
           deleteUser();
        }

        else if(num.equals("3")){
           listUser();
        }

        else if(num.equals("4")){
           applyIntrest(); 
        }

        else if(num.equals("5")){
           keepGoing = false;
           System.out.print("have a great day! ");
           
        }   
              
      }//end while        
    }      
      public void addUser(){
          boolean keepGoing = true;

          System.out.println("welcome to the add user menu! ");
          Scanner input = new Scanner(System.in);
        
       while(keepGoing){
  
          if (input.hasNextLine()){  
              
               //enter the acc# and pin to access the customer
               System.out.println("Enter the account number: ");
               String accNum = input.nextLine();
               //enter the pin#
               System.out.println("Enter the pin: ");
               String pin = input.nextLine();   
               User nc = new User(accNum, pin);
               users.add(nc);
               keepGoing = false;
               System.out.println("The customer added succefully!"); 
                
               
           }//end if
           else{
               System.out.println("Oops, something went wrong do you wanna try again?");
               String tryAgain = input.nextLine();

               if(tryAgain.equals("Yes")){
                   keepGoing = true;
               } //end if
               else{
                   keepGoing = false;
                   System.out.println("Sorry, I didn't understand! ");
                  
                } //end else 
           } //end else 
               
        }//end while
         
      }

      public void deleteUser(){
         //list the user so to see which
         //one should be deleted
         listUser();
         System.out.println("Welcome to delete user menu");
         boolean keepGoing = true;
         Scanner input = new Scanner(System.in);
         
         while(keepGoing){
            int indx=input.nextInt(); 
            if(input.hasNext()){
               //the user index
               //int indx = input.nextInt();
               if(indx>=0 && indx< users.size()){
                     users.remove(indx);
                }//end if
                
                System.out.println("The user is out the system");
            }//end if
            else{
                 System.out.println("Do you want to add new user?");    
                 if(indx==1){
                     addUser();
                  }//end if
                 else{
                     keepGoing = false;
                     System.out.println("I don't understand");
                     
                 }//end else
             }//end else
              
          }//end while

       }//end deleteUser       

        public void listUser(){
             
            System.out.println("Welcome to the users list!");
            for(int i=0; i<users.size(); i++){
              System.out.println(i); //get(i).getUserData())
                         
             }//end for     
                
    
         }//end listUser
              
         public void applyIntrest(){

             System.out.println("Apply intrest menu");
             Scanner input = new Scanner(System.in);

             if(input.hasNextInt()){
                int t = input.nextInt();
                 
                if(t>=0){
           
                 for (int i=0;i<users.size();i++){
                   users.get(i).applyInterest(t);
                 }//end for
              }//end if
            }//end if
           else{
              System.out.println("Oops something went wrong!");
           }//end else
      
    }//end applyIntrest

     public static void main(String[] args){
          boolean keepGoing = true;
          ATM a = new ATM();
          
          while(keepGoing){

             a.ReadFile();
             a.login();
             a.SaveFile();
           }//end while
        }//end main
 }      
   
