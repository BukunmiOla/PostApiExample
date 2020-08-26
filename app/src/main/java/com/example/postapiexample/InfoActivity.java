package com.example.postapiexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.postapiexample.model.DetailRequest;
import com.example.postapiexample.model.DetailResponse;
import com.example.postapiexample.network.ClientInstance;
import com.example.postapiexample.network.DataService;
import com.example.postapiexample.ui.GetDataActivity;

import java.util.List;
import java.util.zip.InflaterOutputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InfoActivity extends AppCompatActivity {
    EditText nameEt, phoneEt, addressEt, mailEt;
    Spinner genderSp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent getInfo = getIntent();
        String id = getInfo.getExtras().getString("id");

        getData(id);

        findViewById(R.id.update_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateData(id);
            }
        });

    }

    private void updateData(String id) {

        DataService service =
                ClientInstance.getClientInstance()
                        .create(DataService.class);

        DetailRequest detailRequest = createEntry();

        Call<DetailResponse> call = service.updateById(id,detailRequest);

        call.enqueue(new Callback<DetailResponse>() {
            @Override
            public void onResponse(Call<DetailResponse> call, Response<DetailResponse> response) {
                Toast.makeText(InfoActivity.this, "Connected", Toast.LENGTH_SHORT);


            }

            @Override
            public void onFailure(Call<DetailResponse> call, Throwable t) {
                Toast.makeText(InfoActivity.this, "Something went wrong...", Toast.LENGTH_SHORT);

            }
        });
    }

    private void getData(String id) {
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
        nameEt = findViewById(R.id.name_et);
        addressEt = findViewById(R.id.address_et);
        mailEt = findViewById(R.id.email_et);
        phoneEt = findViewById(R.id.phone_et);
        genderSp = findViewById(R.id.gender_sp);

        nameEt.setText(body.getName());
        addressEt.setText(body.getAddress());
        mailEt.setText(body.getEmail());
        phoneEt.setText(body.getPhoneNumber());
        switch (body.getGender()){
            case ("Male"): {
                genderSp.setSelection(2);
                break;
            }
            case ("Female"):{
                genderSp.setSelection(1);
                break;
            }
        }
    }

    private DetailRequest createEntry(){
        nameEt = findViewById(R.id.name_et);
        addressEt = findViewById(R.id.address_et);
        mailEt = findViewById(R.id.email_et);
        phoneEt = findViewById(R.id.phone_et);
        genderSp = findViewById(R.id.gender_sp);

        DetailRequest detailRequest = new DetailRequest();
        detailRequest.setName(nameEt.getText().toString());
        detailRequest.setAddress(addressEt.getText().toString());
        detailRequest.setEmail(mailEt.getText().toString());
        detailRequest.setPhoneNumber(phoneEt.getText().toString());
        detailRequest.setGender(genderSp.getSelectedItem().toString());
        return  detailRequest;
    }
}