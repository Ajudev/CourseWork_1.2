/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework_1.pkg2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class user extends Thread {
    private String name;                                                                                                    
    private String surname;
    private bank_account bankAccount;
    private ArrayList<Double> transaction_List; 
    public user(String n, String s, bank_account bA, ArrayList<Double> tl)       //Constructor                                               
    {
        this.name = n;
        this.surname = s;
        this.bankAccount = bA;
        this.transaction_List=tl;
    }
    public String getfull_name(){                                                //Function to get full name 
        return this.name+" "+this.surname;
    }
    @Override
    public void run()                                                            //Runs each thread                                                       
    {
        for (int i = 0; i < transaction_List.size(); i++) {                      //For loop executes the loop for each thread created it goes through the transaction list
            if (transaction_List.get(i)<0){
                try {
                    bankAccount.withdraw(transaction_List.get(i),getfull_name());  // Withdraws from the bank account
                } catch (IOException ex) {                                         //Checks for any I/O Errors
                    Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);     
                }
            }
            if(bankAccount.getAccountBalance()<=0){                               //Checks if the account balance is zero or not
                System.out.println("You account balance is"+bankAccount.getAccountBalance()+"which is very low please deposit more money to withdraw");
                break;
            }
            else{
                try {                                                            
                    bankAccount.deposit(transaction_List.get(i),getfull_name());  //Deposits the amounts according to the transaction list into the bank account
                } catch (IOException ex) {                                        //Checks for any I/O Errors
                    Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
