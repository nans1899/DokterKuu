package com.example.dokterrkuu.RecyclerViewPackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dokterrkuu.R;

import java.util.ArrayList;

public class DatabaseRecyclerAdapter extends RecyclerView.Adapter<DatabaseRecyclerAdapter.DatabaseViewHolder> {

    ArrayList<ModelClass> objModelClassArrayList;

    public DatabaseRecyclerAdapter(ArrayList<ModelClass> objModelClassArrayList) {
        this.objModelClassArrayList = objModelClassArrayList;
    }

    @NonNull
    @Override
    public DatabaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View singleRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_row, viewGroup, false);
        return new DatabaseViewHolder(singleRow);
    }

    @Override
    public void onBindViewHolder(@NonNull DatabaseViewHolder holder, int position) {
        ModelClass objModelClass = objModelClassArrayList.get(position);
        holder.Name.setText(objModelClass.getName());
        holder.Date.setText(objModelClass.getName());
        holder.Disease.setText(objModelClass.getName());
        holder.docname.setText(objModelClass.getName());
        holder.hospital.setText(objModelClass.getName());
        holder.notes.setText(objModelClass.getName());
    }

    @Override
    public int getItemCount() {
        return objModelClassArrayList.size();
    }

    public static class DatabaseViewHolder extends RecyclerView.ViewHolder{
        TextView Name, Date, Disease, docname, hospital, notes;
        public DatabaseViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.viewName);
            Date = itemView.findViewById(R.id.viewDate);
            Disease = itemView.findViewById(R.id.viewDisease);
            docname = itemView.findViewById(R.id.viewDocName);
            hospital = itemView.findViewById(R.id.viewHospital);
            notes = itemView.findViewById(R.id.viewNotes);


        }
    }

}
