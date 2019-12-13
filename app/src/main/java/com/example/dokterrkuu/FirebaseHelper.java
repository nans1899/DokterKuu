package com.example.dokterrkuu;

import com.google.firebase.database.DatabaseReference;

public class FirebaseHelper {
    DatabaseReference db;
    Boolean saved=null;

    public FirebaseHelper(DatabaseReference db) {
        this.db = db;
    }


    //SAVE DATA
    public Boolean save(DocData docData){

        return true;
    }
}
