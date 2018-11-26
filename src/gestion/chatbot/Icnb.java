package gestion.chatbot;
import java.io.*;
import java.net.*;
import gestion.*;

public class Icnb extends Bot{

	private String msg;
	
	public Icnb() {
		
	}
	
	public void lancer(){
		Icnb response = new Icnb();
		this.msg = response.get("http://www.icndb.com/api/");
		System.out.println(this.msg);
	}
	
	public void lancer(String msg){
	}
	
	public String get(String url)throws IOException {
		String msg = "";
		URL request = new URL(url);
		URLConnection co = request.openConnection();
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
