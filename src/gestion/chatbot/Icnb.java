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
		this.msg = response.get("http://www.icndb.com/api/jokes/random?firstName=Chuck&amp;lastName=Norris");
		System.out.println(this.msg);
	}

	
	public String get(String url)throws IOException {
		JASONObject msg = new JASONObject();
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
