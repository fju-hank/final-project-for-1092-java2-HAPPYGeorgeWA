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
}
