package com.example.springboothelloworld;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName="helloFilter", urlPatterns="/helloServlet")
public class HelloFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Executing doFilter method");
		chain.doFilter(request, response);
		System.out.println("Done executing doFilter method");
	}
}
