package com.example.spcprofession.ui.showPosts;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.spcprofession.R;
import com.example.spcprofession.adapter.AdPostAdapter;
import com.example.spcprofession.models.Post;
import com.example.spcprofession.ui.showPost.ShowPost;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;

public class ShowEngineer extends AppCompatActivity {
    ArrayList<Post> posts=new ArrayList<>();
    AdPostAdapter adPostAdapter;
    RecyclerView recyclerView;
    private String TAG="GG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_engineer);
        recyclerView=findViewById(R.id.post_recycler);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Posts").whereEqualTo("Prof","Architect Engineer")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                Post tempPost = new Post();
                                tempPost.setArea(document.getData().get("Area").toString());
                                tempPost.setDes(document.getData().get("Des").toString());
                                tempPost.setName(document.getData().get("Name").toString());
                                tempPost.setProf(document.getData().get("Prof").toString());
                                posts.add(tempPost);

                            }

                            adPostAdapter = new AdPostAdapter(getApplicationContext(),posts);
                            GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),1);
                            recyclerView.setLayoutManager(gridLayoutManager);
                            recyclerView.setAdapter(adPostAdapter);
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });



    }
}