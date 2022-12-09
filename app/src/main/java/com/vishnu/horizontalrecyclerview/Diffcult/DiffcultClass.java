package com.vishnu.horizontalrecyclerview.Diffcult;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.vishnu.horizontalrecyclerview.APIInterface;
import com.vishnu.horizontalrecyclerview.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DiffcultClass extends AppCompatActivity {

    RecyclerView recyclerView;
    DiffcultAdapter diffcultAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diffcult_class);
        recyclerView=findViewById(R.id.diffcult);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        InIt();
    }

    private void InIt() {
        Retrofit retrofit=new Retrofit
                .Builder()
                .baseUrl("http://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIInterface api=retrofit.create(APIInterface.class);

        Call<Diffcult> call=api.getLoad();

       call.enqueue(new Callback<Diffcult>() {
           @Override
           public void onResponse(Call<Diffcult> call, Response<Diffcult> response) {
               if(response.isSuccessful()){
                   diffcultAdapter=new DiffcultAdapter((List<Diffcult>) response.body());
                   recyclerView.setAdapter(diffcultAdapter);
               }
           }

           @Override
           public void onFailure(Call<Diffcult> call, Throwable t) {

           }
       });
    }
}