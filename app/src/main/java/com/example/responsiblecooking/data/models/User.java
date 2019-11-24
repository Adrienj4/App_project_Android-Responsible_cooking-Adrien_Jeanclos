package com.example.responsiblecooking.data.models;

import androidx.annotation.Nullable;

/**
 * Created by <Adrien JEANCLOS> on <DATE-DU-JOUR>.
 */
public class User {

    private String userId;
    private String userName;
    @Nullable
    private String urlPicture;

    public User() { }

    public User(String userId, String userName, String urlPicture) {
        this.userId = userId;
        this.userName = userName;
        this.urlPicture = urlPicture;
    }

    // -- GETTERS --
    public String getUserId() {
        return userId;
    }
    public String getUserName() {
        return userName;
    }
    @Nullable
    public String getUrlPicture() {
        return urlPicture;
    }

    // -- SETTERS --
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setUrlPicture(@Nullable String urlPicture) {
        this.urlPicture = urlPicture;
    }
}
