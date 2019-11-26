package com.example.responsiblecooking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import butterknife.BindView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.responsiblecooking.data.models.Recipe;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;

public class AddRecipeActivity extends AppCompatActivity {

    // FOR DESIGN
    @BindView(R.id.buttonAdd)
    Button addRecipeButton;
    @BindView(R.id.editTextNameRecipe)
    EditText recipeTitle;
    @BindView(R.id.editTextIngredients)
    EditText recipeIngredients;
    @BindView(R.id.editTextRecipe)
    EditText recipeText;

    private DatabaseReference databaseReference;
    private List<Recipe> allRecipes;

    private LinearLayoutManager linearLayoutManager;
    private RecyclerViewAdapter recyclerViewAdapter;

    private String enterRecipeTitle;
    private String enterRecipeIngredient;
    private String enterRecipeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);
        /*
        allRecipes = new ArrayList<Recipe>();
        addRecipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterRecipeTitle = recipeTitle.getText().toString();
                enterRecipeIngredient = recipeIngredients.getText().toString();
                enterRecipeText = recipeText.getText().toString();
                if(TextUtils.isEmpty(enterRecipeTitle)
                        || TextUtils.isEmpty(enterRecipeIngredient)
                        || TextUtils.isEmpty(enterRecipeText)){
                    Toast.makeText(AddRecipeActivity.this, "You must fill all the fields", Toast.LENGTH_LONG).show();
                    return;
                }
                Recipe recipeObject = new Recipe(enterRecipeTitle, enterRecipeIngredient, enterRecipeText);
                databaseReference.push().setValue(recipeObject);
                recipeTitle.setText("");
                recipeIngredients.setText("");
                recipeText.setText("");
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                getAllRecipes(dataSnapshot);
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

         */
    }

    private void getAllRecipes(DataSnapshot dataSnapshot){
        for(DataSnapshot singleSnapshot : dataSnapshot.getChildren()){
            String enterRecipeTitle = singleSnapshot.getValue(String.class);
            String enterRecipeIngredient = singleSnapshot.getValue(String.class);
            String enterRecipeText = singleSnapshot.getValue(String.class);
            allRecipes.add(new Recipe(enterRecipeTitle, enterRecipeIngredient, enterRecipeText));
        }
    }
}
