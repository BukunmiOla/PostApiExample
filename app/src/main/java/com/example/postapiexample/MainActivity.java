 package com.example.postapiexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.postapiexample.model.DetailRequest;
import com.example.postapiexample.model.DetailResponse;
import com.example.postapiexample.network.ClientInstance;
import com.example.postapiexample.network.DataService;
import com.example.postapiexample.ui.DetailAdapter;
import com.example.postapiexample.ui.GetDataActivity;
import com.example.postapiexample.ui.PostDataActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

 public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        findViewById(R.id.get_data_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GetDataActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.post_data_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PostDataActivity.class);
                startActivity(intent);
            }
        });
    }
 }