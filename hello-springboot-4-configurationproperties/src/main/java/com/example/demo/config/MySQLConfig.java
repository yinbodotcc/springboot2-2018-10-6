package com.example.demo.config;

import javax.validation.constraints.*;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "db")
public class MySQLConfig
{
	
	private String username;
	private String password;
	private String url;
	private String driverClassName;
	@NotNull	
	private String notExistMember;
	@Min(5)
	private int m;
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getUrl()
	{
		return url;
	}
	public void setUrl(String url)
	{
		this.url = url;
	}
	public String getDriverClassName()
	{
		return driverClassName;
	}
	public void setDriverClassName(String driverClassName)
	{
		this.driverClassName = driverClassName;
	}
	public String getNotExistMember()
	{
		return notExistMember;
	}
	public void setNotExistMember(String notExistMember)
	{
		this.notExistMember = notExistMember;
	}
	public int getM()
	{
		return m;
	}
	public void setM(int m)
	{
		this.m = m;
	}
	@Override
	public String toString()
	{
		return "MySQLConfig [username=" + username + ", password=" + password + ", url=" + url + ", driverClassName="
				+ driverClassName + ", notExistMember=" + notExistMember + ", m=" + m + "]";
	}

	
}