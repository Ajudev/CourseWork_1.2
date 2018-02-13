/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework_1.pkg2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Lenovo
 */
public class bank_account {
    private long accountNo;                                                                     
    private double accountBalance;
    private user user;
    public bank_account(long accountNo, double accountBalance)                                        
    {
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;   
    }
    public long getAccountNo()                                                   //Function to get the account number
    {
        return this.accountNo;
    }
    public double getAccountBalance()                                            //Function to get the account balance
    {
        return this.accountBalance;
    }   
    public synchronized void deposit(double value,String u) throws IOException    //Deposits to the bank account                                          
    {
        System.out.println("User Name: "+u+" deposits an amount of: "+value);
        accountBalance+=value;                                                    //Deposits to the account the value passed
        String v = Double.toString(value);
        String a = Double.toString(accountBalance); 
        try {                                                                     //Stores each transaction in a file for display
            FileWriter fw = new FileWriter("log.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("User name: "+u+"Amount deposited: "+v);
            bw.newLine();
            bw.write("New Account Balance: "+a);
            bw.newLine();
            bw.close();
            fw.close();
        } catch (IOException ex) {
            ex.toString();
        }
    }
    public synchronized void withdraw(double value,String u) throws IOException     //Withdraws from bank account
    {
        System.out.println("User Name: "+u+" withdraws an amount of: "+value);
        accountBalance-=-(value);                                                   //Withdraws from the account the value passed
        String v = Double.toString(value);
        String a = Double.toString(accountBalance);
        try{                                                                        //Stores each transaction in a file for display
          FileWriter fw = new FileWriter("log.txt",true);     
          BufferedWriter bw = new BufferedWriter(fw);
          bw.write("User name: "+u+" Amount Withdrawn: "+v);
          bw.newLine();
          bw.write("New Account Balance: "+a);
          bw.newLine();
          bw.close();
          fw.close();
        } catch(IOException ex){
            ex.toString();
        }
    }
}
