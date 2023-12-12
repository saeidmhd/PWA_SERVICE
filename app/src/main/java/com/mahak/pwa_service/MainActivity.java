package com.mahak.pwa_service;

// MainActivity.java
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Retrofit client setup
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);

        // Get data from the server
        Call<DataResponse> getDataCall = apiService.getData();
        getDataCall.enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                if (response.isSuccessful()) {
                    DataResponse data = response.body();
                    if (data != null) {
                        // Handle the received data
                        String message = data.getMessage();
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                        // Update your UI or perform other actions
                    }
                }
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "etyrty", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Method to update data on the server
    private void updateData() {
        DataRequest newData = new DataRequest("Updated from Android App");

        Call<Void> sendDataCall = apiService.sendData(newData);
        sendDataCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    // Data updated successfully
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(MainActivity.this, "sada", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
