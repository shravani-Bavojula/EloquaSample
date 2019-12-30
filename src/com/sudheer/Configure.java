package com.sudheer;

import java.io.BufferedReader;
//import java.io.FileWriter;
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

@WebServlet("/Configure")
public class Configure extends HttpServlet {
	static String abc;
	static int count;
	private static final long serialVersionUID = 2L; 
	
    public Configure() {
    	abc="{\"0\":\"URL|instance|siteId|asset|status\"}";
        // TODO Auto-generated constructor stub
    }
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	// For Tracing
	
	String text = request.getRequestURL()+"|"+request.getParameter("instance")+"|"+request.getParameter("siteId")+"|"+request.getParameter("asset")+"|"+request.getParameter("status");
	
	
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
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	// For Tracing
	
	String text = request.getRequestURL()+"|"+request.getParameter("instance")+"|"+request.getParameter("siteId")+"|"+request.getParameter("asset")+"|"+request.getParameter("status");
	//System.out.println(text);
	
	
	/*
	trace t=new trace();
	t.send(trace);
	*/
	// For Tracing
	
	count++;
	abc+=",{\""+count+"\":\""+text+"\"}";
	
	//PUT API CALL
	try {
		String requestUrl = "https://secure.eloqua.com/api/cloud/1.0/feeders/instances/"+request.getParameter("instance");
		URL url = new URL(requestUrl);
	    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	    connection.setDoInput(true);
	    connection.setDoOutput(true);
	    connection.setRequestMethod("PUT");
	    //connection.connect();
	   // connection.setRequestProperty("Accept", "application/json");
	    connection.setRequestProperty("Content-Type", "application/json");
	    connection.setRequestProperty("Authorization", "Basic VGVjaG5vbG9neVBhcnRuZXJJbm5vdmFjeFNvbHV0aW9uc0luY1xzdWRoZWVya3VtYXIuYWt1bGE6SW5ub3ZhY3hAMjAxNw==");
	    OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
		if(count/2==0) {
	    writer.write("\"{  \\\"requiresConfiguration\\\": \"true\" }\"");
		}else {
		writer.write("\"{  \\\"requiresConfiguration\\\": \"false\" }\"");
		}
	    //System.out.println("2");
		writer.close();
	    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	    //StringBuffer jsonString = new StringBuffer();
	    //String line;
	    //while ((line = br.readLine()) != null) {
	    //        jsonString.append(line);
	    //}
	    //br.close();
	    connection.disconnect();
	} catch (Exception e) {
	        throw new RuntimeException(e.getMessage());
	}
	
	//PUT API CALL
	
	
	/*PrintWriter out = response.getWriter(); 
	response.setContentType("application/json"); 
	response.setCharacterEncoding("UTF-8");
	out.append("{  \"requiresConfiguration\": false }");
	out.flush();
	*/
	//doGet(request, response);
	response.setStatus(200); 
}
}
