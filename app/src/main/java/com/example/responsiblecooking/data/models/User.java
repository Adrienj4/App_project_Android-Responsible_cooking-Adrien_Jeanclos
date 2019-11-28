package com.example.responsiblecooking.data.models;

import java.util.ArrayList;

/**
 * Created by <Adrien JEANCLOS> on <DATE-DU-JOUR>.
 */
public class User {

    private String userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private ArrayList<String> allergy;

    public User() { }

    public User(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public User(String userId, String userName, String userEmail, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public User(String userId, String userName, String userEmail, String userPassword, ArrayList<String> allergy) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.allergy = allergy;
    }

    // -- GETTERS --
    public String getUserId() {
        return userId;
    }
    public String getUserName() {
        return userName;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public ArrayList<String> getAllergy() {
        return allergy;
    }

    // -- SETTERS --
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public void setAllergy(ArrayList<String> allergy) {
        this.allergy = allergy;
    }
}
