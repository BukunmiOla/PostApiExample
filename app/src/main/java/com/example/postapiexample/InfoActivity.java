package com.example.postapiexample;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.postapiexample.model.DetailResponse;
import com.example.postapiexample.network.ClientInstance;
import com.example.postapiexample.network.DataService;
import com.example.postapiexample.ui.GetDataActivity;

import java.util.zip.InflaterOutputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent getInfo = getIntent();
        String id = getInfo.getExtras().getString("id");

        String name = getInfo.getExtras().getString("name");
        String address = getInfo.getExtras().getString("address");
        String email = getInfo.getExtras().getString("email");
        String phone = getInfo.getExtras().getString("phone");
        String gender = getInfo.getExtras().getString("gender");

        TextView detailTv = findViewById(R.id.detail_tv);
        TextView nameTv = findViewById(R.id.name_tv);
        nameTv.setText(name);
        String detail = "id: " + id +"\nAddress: " + address +
                "\nEmail: " + email +
                "\nPhone number: " + phone +
                "\nGender: " + gender;

        detailTv.setText(detail);

        DataService service =
                ClientInstance.getClientInstance()
                        .create(DataService.class);

        Call<DetailResponse> call = service.getById(id);
        call.enqueue(new Callback<DetailResponse>() {
            @Override
            public void onResponse(Call<DetailResponse> call, Response<DetailResponse> response) {
                Toast.makeText(InfoActivity.this, "Connected", Toast.LENGTH_SHORT);
                if (response.body() != null)
                generateData(response.body());
            }

            @Override
            public void onFailure(Call<DetailResponse> call, Throwable t) {
                Toast.makeText(InfoActivity.this, "Something went wrong...", Toast.LENGTH_SHORT);

            }
        });
    }

    private void generateData(DetailResponse body) {
        TextView detailTv = findViewById(R.id.detail_tv);
        TextView nameTv = findViewById(R.id.name_tv);
        nameTv.setText(body.getName());
        String detail = "id: " + body.getId() +"Address: " + body.getAddress() +
                "\nEmail: " + body.getEmail() +
                "\nPhone number: " + body.getPhoneNumber() +
                "\nGender: " + body.getGender();

        detailTv.setText(detail);
    }
}