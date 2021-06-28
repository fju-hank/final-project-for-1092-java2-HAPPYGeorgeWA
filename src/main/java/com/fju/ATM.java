package com.fju;

import java.util.Scanner;
public class ATM {
    private User[]users = new User[100];

    private int size = 0;

    private User atmuser;

    public ATM() {
        starting();
    }
    public void starting(){
        User user1 = new User("George","11111",12345,200000);
        User user2 = new User("Zofia","22222",54321,200000);
        users[0]=user1;
        users[1]=user2;
        size=2;

    }
    public User login(String account,int password){
        for (int i = 0; i < size; i++) {
            if ((users[i].getAccount().equals(account))&&users[i].getPassword()==password){
                atmuser =users[i];
                return users[i];
            }
        }
        return null;
    }

    public void menu(){
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Welcome to the ATM");
            System.out.println("1.Save\n2.Withdraw\n3.Trans\n4.Query\n5.Revise Password\n0.Exit");

            int num = scan.nextInt();
            switch (num){

                case 1:
                    save();
                    break;

                case 2:
                    withdraw();
                    break;

                case 3:
                    transfer();
                    break;

                case 4:
                    query();
                    break;

                case 5:
                    revise();
                    break;

                case 0:
                    getList();
                    return;
            }
        }while (true);
    }


    public void save(){
        System.out.println("Please enter your amounts:");
        Scanner scan = new Scanner(System.in);
        int money = scan.nextInt();
        if(atmuser !=null){
            if(money>0){
                atmuser.setBalance((atmuser.getBalance()+money));
                System.out.println("Success");
                System.out.println("Your balance:"+ atmuser.getBalance());
            }else
                System.out.println("Error");
        }else {
            System.out.println("Please login in");
        }
    }


    public void withdraw() {
        System.out.println("Please enter the amounts you want to withdraw:" );
        Scanner scan = new Scanner(System.in);
        int money = scan.nextInt();
        if (atmuser != null) {
            if (money > 0 && money <= atmuser.getBalance()) {
                atmuser.setBalance(atmuser.getBalance() - money);
                System.out.println("Success" );
                System.out.println("Your balance:" + atmuser.getBalance());
            } else {
                System.out.println("Error" );
            }
        } else {
            System.out.println("Please login in");
        }
    }


    public void transfer(){
        System.out.println("Please enter the account number you want to transfer:");
        Scanner scan = new Scanner(System.in);
        String account= scan.next();
        User nulluser =null;
        for (int i = 0; i < size; i++) {
            if(users[i].getAccount().equals(account)){
                nulluser =users[i];
            }
        }
        if (atmuser ==nulluser){
            System.out.println("You can't transfer money to yourself");
            return;
        }
        if (atmuser !=null){
            System.out.println("Please enter the amounts you want to transfer:");
            int money = scan.nextInt();
            if (money>0&&money<= atmuser.getBalance()){
                atmuser.setBalance(atmuser.getBalance()-money);
                nulluser.setBalance(nulluser.getBalance()+money);
                System.out.println("Success");
                System.out.println("Your balance:"+ atmuser.getBalance());
                System.out.println("Account:"+nulluser.getAccount()+",its balance:"+nulluser.getBalance());
            }else {
                System.out.println("Error");
            }
        }else {
            System.out.println("Please login in");
        }
    }


    public void query(){
        System.out.println("Your balance:"+ atmuser.getBalance());
    }


    public void revise() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your new password (up to ten words):");
        int newp =scan.nextInt();
        for (int i = 0; i < size; i++) {
            if(users[i]== atmuser){
                users[i].setPassword(newp);
            }
        }
        System.out.println("Success");
    }


    public void getList(){
        System.out.println("Do you want to print the List?\n1.YES\n2.NO\n3.Show on screen");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        Datetime time = new Datetime();
        switch (num){
            case 1:
                System.out.println("Please wait while printing......");
                try {
                    Thread.sleep(5000);
                }catch (InterruptedException e){}
                System.out.println("_______________________");
                System.out.println("-Username: "+atmuser.getName());
                System.out.println("-User balance: "+atmuser.getBalance());
                time.printdate();
                System.out.println("_______________________");
                System.out.println(" ");
                System.out.println("See you next time");
                time.printdate();
                break;
            case 2:
                System.out.println("See you next time");
                time.printdate();
                break;

            case 3:
                System.out.println("Username:"+atmuser.getName());
                System.out.println("User balance:"+atmuser.getBalance());
                System.out.println(" ");
                System.out.println("See you next time");
                time.printdate();
        }
    }
}
