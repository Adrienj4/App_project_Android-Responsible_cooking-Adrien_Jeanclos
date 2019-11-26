package com.example.responsiblecooking.data.models;

import androidx.annotation.Nullable;

/**
 * Created by <Adrien JEANCLOS> on <DATE-DU-JOUR>.
 */
public class Users {

    private String userId;
    private String username;
    private String userEmail;
    private String password;
    @Nullable private String urlPicture;

    public Users() { }

    public Users(String userId, String username, String urlPicture, String userEmail, String password) {
        this.userId = userId;
        this.username = username;
        this.userEmail = userEmail;
        this.password = password;
        this.urlPicture = urlPicture;
    }

    // -- GETTERS --
    public String getUserId() {
        return userId;
    }
    public String getUsername() {
        return username;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public String getPassword() {
        return password;
    }
    public String getUrlPicture() {
        return urlPicture;
    }

    // -- SETTERS --
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setUsername(String userName) {
        this.username = username;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUrlPicture(String urlPicture) {
        this.urlPicture = urlPicture;
    }
}
