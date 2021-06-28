package com.fju;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ATM bank = new ATM();
        System.out.println("Please enter your account:");
        String account = scan.next();
        System.out.println("Please enter your password:");
        int pwd = scan.nextInt();
        User user= bank.login(account,pwd);
        if(user!=null){
            System.out.println("Welcome, "+user.getName());
            bank.menu();
        }else{
            System.out.println("Error,The debit Card has been withdrawn, please take it back");
        }
    }
}

