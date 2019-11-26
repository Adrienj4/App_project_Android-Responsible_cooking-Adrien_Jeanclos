package com.example.responsiblecooking.data.models;

import java.util.Date;

/**
 * Created by <Adrien JEANCLOS> on <DATE-DU-JOUR>.
 */

public class Recipe {

    private String recipeTitle;
    private String ingredients;
    private String recipe;
    private Date dateAdded;
    private Users userSender;
    private String urlImage;

    public Recipe() {}

    public Recipe(String recipeTitle) {
        this.recipeTitle = recipeTitle;
    }

    public Recipe(String recipeTitle, String ingredients, String recipe) {
        this.recipeTitle = recipeTitle;
        this.ingredients = ingredients;
        this.recipe = recipe;
    }

    public Recipe(String recipeTitle, String ingredients, String recipe, Users userSender) {
        this.recipeTitle = recipeTitle;
        this.ingredients = ingredients;
        this.recipe = recipe;
        this.userSender = userSender;
    }

    // -- GETTERS --

    public String getRecipeTitle() {
        return recipeTitle;
    }
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
    public Users getUserSender() {
        return userSender;
    }
    public void getUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    // -- SETTERS --

    public void setRecipeTitle(String recipeTitle) {
        this.recipeTitle = recipeTitle;
    }
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }
    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }
    public void setUserSender(Users userSender) {
        this.userSender = userSender;
    }
    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
