package com.sudheer;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Vamsi")
public class vamsi extends HttpServlet {
	static String abc;
	static int count;
	private static final long serialVersionUID = 2L; 
	
    public vamsi() {
    	abc="{\"0\":\"URL|instance|siteId|asset|status\"}";
        // TODO Auto-generated constructor stub
    }
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	// For Tracing
	
	String text = request.getReader().toString();
	/*
	trace t=new trace();
	t.send(trace);
	*/
		
		PrintWriter out = response.getWriter(); 
		response.setContentType("application/json"); 
		response.setCharacterEncoding("UTF-8");
		out.print("["+abc+"]");
		out.flush();
		
		response.setStatus(200);
		
	}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	// For Tracing
	
	String text = request.getRequestURL()+"|"+request.getParameter("instance")+"|"+request.getParameter("siteId")+"|"+request.getParameter("asset")+"|"+request.getParameter("status");
	//System.out.println(text);
	/*
	trace t=new trace();
	t.send(trace);
	*/
	// For Tracing
	
	count++;
	abc+=request.getReader().toString()+"\n\n\n\nHello\n\n\n\n";
	PrintWriter out = response.getWriter(); 
	response.setContentType("application/json"); 
	response.setCharacterEncoding("UTF-8");
	out.append("{  \"requiresConfiguration\": false }");
	out.flush();
	 
	//doGet(request, response);
	response.setStatus(200); 
	
}
}
