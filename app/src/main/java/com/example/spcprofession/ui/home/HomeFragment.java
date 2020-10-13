package com.example.spcprofession.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spcprofession.R;
import com.example.spcprofession.adapter.AdPostAdapter;
import com.example.spcprofession.adapter.AdPostAdapterDoctor;
import com.example.spcprofession.models.Post;
import com.example.spcprofession.ui.addProfession.AddProfession;
import com.example.spcprofession.ui.showPost.ShowPost;
import com.example.spcprofession.ui.showPosts.ShowDataAnalyst;
import com.example.spcprofession.ui.showPosts.ShowDoctorProfile;
import com.example.spcprofession.ui.showPosts.ShowEngineer;
import com.example.spcprofession.ui.showPosts.ShowLawyer;
import com.example.spcprofession.ui.showPosts.ShowPosts;
import com.example.spcprofession.ui.showPosts.ShowService;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference citiesRef = db.collection("Posts");
//    AdPostAdapterDoctor adPostAdapterDoctor;
//    ArrayList<Post> posts=new ArrayList<>();
//    RecyclerView recyclerView;
    TextView numberDoctor,numberProgrammer,numberDatalyst,numberService,numberEngineer,numberLawyer;
    // Create a query against the collection.
    Query query = citiesRef.whereEqualTo("Prof", "Doctor");
    private HomeViewModel homeViewModel;
    private LinearLayout linearLayout;
    int a=0,b=0,c=0,d=0,e=0,f=0;
    private CardView cardView,DOCTOR,ENGINEER,PROGRAMMER,LAWYER,DATALYST,SERVICE;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        linearLayout=root.findViewById(R.id.PROFFESION_LAYOUT);
        numberDoctor=root.findViewById(R.id.doctor_number);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        numberDatalyst=root.findViewById(R.id.text_datalyst);
        numberEngineer=root.findViewById(R.id.text_engineer);
        numberLawyer=root.findViewById(R.id.text_lawyer);
        numberProgrammer=root.findViewById(R.id.text_programmer);
        numberService=root.findViewById(R.id.text_service);
        db.collection("Posts").whereEqualTo("Prof","Doctor")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                  a++;


                            }
                            numberDoctor.setText(String.valueOf(a));

                        } else {
                        }
                    }
                });
        db.collection("Posts").whereEqualTo("Prof","Architect Engineer")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                b++;


                            }
                            numberEngineer.setText(String.valueOf(b));

                        } else {
                        }
                    }
                });

        db.collection("Posts").whereEqualTo("Prof","Data Analyst")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                c++;


                            }
                            numberDatalyst.setText(String.valueOf(c));

                        } else {
                        }
                    }
                });

               db.collection("Posts").whereEqualTo("Prof","Service")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                d++;


                            }
                            numberService.setText(String.valueOf(d));

                        } else {
                        }
                    }
                });

        db.collection("Posts").whereEqualTo("Prof","Programmer")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                e++;


                            }
                            numberProgrammer.setText(String.valueOf(e));

                        } else {
                        }
                    }
                });

        db.collection("Posts").whereEqualTo("Prof","Lawyer")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                f++;


                            }
                            numberLawyer.setText(String.valueOf(f));

                        } else {
                        }
                    }
                });

        DOCTOR=root.findViewById(R.id.card_doctor);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), AddProfession.class));
            }
        });
        DOCTOR=root.findViewById(R.id.card_doctor);
        DOCTOR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             startActivity(new Intent(getActivity(), ShowPosts.class));
            }
        });
        PROGRAMMER=root.findViewById(R.id.card_programmer);
        PROGRAMMER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),ShowDoctorProfile.class));
            }
        });
//        cardView=root.findViewById(R.id.show_professions);
        LAWYER=root.findViewById(R.id.card_lawyer);
        LAWYER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ShowLawyer.class));
            }
        });
        DATALYST=root.findViewById(R.id.card_dataentry);
        DATALYST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ShowDataAnalyst.class));
            }
        });
        ENGINEER=root.findViewById(R.id.card_engineer);
        ENGINEER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ShowEngineer.class));
            }
        });
        SERVICE=root.findViewById(R.id.card_service);
        SERVICE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ShowService.class));
            }
        });
        return root;
    }
}