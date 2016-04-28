package com.symptom_checker.team.symptom_checker;

/**
 * Created by Richard on 27/04/2016.
 */
public class LoginDetails {
    private int ID;
    private String firstname;
    private String lastname;
    private String dob;
    private String email;
    private String password;
    private String nhsnumber;

    private String username;

    public LoginDetails(int ID, String firstname, String lastname,
                           String dob, String email, String password,
                           String nhsnumber)
    {
        this.ID = ID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.email = email;
        this.password = password;
        this.nhsnumber = nhsnumber;

        this.username = this.firstname + this.lastname;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getNhsNumber() {
        return nhsnumber;
    }

    public void setNhsNumber(String nhsNumber) {
        this.nhsnumber = nhsnumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
