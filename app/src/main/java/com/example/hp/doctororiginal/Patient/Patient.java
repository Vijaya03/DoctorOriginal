package com.example.hp.doctororiginal.Patient;

/**
 * Created by HP on 08-04-2018.
 */

public class Patient {
    String name;
    int age;
    int height;
    String prob;
    String phone;


    public String toString()
{
    return "name="+name+"         "+"age="+age+"     height="+height+"        problem="+prob+"                   "+" phone=    "+phone+"      Appointmet day="+day+"/"+month;
}
    public Patient(String name, int age, int height, String prob, String phone, int day, int month) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.prob = prob;
        this.phone = phone;
        this.day = day;
        this.month = month;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getProb() {
        return prob;
    }

    public void setProb(String prob) {
        this.prob = prob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    int day;
    int month;
}
