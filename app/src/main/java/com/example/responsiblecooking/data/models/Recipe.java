package com.example.responsiblecooking.data.models;

import java.util.Date;

/**
 * Created by <Adrien JEANCLOS> on <DATE-DU-JOUR>.
 */

public class Recipe {

    private String ingredients;
    private String recipe;
    private Date dateAdded;
    private User userSender;
    private String urlImage;

    public Recipe() {}

    public Recipe(String ingredients, String recipe, User userSender) {
        this.ingredients = ingredients;
        this.recipe = recipe;
        this.userSender = userSender;
    }

    // -- GETTERS --

    public String getIngredients() {
        return ingredients;
    }
    public String getRecipe() {
        return recipe;
    }
    //@SeverTimestamp
    public Date getDateAdded() {
        return dateAdded;
    }
    public User getUserSender() {
        return userSender;
    }
    public void getUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    // -- SETTERS --

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }
    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }
    //public void setUserSender(User userSender) {
    //    this.userSender = userSender;
    //}
    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
