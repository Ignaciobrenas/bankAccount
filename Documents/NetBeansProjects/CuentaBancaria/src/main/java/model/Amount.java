/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ignac
 */

public class Amount {
    private double money;
    private String currency;

    public Amount(double money, String currency) {
        this.money = money;
        this.currency = currency;
        
    }

    public double getMoney() {
        return money;
        
    }

    public String getCurrency() {
        return currency;
        
    }

    public void setMoney(double money) {
        this.money = money;
        
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

 
}
