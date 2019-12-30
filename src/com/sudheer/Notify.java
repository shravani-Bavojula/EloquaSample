package com.sudheer;

import java.io.BufferedReader;
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

@WebServlet("/Notify")
public class Notify extends HttpServlet {
	static String abc;
	static int count;
	private static final long serialVersionUID = 2L; 

    public Notify() {
    	abc="{\"0\":\"URL|instance|siteId|asset|status\"}";
        // TODO Auto-generated constructor stub
    }

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	// For Tracing
	
	String text = request.getRequestURL()+"|"+request.getParameter("instance")+"|"+request.getParameter("siteId")+"|"+request.getParameter("asset")+"|"+request.getParameter("status");
	/*
	trace t=new trace();
	t.send(trace);
	*/
	
	// For Tracing
		
	PrintWriter out = response.getWriter(); 
	response.setContentType("application/json"); 
	response.setCharacterEncoding("UTF-8");
	out.print("["+abc+"]");
	out.flush();
		response.setStatus(204);
		
	}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	// For Tracing
	
	String text = request.getRequestURL()+"|"+request.getParameter("instance")+"|"+request.getParameter("siteId")+"|"+request.getParameter("asset")+"|"+request.getParameter("status");
	count++;
	abc+=",{\""+count+"\":\""+text+"\"}";
	/*
	trace t=new trace();
	t.send(trace);
	*/
	
	// For Tracing
	/*
	PrintWriter out = response.getWriter(); 
	response.setContentType("application/json"); 
	response.setCharacterEncoding("UTF-8");
	out.print("{  \"requiresConfiguration\": true }");
	out.flush();
	*/
	//doGet(request, response);
	response.setStatus(204);
	
}
}
