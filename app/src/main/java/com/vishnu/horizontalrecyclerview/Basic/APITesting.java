package com.vishnu.horizontalrecyclerview.Basic;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.vishnu.horizontalrecyclerview.APIInterface;
import com.vishnu.horizontalrecyclerview.R;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class APITesting extends AppCompatActivity {

    Spinner spinner;
    TextView tv;
    String URL="https://hub.dummyapis.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apitesting);
        tv=findViewById(R.id.user);
        spinner=findViewById(R.id.spinner);
        tv.setText(" ");

        List<Modulaclass> user=new ArrayList<>();
        ArrayAdapter<Modulaclass> adapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,user);
/////Spineer Selected

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String country=   spinner.getItemAtPosition(spinner.getSelectedItemPosition()).toString();
                Toast.makeText(getApplicationContext(),country,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // DO Nothing here
            }
        });


        /////Geting data from API
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIInterface apiInterface=retrofit.create(APIInterface.class);

        Call<List<Modulaclass>> call=apiInterface.getDetaile();
        call.enqueue(new Callback<List<Modulaclass>>() {
            @Override
            public void onResponse(@NonNull Call<List<Modulaclass>> call, @NonNull Response<List<Modulaclass>> response) {
                List<Modulaclass> list=response.body();
                if(response.isSuccessful()) {
                    for (int i = 0; i < list.size(); i++) {
                        tv.append("Name:-" + list.get(i).getFirstName()+" "+ list.get(i).getLastName() + "\nSalary:-" + list.get(i).getSalary()
                                + "\nEmail:-" + list.get(i).getEmail()+"\n\n");
                    }
                }
                if(response.isSuccessful()){

                    for(Modulaclass post:response.body()){

                        String name=post.getFirstName();
                        Modulaclass modulaclass=new Modulaclass(name);
                        user.add(modulaclass);
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner.setAdapter(adapter);

                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Modulaclass>> call, Throwable t) {

            }
        });
    }
}