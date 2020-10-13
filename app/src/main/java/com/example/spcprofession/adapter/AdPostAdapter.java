package com.example.spcprofession.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.spcprofession.R;
import com.example.spcprofession.applyPost.HireProfessional;
import com.example.spcprofession.models.Post;

import java.util.List;

public class AdPostAdapter extends RecyclerView.Adapter<AdPostAdapter.ViewHolder> {

    List<Post> posts;
    LayoutInflater inflater;
    Context context;

    public AdPostAdapter(Context ctx,List<Post> posts) {
        this.context=ctx;
        this.posts = posts;
        this.inflater = LayoutInflater.from(ctx);
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.post_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        holder.name.setText(posts.get(position).getName());
        holder.profession.setText(posts.get(position).getName()+" - "+posts.get(position).getProf());
        holder.area.setText("Preferred Area: "+posts.get(position).getArea());
        holder.description.setText("Description: "+posts.get(position).getDes());
        holder.bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, HireProfessional.class);
                intent.putExtra("NAME", posts.get(position).getName());
                intent.putExtra("PROF", posts.get(position).getProf());
                intent.putExtra("AREA", posts.get(position).getArea());
                intent.putExtra("DES", posts.get(position).getDes());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                Toast.makeText(context, "Clicked -> " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView profession;
        TextView area;
        Button bt;
        TextView description;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.NAME_LIST);
            profession= itemView.findViewById(R.id.PROFESSION_LIST);
            area= itemView.findViewById(R.id.AREA_LIST);
            description= itemView.findViewById(R.id.DES_LIST);
             bt=itemView.findViewById(R.id.button);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Clicked ", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}