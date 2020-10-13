package com.example.spcprofession.ui.addProfession;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SaveData {
    Context context;

    private String TAG="ERROR";

    public void savePost(final Context context, String name, String profession, String description, String s)
    {
        final Context mcontext=context;
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, String> user = new HashMap<>();
        user.put("Name",name);
        user.put("Prof", profession);

        user.put("Des",description);
        user.put("Area",s);

// Add a new document with a generated ID
        db.collection("Posts")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(mcontext, "Successfully posted", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
    }
}
