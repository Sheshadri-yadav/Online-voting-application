package com.example.votingsystememail1;

public class users {

    String name;
    String email;
    String phone;
    String vote;
    String identify;

    public users(String name, String email, String phone,String vote,String identify) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.vote=vote;
        this.identify=identify;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getVote(){return  vote;}
    public String getIdentify(){return  identify;}
}
