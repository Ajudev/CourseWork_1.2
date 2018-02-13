/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework_1.pkg2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class CourseWork_12 {
    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);                                                           //Taking input from the 
        ArrayList<user> USER = new ArrayList<>();
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
        int i=4;
        while(true){
            System.out.println("Welcome to the application");
            System.out.println("Press 1 to create a new bank account, press 2 to create a user, Press 3 to run simulation, Press 4 to exit");
            int choice=s.nextInt();
            if (choice==1){
                long accountno=9876543210L;
                System.out.println("A bank account with account number 9876543210 has been created with a balance of 19860.0");
            }
            if(choice==2){
                while (true){
                    System.out.println("Please enter your name: ");
                    String name=s.next();
                    System.out.println("Please enter your surname: ");
                    String surname=s.next();
                    ArrayList<Double> TL=new ArrayList<>();                                                                  //temp Arraylist to be filled by user
                    while (true){
                        System.out.println("Please enter the transactions you wish to make with a - before the amount for withdrawing the amount");
                        double amount=s.nextDouble();
                        System.out.println("Do you wish to write more transactions type yes or no: ");
                        String c= s.next();
                        if(c.equals("yes")){
                            System.out.println("You have chosen to continue writing transactions");
                            TL.add(amount);
                        }
                        else if (c.equals("no")){
                            System.out.println("Transactions recorded");
                            break;    
                        }
                        else{
                            System.out.println("Please choose the right option");
                            break;
                        }   
                    }
                    USER.add(new user(name,surname,bA,TL));                                                            //Adding user defined object to Arrayllist of class User
                    i++;                                                                                                    //Keeping count of users made
                    System.out.println("Do you wish to add more users type yes or no: ");
                    String c1=s.next();
                if(c1.equals("yes")){
                    System.out.println("You have chosen to add more users");
                }
                else{ 
                    if (c1.equals("no")){
                    System.out.println("Please run the simulation");
                    break;    
                }
                else{
                    System.out.println("You have typed an invalid command");
                    break;
                }
                }
            }
            if(choice==3){
                int counter=0;
                while (counter<4){
                    for (int j = 0; j < i; j++) {
                        USER.get(j).start();         //starting all threads
                        counter++;
                    }
                    String rt = s.next();
                    System.out.println("Do you wish to run the simulation again type yes or no");
                    String c2 = s.next();
                    if (c2.equals("yes")) {
                        System.out.println("You have chosen to continue the simulation");
                    } 
                    else if (c2.equals("no")) {
                        System.out.println("You have selected to end the program");
                        long acc_no = bA.getAccountNo();
                        double balance = bA.getAccountBalance();
                        System.out.println("The account balance for the account number: "+acc_no+" is "+balance);
                        break;
                    } 
                    else {
                        System.out.println("You selected an invalid option please select a correct option");
                    }
                }

                }
            if (choice==4){
                System.out.println("Thank you for using the program");
                System.exit(0);                                                                                             //exiting the program
            }
        }
    }
    
}   
}
