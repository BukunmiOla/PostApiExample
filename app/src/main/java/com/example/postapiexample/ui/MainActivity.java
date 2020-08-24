 package com.example.postapiexample.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.postapiexample.R;
import com.example.postapiexample.model.DetailRequest;
import com.example.postapiexample.model.DetailResponse;
import com.example.postapiexample.network.ClientInstance;
import com.example.postapiexample.network.DataService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

 public class MainActivity extends AppCompatActivity {
     RecyclerView displayRv;
     EditText nameEt, phoneEt, addressEt, mailEt;
     Spinner genderSp;

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

    private DetailRequest createEntry(){
        nameEt = findViewById(R.id.new_name_et);
        addressEt = findViewById(R.id.new_address_et);
        mailEt = findViewById(R.id.new_email_et);
        phoneEt = findViewById(R.id.new_phone_et);
        genderSp = findViewById(R.id.new_gender_sp);
        
        DetailRequest detailRequest = new DetailRequest();
        detailRequest.setName(nameEt.getText().toString());
        detailRequest.setAddress(addressEt.getText().toString());
        detailRequest.setEmail(mailEt.getText().toString());
        detailRequest.setPhoneNumber(phoneEt.getText().toString());
        detailRequest.setGender(genderSp.getSelectedItem().toString());
        return  detailRequest;
    } 
    private void postName() {
         DataService service =
                 ClientInstance.getClientInstance()
                         .create(DataService.class);
         
         DetailRequest detailRequest = createEntry();

         Call<List<DetailRequest>> call = service.postDetails(detailRequest);

        call.enqueue(new Callback<List<DetailRequest>>() {
             @Override
             public void onResponse(Call<List<DetailRequest>> call, Response<List<DetailRequest>> response) {
                 Toast.makeText(MainActivity.this, "Connected", Toast.LENGTH_SHORT);


             }

             @Override
             public void onFailure(Call<List<DetailRequest>> call, Throwable t) {
                 Toast.makeText(MainActivity.this, "Something went wrong...", Toast.LENGTH_SHORT);

             }
         });
        clearInputs();
    }

     private void clearInputs() {
         nameEt.setText("");
         addressEt.setText("");
         mailEt.setText("");
         phoneEt.setText("");
         genderSp.setSelection(0);
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
                 Toast.makeText(MainActivity.this, "Connected", Toast.LENGTH_SHORT);
                 DetailAdapter adapter = new DetailAdapter(response.body());
                 displayRv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                 displayRv.setAdapter(adapter);
             }

             @Override
             public void onFailure(Call<List<DetailResponse>> call, Throwable t) {
                 Toast.makeText(MainActivity.this, "Something went wrong...", Toast.LENGTH_SHORT);

             }
         });
     }
 }