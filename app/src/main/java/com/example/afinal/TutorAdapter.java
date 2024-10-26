package com.example.afinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TutorAdapter extends RecyclerView.Adapter<TutorAdapter.TutorViewHolder> {
    private List<Tutor> tutorsList;

    public TutorAdapter(List<Tutor> tutorsList){
        this.tutorsList = tutorsList;
    }

    @NonNull
    @Override
    public TutorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tutor_card, parent, false);
        return new TutorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TutorViewHolder holder, int position){
        Tutor tutor = tutorsList.get(position);
        holder.tutorName.setText(tutor.getName());
        holder.tutorJobTitle.setText(tutor.getJobTitle());
        holder.tutorDescription.setText(tutor.getDescription());

        holder.profileImage.setImageResource(R.drawable.profile_picture);
    }

    @Override
    public int getItemCount(){
        return tutorsList.size();
    }
    public static class TutorViewHolder extends RecyclerView.ViewHolder{
        ImageView profileImage;
        TextView tutorName, tutorJobTitle, tutorDescription;

        public TutorViewHolder(@NonNull View itemView){
            super(itemView);
            profileImage = itemView.findViewById(R.id.tutor_profile);
            tutorName = itemView.findViewById(R.id.tutor_name_card);
            tutorJobTitle = itemView.findViewById(R.id.tutor_job_title_card);
            tutorDescription = itemView.findViewById(R.id.tutor_description_card);
        }
    }
}
