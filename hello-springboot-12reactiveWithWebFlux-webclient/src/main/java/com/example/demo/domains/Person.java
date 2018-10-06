package com.example.demo.domains;

public class Person
{
	private String id;
	private String name;
	private int age;
	private String address;
	public Person()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String id, String name, int age, String address)
	{
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	@Override
	public String toString()
	{
		return "Person [id=" + id + ", name=" + name + ", age=" + age
				+ ", address=" + address + "]";
	}	
}
