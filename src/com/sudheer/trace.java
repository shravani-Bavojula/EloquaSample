package com.sudheer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class trace {
	/*public static void main(String ar[]) {
		trace d1=new trace();
		d1.send("Hello");
	}
	*/
	public void send(String text) {
	try {
		String requestUrl = "https://s2121803030.t.eloqua.com/e/f2?elqFormName=apicheck&elqSiteId=2121803030&paragraphText="+text;
		URL url = new URL(requestUrl);
	    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	    connection.setDoInput(true);
	    connection.setDoOutput(true);
	    connection.setRequestMethod("POST");
	    //connection.connect();
	    connection.setRequestProperty("Accept", "application/json");
	    connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
	    //System.out.println("1");
	    OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
		//writer.write(payload);
		//System.out.println("2");
		writer.close();
	    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	    //StringBuffer jsonString = new StringBuffer();
	    //String line;
	    //while ((line = br.readLine()) != null) {
	    //        jsonString.append(line);
	    //}
	    //br.close();
	    //System.out.println("Hello 0");
	    connection.disconnect();
	} catch (Exception e) {
	        throw new RuntimeException(e.getMessage());
	}
	//return jsonString.toString();
	}
}