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
import com.google.firebase.firestore.DocumentReference;
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
    EditText recipeSteps;

    private DatabaseReference databaseReference;
    private List<Recipe> allRecipes;

    private LinearLayoutManager linearLayoutManager;
    private RecyclerViewAdapter recyclerViewAdapter;

    private String enterRecipeTitle;
    private String enterRecipeIngredient;
    private String enterRecipeSteps;

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
                //AddRecipe(recipeTitle.getText().toString(), recipeIngredients.getText().toString(), recipeSteps.getText().toString());
                Map<String, Object> newRecipe = new HashMap<>();
                newRecipe.put("recipeTitle", recipeTitle);
                newRecipe.put("recipeIngredients", recipeIngredients);
                newRecipe.put("recipeSteps", recipeSteps);

                db.collection("recipes")
                        .add(newRecipe)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Intent intent = new Intent(AddRecipeActivity.this, MainActivity.class);
                                startActivity(intent);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                //Log.d("ERROR", e.getMessage());
                                Toast.makeText(AddRecipeActivity.this, "Error adding recipe", Toast.LENGTH_LONG).show();
                            }
                        });
            }
        });
    }
}
