package com.mapp.retrofitexample.model;

public class CompanyData {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //We can use @SerializedName if the name of variable is different to name of field on JSON
    private int id;
    private String title;

    public CompanyData(int id, String title){
        this.id = id;
        this.title = title;
    }


}
