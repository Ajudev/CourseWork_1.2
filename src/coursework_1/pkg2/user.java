/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework_1.pkg2;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class user extends Thread {
    private String name;                                                                                                    //Class attributes
    private String surname;
    private bank_account bankAccount;
    private ArrayList<Double> transactionlist;
    public user(String n, String s, bank_account bA, ArrayList<Double> tl)                                                       
    {
        this.name = n;
        this.surname = s;
        this.bankAccount = bA;
        this.transactionlist=tl;
    }
    public String getfull_name(){
        return this.name+" "+this.surname;
    }
    @Override
    public void run()                                                                                                       
    {
//        try{
        for (int i = 0; i < transactionlist.size(); i++) {
            if (transactionlist.get(i)<0){
                bankAccount.withdraw(transactionlist.get(i),getfull_name());
            }
            if(bankAccount.getAccountBalance()<=0){
                System.out.println("You account balance is "+bankAccount.getAccountBalance()+"which is very low please deposit more money to withdraw");
                break;
            }
            else{
                bankAccount.deposit(transactionlist.get(i),getfull_name());
            }
        }
//        Thread.sleep(4000);
        }
    
}
