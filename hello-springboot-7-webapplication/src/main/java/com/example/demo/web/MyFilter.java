/**
 * 
 */
package com.example.demo.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyFilter implements Filter
{
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException
	{
		String path = ((HttpServletRequest) req).getRequestURI();
		logger.info("------------MyFilter----------");
		logger.info("Path=" + path);
		chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException
	{}

	@Override
	public void destroy()
	{}
}
