package com.vishnu.horizontalrecyclerview.Diffcult;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vishnu.horizontalrecyclerview.R;

import org.w3c.dom.Text;

import java.util.List;

public class DiffcultAdapter extends RecyclerView.Adapter<DiffcultAdapter.MyViewHolder> {

    List<Diffcult> list;

    public DiffcultAdapter(List<Diffcult> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public DiffcultAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.diffcult,null);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DiffcultAdapter.MyViewHolder holder, int position) {

        holder.name.setText(list.get(position).getName());
        holder.city.setText((CharSequence) list.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,city,companyname;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.Dfirst);
            city=itemView.findViewById(R.id.Dsecond);
            companyname=itemView.findViewById(R.id.Dthird);

        }
    }
}
