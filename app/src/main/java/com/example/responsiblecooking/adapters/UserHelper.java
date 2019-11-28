package com.example.responsiblecooking.adapters;

import com.example.responsiblecooking.data.models.User;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * Created by <Adrien JEANCLOS> on <DATE-DU-JOUR>.
 */

public class UserHelper {

    private static final String COLLECTION_NAME = "users";

    // --- COLLECTION REFERENCE ---

    public static CollectionReference getUsersCollection(){
        return FirebaseFirestore.getInstance().collection(COLLECTION_NAME);
    }

    // --- CREATE ---

    public static Task<Void> createUser(String uId, String uName/*, String uEmail, String uPassword*/) {
        User userToCreate = new User(uId, uName/*, uEmail, uPassword*/);
        return UserHelper.getUsersCollection().document(uId).set(userToCreate);
    }

    // --- GET ---

    public static Task<DocumentSnapshot> getUser(String uid){
        return UserHelper.getUsersCollection().document(uid).get();
    }

    // --- UPDATE ---

    public static Task<Void> updateUserName(String userName, String uid) {
        return UserHelper.getUsersCollection().document(uid).update("userName", userName);
    }

    public static Task<Void> updateUserEmail(String userEmail, String uid) {
        return UserHelper.getUsersCollection().document(uid).update("userEmail", userEmail);
    }

    public static Task<Void> updateUserPassword(String userPassword, String uid) {
        return UserHelper.getUsersCollection().document(uid).update("userPassword", userPassword);
    }

    // --- DELETE ---

    public static Task<Void> deleteUser(String uid) {
        return UserHelper.getUsersCollection().document(uid).delete();
    }

}
