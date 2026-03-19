package com.example.demo.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class StudentModel {
	@Id
	private int id;
	
	@NotNull
	@Size(min= 2, max= 50)
	private String name;
	
	@Min(0)
	private int age;

	public StudentModel() {
	}
	
	public StudentModel(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age  =age;
	}
}
