package com.fju;

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
}
