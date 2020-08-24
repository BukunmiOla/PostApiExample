 package com.example.postapiexample.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.postapiexample.R;
import com.example.postapiexample.model.NameResponse;
import com.example.postapiexample.network.ClientInstance;
import com.example.postapiexample.network.DataService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

 public class MainActivity extends AppCompatActivity {
     RecyclerView displayRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayRv = findViewById(R.id.recyclerView);
        showNames();
        
        findViewById(R.id.post_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postName();
            }
        });
    }

     private void postName() {
     }

     private void showNames() {
         DataService service =
                 ClientInstance.getClientInstance("http://hello2harvest.herokuapp.com")
                 .create(DataService.class);

         Call<List<NameResponse>> call = service.getNames();
         call.enqueue(new Callback<List<NameResponse>>() {
             @Override
             public void onResponse(Call<List<NameResponse>> call, Response<List<NameResponse>> response) {
                 Toast.makeText(MainActivity.this, "Connected", Toast.LENGTH_SHORT);
                 NameAdapter adapter = new NameAdapter(response.body());
                 displayRv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                 displayRv.setAdapter(adapter);
             }

             @Override
             public void onFailure(Call<List<NameResponse>> call, Throwable t) {
                 Toast.makeText(MainActivity.this, "Something went wrong...", Toast.LENGTH_SHORT);

             }
         });
     }
 }