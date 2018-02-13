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
        ArrayList<Double> tran_1 = new ArrayList<>();
        ArrayList<Double> tran_2 = new ArrayList<>();
        ArrayList<Double> tran_3 = new ArrayList<>();
        ArrayList<Double> tran_4 = new ArrayList<>();
        bank_account bA = new bank_account(9876543210L,1980.0);
        tran_1.addAll(Arrays.asList(50.0,10.0,-20.0,10.0,-20.0,20.0,10.0,50.0,10.0,10.0,10.0,50.0));
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
            if (choice==1){
                long accountno=9876543210L;
                System.out.println("The Bank account has been created - "+accountno+" with account balance of $1980");
            }
            if(choice==2){
                while (true){
                    System.out.println("Enter your name - ");
                    String name=s.next();
                    System.out.println("Enter your surname - ");
                    String surname=s.next();
                    ArrayList<Double> transaction_List=new ArrayList<>();                                                                  //temp Arraylist to be filled by user
                    while (true){
                        System.out.println("Enter the amount depicted by - or + before the amount to withdraw or deposit");
                        double amount=s.nextDouble();
                        System.out.println("Do you wish to continue adding transactions? Enter y for yes and n for no");
                        String c=s.next();
                        if(c.equals("yes")){
                            System.out.println("You have selected to do more transactions");
                            transaction_List.add(amount);
                        }
                        if (c.equals("no")){
                            break;    
                        }
                        else{
                            System.out.println("You have entered an incorrect option and are exiting the program");
                            break;
                        }   
                    }
                    USER.add(new user(name,surname,bankacc,transaction_List));                                                            
                    i++;                                                                                                    
                    System.out.println("Do you wish to continue adding users? Enter y for yes and n for no");
                    String c1=s.next(); 
                
                    if (c1.equals("yes")) {
                        System.out.println("You have selected to add more users");
                    }
                    if (c1.equals("no")) {
                        System.out.println("You have selected to stop adding users. Please run the simulation after this process");
                        break;
                    } else {
                        System.out.println("You have selected an incorrect/invalid option so the program is assuming you want to stop entering users");
                        break;
                    }
                }
            }
            if(choice==3){
                System.out.println("Press 4 to exit the program once the simulation is done");
                for(int j=0;j<i;j++){
                    USER.get(j).start();                                                                                    
                }
            }
            if (choice==4){
                System.exit(0);                                                                                             
            }
        }
    }
}
