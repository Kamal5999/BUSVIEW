package com.example.anew;

public class userinfo {
    String fname;
    String age;
    String phone;
    String lname;
    String bus_no;

    public userinfo(String fname, String age, String phone, String lname) {
        this.fname = fname;
        this.age = age;
        this.phone = phone;
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public String getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getLname() {
        return lname;
    }

    public String getBus_no()
    {
        return bus_no;
    }
}
