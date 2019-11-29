package com.example.responsiblecooking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.responsiblecooking.data.models.Recipe;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);
        ButterKnife.bind(this); //Configure Butterknife

        getSupportActionBar().hide();

        addRecipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddRecipe(recipeTitle.getText().toString(), recipeIngredients.getText().toString(), recipeText.getText().toString());
            }
        });
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

    public void AddRecipe(String recipeTitle, String recipeIngredient, String recipeText) {
        FirebaseFirestore db;
        db = FirebaseFirestore.getInstance();

        Map<String, Object> newRecipe = new HashMap<>();
        newRecipe.put("recipeTitle", recipeTitle);
        newRecipe.put("recipeIngredient", recipeIngredient);
        newRecipe.put("recipeText", recipeText);

        db.collection("recipes").document("1")
                .set(newRecipe)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Intent intent = new Intent(AddRecipeActivity.this, MainActivity.class);
                        startActivity(intent);
                        //Toast.makeText(MainActivity.class, "Added new recipe", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("ERROR", e.getMessage());
                    }
                });
    }
}
