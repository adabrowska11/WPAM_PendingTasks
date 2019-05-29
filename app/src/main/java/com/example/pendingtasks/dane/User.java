package com.example.pendingtasks.dane;

public class User {

    private long userId;
    private String email;

    public User() {};
     public User(long userId, String email) {
         this.userId = userId;
         this.email = email;
     }

     public long getUserId() { return userId; };
     public String getEmail() { return email; };
}
