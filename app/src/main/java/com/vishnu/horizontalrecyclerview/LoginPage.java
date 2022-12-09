package com.vishnu.horizontalrecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginPage extends AppCompatActivity {

    TextInputEditText phoneTxt,passwordTxt;
    TextView tv;
    ProgressDialog pd;
    TextView signIn,Admin,Register;
    APIInterface apiinterface;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        phoneTxt=findViewById(R.id.phone);
        passwordTxt=findViewById(R.id.password);
        signIn=findViewById(R.id.signIN);
        Admin=findViewById(R.id.AdminGo);
        Register=findViewById(R.id.signUp);
        tv=findViewById(R.id.info);
        tv.setVisibility(View.INVISIBLE);
        Admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Admin", Toast.LENGTH_SHORT).show();
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Register", Toast.LENGTH_SHORT).show();
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setVisibility(View.INVISIBLE);
                if(phoneTxt.getText().toString().isEmpty() || passwordTxt.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please Enter Details", Toast.LENGTH_SHORT).show();
                }
                else{
//                    Toast.makeText(getApplicationContext(), "Login Sucessfully....", Toast.LENGTH_SHORT).show();
                    tv.setText(" ");
                    getUserLoginCheck();

                }
            }
        });
    }

    private void getUserLoginCheck() {

        apiinterface=RetrofitClient2.getRetrofit().create(APIInterface.class);
        Call<Root> call=apiinterface.getLogin(phoneTxt.getText().toString(),passwordTxt.getText().toString(),"1265abb5-1965-47ec-8688-6b789743e4f6") ;
        Log.e("OnResponse",call.toString());
        call.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(@NonNull Call<Root> call, @NonNull Response<Root> response) {
                Root cs = response.body();
                tv.setVisibility(View.VISIBLE);
                tv.append("Name:"+cs.getData().getUserDetail().getName()+"\n Email:-"+cs.getData().getUserDetail().getEmail()+
                        "\n Phone:-"+cs.getData().getUserDetail().getPhone());

            }

            @Override
            public void onFailure(@NonNull Call<Root> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
//
    }
}