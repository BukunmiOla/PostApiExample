package com.example.postapiexample.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.postapiexample.MainActivity;
import com.example.postapiexample.R;
import com.example.postapiexample.model.DetailResponse;
import com.example.postapiexample.network.ClientInstance;
import com.example.postapiexample.network.DataService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetDataActivity extends AppCompatActivity {
    RecyclerView displayRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data);

        displayRv = findViewById(R.id.recyclerView);
        showNames();
    }

    private void showNames() {
        DataService service =
                ClientInstance.getClientInstance()
                        .create(DataService.class);

        Call<List<DetailResponse>> call = service.getDetails();
        call.enqueue(new Callback<List<DetailResponse>>() {
            @Override
            public void onResponse(Call<List<DetailResponse>> call, Response<List<DetailResponse>> response) {
                Toast.makeText(GetDataActivity.this, "Connected", Toast.LENGTH_SHORT);
                DetailAdapter adapter = new DetailAdapter(response.body());
                displayRv.setLayoutManager(new LinearLayoutManager(GetDataActivity.this));
                displayRv.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<DetailResponse>> call, Throwable t) {
                Toast.makeText(GetDataActivity.this, "Something went wrong...", Toast.LENGTH_SHORT);

            }
        });
    }
}