package com.example.chart;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;



public class HttpUtils {
	
	
	public static HttpResponse getResponse(String url){
		HttpResponse res=null;
		HttpClient http = new DefaultHttpClient();
		HttpUriRequest request = new HttpGet(url);
		try {
			res = http.execute(request);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	
	public static InputStream getContent(String url){
		InputStream is =null;
		HttpResponse res = getResponse(url);
		if(res.getStatusLine().getStatusCode()==HttpStatus.SC_OK)
			try {
				is = res.getEntity().getContent();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return is;
	}
}
