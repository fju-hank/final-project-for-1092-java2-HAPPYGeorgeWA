package com.fju;

public class User {
    private String name;
    private String account;
    private int password;
    private int balance;


    public User(String name,String account, int password,  int balance) {
        this.name = name;
        this.password = password;
        this.account = account;
        this.balance = balance;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getPassword(){
        return password;
    }

    public void setPassword(int password){
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account){
        this.account = account;
    }

    public int getBalance(){
        return balance;
    }

    public void setBalance(int balance){
        this.balance = balance;
    }

}
