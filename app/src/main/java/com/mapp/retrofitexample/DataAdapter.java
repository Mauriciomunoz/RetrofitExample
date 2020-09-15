package com.mapp.retrofitexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mapp.retrofitexample.model.CompanyData;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.CustomViewHolder> {
    private List<CompanyData> companies;
    private Context context;

    public DataAdapter(Context context, List<CompanyData> companies){
        this.context = context;
        this.companies = companies;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.bindInfo(companies.get(position));
    }

    @Override
    public int getItemCount() {
        return companies.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView txtId;
        public TextView txtTitle;

        //Set the information to the cell
        public void bindInfo(CompanyData company){
            txtId.setText("ID: " + company.getId());
            txtTitle.setText("TITLE: " + company.getTitle());
        }

        //Constructor to find the view of the text inside the cell.
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            txtId = (TextView)itemView.findViewById(R.id.txtId);
            txtTitle = (TextView)itemView.findViewById(R.id.txtTitle);
        }
    }

}
