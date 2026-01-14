package model;

import model.Amount;
import model.Client;

/**
 *
 * @author ignac
 */

public class Account {

    private int number;
    private Amount balance;
    public Client holder;

     public Account(int number, String balance, boolean holder, double money, String currency) {
        this.number = number;
        
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Amount getBalance() {
        return balance;
    }

    public void setBalance(Amount balance) {
        this.balance = balance;
    }

    public Client getHolder() {
        return holder;
    }

    public void setHolder(Client holder) {
        this.holder = holder;
    }
    
    
}