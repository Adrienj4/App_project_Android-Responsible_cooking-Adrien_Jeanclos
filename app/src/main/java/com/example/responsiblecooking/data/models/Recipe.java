package com.example.responsiblecooking.data.models;

import java.util.Date;

/**
 * Created by <Adrien JEANCLOS> on <DATE-DU-JOUR>.
 */

public class Recipe {

    private String recipeTitle;
    private String recipeIngredients;
    private String recipeSteps;

    public Recipe() {}

    public Recipe(String recipeTitle, String ingredients, String recipeSteps) {
        this.recipeTitle = recipeTitle;
        this.recipeIngredients = recipeIngredients;
        this.recipeSteps = recipeSteps;
    }

    // -- GETTERS --

    public String getRecipeTitle() {
        return recipeTitle;
    }
    public String getRecipeIngredients() {
        return recipeIngredients;
    }
    public String getRecipeSteps() {
        return recipeSteps;
    }

    // -- SETTERS --

    public void setRecipeTitle(String recipeTitle) {
        this.recipeTitle = recipeTitle;
    }
    public void setRecipeIngredients(String recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }
    public void setRecipeSteps(String recipeSteps) {
        this.recipeSteps = recipeSteps;
    }
}
