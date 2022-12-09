package com.vishnu.horizontalrecyclerview.RecyclerView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.GsonBuilder;
import com.vishnu.horizontalrecyclerview.APIInterface;
import com.vishnu.horizontalrecyclerview.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecycleWithRetrofit extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_with_retrofit);
        recyclerView=findViewById(R.id.recyclerVIEW);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        LoadJson();

    }

    private void LoadJson() {
        Retrofit retrofit=new Retrofit
                .Builder()
                .baseUrl("https://hub.dummyapis.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIInterface apiInterface=retrofit.create(APIInterface.class);

       Call<List<Class>> call=apiInterface.LoadFromAPi();
       call.enqueue(new Callback<List<Class>>() {
           @Override
           public void onResponse(Call<List<Class>> call, Response<List<Class>> response) {
               if(response.isSuccessful()){
                   adapter=new Adapter(response.body());
                   recyclerView.setAdapter(adapter);
               }
           }

           @Override
           public void onFailure(Call<List<Class>> call, Throwable t) {
               Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
           }
       });
    }
}
