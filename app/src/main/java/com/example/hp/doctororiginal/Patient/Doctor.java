package com.example.hp.doctororiginal.Patient;

/**
 * Created by HP on 13-04-2018.
 */

public class Doctor {
   String name;
   String Lname;
   String email;
   int pass;
   int num;
   public String toString()
   {
       return name+Lname+email+pass+num;
   }

    public Doctor(String name, String lname, String email, int pass, int num) {
        this.name = name;
        Lname = lname;
        this.email = email;
        this.pass = pass;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
