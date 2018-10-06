package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.config.MySQLConfig;
import com.example.demo.config.MySQLConfigUsingLombok;

@Controller
public class DataSourceTestController
{
	@Autowired	
	private MySQLConfig mySQLConfig;
	@Autowired
	private MySQLConfigUsingLombok mySQLConfigUsingLombok;

	//这是spring的通常写法
	@RequestMapping("/dataSource")
	@ResponseBody
	public String dataSource()
	{
		System.out.println(mySQLConfig);
		System.out.println(mySQLConfigUsingLombok);
		return "dataSource";
	}

	//在SpringBoot中，配合前方静态页面，我们一般会写这种响应方法
	// @RequestMapping("/another/toindexhtml")
	// public String home(Model model)
	// {
	// return "index.html";
	// }
}