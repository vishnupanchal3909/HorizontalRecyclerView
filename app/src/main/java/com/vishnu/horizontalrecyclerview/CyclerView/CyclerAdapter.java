package com.vishnu.horizontalrecyclerview.CyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import com.vishnu.horizontalrecyclerview.R;
import java.util.List;

public class CyclerAdapter extends RecyclerView.Adapter<CyclerAdapter.MyViewHolder> {

    List<Class3> list;
    public CyclerAdapter(List<Class3> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public CyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler2,null);
      return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CyclerAdapter.MyViewHolder holder, int position) {
//
       holder.id.setText(String.valueOf(list.get(position).getId()));
        holder.aldumid.setText(String.valueOf(list.get(position).getAlbumId()));
        holder.tittle.setText(list.get(position).getTitle());
        Picasso.get()
                .load(list.get(position).getUrl())
                .fit()
                .into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), String.valueOf(list.get(position).getId()), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView id,aldumid,tittle;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageR);
            id=itemView.findViewById(R.id.idR);
            aldumid=itemView.findViewById(R.id.nameR);
            tittle=itemView.findViewById(R.id.salaryR);

        }
    }
}
