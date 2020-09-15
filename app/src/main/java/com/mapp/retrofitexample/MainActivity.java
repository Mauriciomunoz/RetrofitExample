package com.mapp.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.mapp.retrofitexample.databinding.ActivityMainBinding;
import com.mapp.retrofitexample.model.CompanyData;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private DataAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        pDialog = new ProgressDialog(MainActivity.this);
        pDialog.setMessage("Loading....");
        pDialog.show();

        EndpointsQueries service = RetrofitClientInstance.getRetrofitClientInstance().create(EndpointsQueries.class);
        Call<List<CompanyData>> call = service.getAllCompanies();
        call.enqueue(new Callback<List<CompanyData>>() {
            @Override
            public void onResponse(Call<List<CompanyData>> call, Response<List<CompanyData>> response) {
                pDialog.dismiss();
                fillDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<CompanyData>> call, Throwable t) {
                pDialog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong...", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void fillDataList(List<CompanyData> dataCompanies) {
        adapter = new DataAdapter(this, dataCompanies);
        binding.myRecycler.setHasFixedSize(true);
        binding.myRecycler.setLayoutManager(new LinearLayoutManager(this));
        binding.myRecycler.setAdapter(adapter);

    }
}