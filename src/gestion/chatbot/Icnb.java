package gestion.chatbot;
import java.io.*;
import java.net.*;
import gestion.*;

import org.json.JSONArray;
import org.json.JSONObject;

public class Icnb extends Bot{

	private String msg;

	public Icnb() {
		super();
	}

	public void lancer() throws BotInvalide{
		int i;
		Icnb response = new Icnb();
		i = saisie.getint();
		String rep = response.get("http://api.icndb.com/jokes/random/"+i);
		JSONObject tables = new JSONObject(rep);
		JSONArray table = tables.getJSONArray("value");
		for (i=0;i<table.length();i++) {
			JSONObject joke = table.getJSONObject(i);
			this.msg = joke.getString("joke");
			System.out.println("[icndb] "+ this.msg);
		}
	}


	public String get(String url) throws BotInvalide{
		String msg ="";
		try {
			URL request = new URL(url);
			HttpURLConnection co = (HttpURLConnection) request.openConnection();
			BufferedReader in = new BufferedReader(
					new InputStreamReader(
							co.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null)
				msg +=inputLine;
			in.close();
		}
		catch (IOException e){
			throw new BotInvalide(e);
		}

		return msg;
	}

}
