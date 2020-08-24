package com.example.postapiexample.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class NameResponse{

	@SerializedName("__v")
	private int V;

	@SerializedName("name")
	private String name;

	@SerializedName("_id")
	private String id;

	@SerializedName("Created_date")
	private String createdDate;

	@SerializedName("status")
	private List<String> status;

	public int getV(){
		return V;
	}

	public String getName(){
		return name;
	}

	public String getId(){
		return id;
	}

	public String getCreatedDate(){
		return createdDate;
	}

	public List<String> getStatus(){
		return status;
	}

	public void setV(int v) {
		V = v;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public void setStatus(List<String> status) {
		this.status = status;
	}
}