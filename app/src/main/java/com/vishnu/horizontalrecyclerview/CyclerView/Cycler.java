package com.vishnu.horizontalrecyclerview.CyclerView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.vishnu.horizontalrecyclerview.APIInterface;
import com.vishnu.horizontalrecyclerview.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Cycler extends AppCompatActivity {

    RecyclerView recyclerView;
    CyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cycler);
        recyclerView=findViewById(R.id.recyclerVIEWview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        LoadIt();
    }

    private void LoadIt() {
        Retrofit retrofit=new Retrofit
                .Builder()
                .baseUrl("http://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIInterface apiInterface=retrofit.create(APIInterface.class);

        Call<List<Class3>> call=apiInterface.Load();
        call.enqueue(new Callback<List<Class3>>() {
            @Override
            public void onResponse(@NonNull Call<List<Class3>> call, @NonNull Response<List<Class3>> response) {
                if(response.isSuccessful()){
                    adapter=new CyclerAdapter(response.body());
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Class3>> call, @NonNull Throwable t) {
                Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}