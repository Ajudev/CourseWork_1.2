/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework_1.pkg2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class CourseWork_12 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);                                                           
        ArrayList<user> USER=new ArrayList<>();                                                         
        int i=4;                                                                                        
        bank_account bankacc=new bank_account(9876543210L,1980);                                                  
        ArrayList<Double> tran_1 = new ArrayList<>();                           //Creating Arraylists to store the transactions
        ArrayList<Double> tran_2 = new ArrayList<>();
        ArrayList<Double> tran_3 = new ArrayList<>();
        ArrayList<Double> tran_4 = new ArrayList<>();
        bank_account bA = new bank_account(9876543210L,1980.0);
        tran_1.addAll(Arrays.asList(50.0,10.0,-20.0,10.0,-20.0,20.0,10.0,50.0,10.0,10.0,10.0,50.0));  //Storing transactions
        tran_2.addAll(Arrays.asList(20.0,20.0,-20.0,50.0,-20.0,10.0,50.0,50.0,-20.0,10.0,10.0));
        tran_3.addAll(Arrays.asList(50.0,10.0,10.0,-10.0,-10.0,50.0,20.0,-10.0,-20.0));
        tran_4.addAll(Arrays.asList(50.0,10.0,-20.0,20.0,10.0,-20.0));
        USER.add(new user("Saul","Goodman",bA,tran_1));
        USER.add(new user("Walter","White",bA,tran_2));
        USER.add(new user("Jessie","Pinkman",bA,tran_3));
        USER.add(new user("Hank","Schrader",bA,tran_4));
        while(true){
            System.out.println("Welcome to the application");
            System.out.println("Press 1 to create a new bank account, press 2 to create a user, Press 3 to run simulation, Press 4 to exit, Press 6 to display the arraylist");
            int choice=s.nextInt();
            if (choice==1){                                 //Creates a bank account
                long accountno=9876543210L;
                System.out.println("The Bank account with "+accountno+" and an account balance of $1980 has been created");
            }
            if(choice==2){                                  //Creates a user and adds him to a bank account
                while (true){
                    System.out.println("Please enter your name:");
                    String name=s.next();
                    System.out.println("Please enter your surname: ");
                    String surname=s.next();
                    ArrayList<Double> transaction_List=new ArrayList<>();                                                                  //temp Arraylist to be filled by user
                    while (true){      //Recording his transactions
                        System.out.println("Please enter the transactions you wish to make with a - before the amount for withdrawing the amount");
                        double amount=s.nextDouble();
                        System.out.println("Do you wish to write more transactions type yes or no: ");
                        String c=s.next();
                        if(c.equals("yes")){
                            System.out.println("You have chosen to continue writing transactions");
                            transaction_List.add(amount);
                        }
                        if (c.equals("no")){
                            System.out.println("Transactions recorded");
                            break;    
                        }
                        else{
                            System.out.println("Please choose the right option");
                            break;
                        }   
                    }
                    USER.add(new user(name,surname,bankacc,transaction_List));    //Creating a new user with bank account and transaction lists                                                        
                    i++;                                                                                                    
                    System.out.println("Do you wish to add more users type yes or no: ");
                    String c1=s.next(); 
                
                    if (c1.equals("yes")) {
                        System.out.println("You have chosen to add more users");
                    }
                    if (c1.equals("no")) {
                        System.out.println("Please run the simulation");
                        break;
                    } else {
                        System.out.println("You have typed an invalid command");
                        break;
                    }
                }
            }
            if(choice==3){            //Runs the simulation 
                System.out.println("Press 4 to exit the program once the simulation is done"); //Starting all threads using for loop
                for(int j=0;j<i;j++){
                    USER.get(j).start();                                                                                    
                }
            }
            if (choice==4){           //Exit the program
                System.exit(0);                                                                                             
            }
        }
    }
}
