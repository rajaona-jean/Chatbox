package gestion.chatbot;
import java.io.*;
import java.net.*;
import gestion.*;

import org.json.JSONObject;

public class Icnb extends Bot{

	private String msg;
	
	public Icnb() {
		super();
	}
	
	public void lancer() throws IOException{
		Icnb response = new Icnb();
		String joke = response.get("http://api.icndb.com/jokes/random/");
		JSONObject obj = new JSONObject(joke);
		
		JSONObject jokes = obj.getJSONObject("value");
		this.msg = jokes.getString("joke");
		System.out.println("[icndb] "+ this.msg);
	}

	
	public String get(String url)throws IOException {
		String msg ="";
		URL request = new URL(url);
		HttpURLConnection co = (HttpURLConnection) request.openConnection();
		BufferedReader in = new BufferedReader(
				new InputStreamReader(
				co.getInputStream()));
		String inputLine;
		 
		while ((inputLine = in.readLine()) != null)
		msg +=inputLine;
		in.close();
		return msg;
	}

}
