package com.vishnu.horizontalrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.vishnu.horizontalrecyclerview.Basic.APITesting;
import com.vishnu.horizontalrecyclerview.Basic.Modulaclass;
import com.vishnu.horizontalrecyclerview.CyclerView.Cycler;
import com.vishnu.horizontalrecyclerview.CyclerView.CyclerAdapter;
import com.vishnu.horizontalrecyclerview.Diffcult.DiffcultClass;
import com.vishnu.horizontalrecyclerview.RecyclerView.RecycleWithRetrofit;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    Button next,send,recyer,recyer2,diffcultModel;
    Button login;
    final String URL="https://hub.dummyapis.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        next=findViewById(R.id.button);
        send=findViewById(R.id.button2);
        login=findViewById(R.id.button4);
        recyer=findViewById(R.id.button5);
        recyer2=findViewById(R.id.button6);
        diffcultModel=findViewById(R.id.button7);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), APITesting.class);
                startActivity(intent);

            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SendDataToServer();

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), LoginPage.class);
                startActivity(intent);

            }
        });
        recyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), RecycleWithRetrofit.class);
                startActivity(intent);

            }
        });
        recyer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), Cycler.class);
                startActivity(intent);

            }
        });
        diffcultModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), DiffcultClass.class);
                startActivity(intent);

            }
        });


    }



    ////Sending to data to Server
    private void SendDataToServer() {
        APIInterface apiInterface=RetrofitClient.getRetrofit().create(APIInterface.class);
        Call<UserClass> call=apiInterface.Putdata("Vishnu","Android Developer");
        call.enqueue(new Callback<UserClass>() {
            @Override
            public void onResponse(Call<UserClass> call, Response<UserClass> response) {
                Log.e("Tag1","onResponse:="+response.code());
                Log.e("Tag2","onResponse:name:= "+response.body().getName());
                Log.e("Tag3","onResponse:job:= "+response.body().getJob());
                Log.e("Tag4","onResponse:Create At:= "+response.body().getCreatedAt());


            }

            @Override
            public void onFailure(Call<UserClass> call, Throwable t) {
                Log.e("Faile","onResponse:"+t.getMessage());
            }
        });
    }


}



