package com.example.kafkaStreamAPI.entity;

public class User {
	private Integer id;
	private String name;
	private String age;

	public User() {
		super();
	}

	public User(Integer id, String name, String age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public User(String name) {
		super();
		this.name = name;

	}

	public User(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

}
