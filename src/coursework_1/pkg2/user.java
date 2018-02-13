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
    public user(String n, String s, bank_account bA, ArrayList<Double> tl)                                                       
    {
        this.name = n;
        this.surname = s;
        this.bankAccount = bA;
        this.transaction_List=tl;
    }
    public String getfull_name(){
        return this.name+" "+this.surname;
    }
    @Override
    public void run()                                                                                                       
    {
        for (int i = 0; i < transaction_List.size(); i++) {
            if (transaction_List.get(i)<0){
                try {
                    bankAccount.withdraw(transaction_List.get(i),getfull_name());
                } catch (IOException ex) {
                    Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(bankAccount.getAccountBalance()<=0){
                System.out.println("You account balance is"+bankAccount.getAccountBalance()+"which is very low please deposit more money to withdraw");
                break;
            }
            else{
                try {
                    bankAccount.deposit(transaction_List.get(i),getfull_name());
                } catch (IOException ex) {
                    Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
