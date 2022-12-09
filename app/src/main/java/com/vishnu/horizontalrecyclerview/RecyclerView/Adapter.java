package com.vishnu.horizontalrecyclerview.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vishnu.horizontalrecyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    List<Class> classArrayList;

    public Adapter(List<Class> classArrayList) {
        this.classArrayList = classArrayList;
    }

    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.signl,null);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder holder, int position) {
        holder.name.setText(classArrayList.get(position).getFirstName());
        holder.email.setText(classArrayList.get(position).getEmail());
        holder.phone.setText(classArrayList.get(position).getContactNumber());
    }

    @Override
    public int getItemCount() {
        return classArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,email,phone;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.first);
            email=itemView.findViewById(R.id.second);
            phone=itemView.findViewById(R.id.third);
        }
    }
}
