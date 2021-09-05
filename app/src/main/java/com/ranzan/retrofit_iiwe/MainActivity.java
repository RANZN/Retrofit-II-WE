package com.ranzan.retrofit_iiwe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText search;
    private RecyclerView recyclerView;
    private Button btn;
    private Adapter adapter;
    private List<ResponseItem> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setRecyclerView();
    }

    private void setRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        list = new ArrayList<>();
        adapter = new Adapter(list);
        recyclerView.setAdapter(adapter);
    }

    private void initViews() {
        search = findViewById(R.id.search);
        recyclerView = findViewById(R.id.recyclerView);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApi();

            }
        });
    }

    private void callApi() {
        ApiService apiService = Network.getRetrofitInstance().create(ApiService.class);
        apiService.getData(Integer.parseInt(search.getText().toString())).enqueue(new Callback<List<ResponseItem>>() {
            @Override
            public void onResponse(Call<List<ResponseItem>> call, Response<List<ResponseItem>> response) {
                if (response.body() != null) {
                    adapter.updateUi(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<ResponseItem>> call, Throwable t) {

            }
        });
    }
}