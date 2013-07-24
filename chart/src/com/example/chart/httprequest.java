package com.example.chart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.os.AsyncTask;

public class httprequest extends AsyncTask<String, Integer, String> {
	ICallBack cb;
	
	public httprequest(ICallBack cb){
		this.cb = cb;
	}
	
	
	@Override
	protected String doInBackground(String... arg0) {
		// TODO Auto-generated method stub
		//cb.update();
		System.out.println("task1");
		//------------------------------------------------//
		String url = 
				"http://hqdigi2.eastmoney.com/EM_Quote2010NumericApplication/index.aspx?type=s&sortType=A&sortRule=1&pageSize=20&page=1&jsName=quote_123&style=33";
		InputStream is = HttpUtils.getContent(url);
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		
		StringBuilder sb = new StringBuilder();   
		String line = null;   
		try {   
			while ((line = reader.readLine()) != null) {   
				sb.append(line + "/n");   
			}
		} catch (IOException e) {   
			e.printStackTrace();   
		} finally {   
			try {   
				is.close();   
			} catch (IOException e) {   
				e.printStackTrace();   
			}
		}
		return sb.toString(); 
		//------------------------------------------------//
		//return null;
	}
	
    protected void onPostExecute (String result) {  
        //mAdapter.notifyDataSetChanged();//通知ui界面更新  
        //dismissDialog(DIALOG_PROGRESS);//关闭等待对话框  

		System.out.println("task2");
    	cb.update(result);
    } 
    
    
    
    

}
