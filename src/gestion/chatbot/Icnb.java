package gestion.chatbot;
import gestion.*;
import gestion.base.*;

import org.json.JSONArray;
import org.json.JSONObject;

public class Icnb extends Bot{

	private String msg;

	public void lancer() throws BotInvalide{
		int i;
		Saisie response = new Saisie();

		i = saisie.getInt();
		if( i>= 1) {
			String rep = response.getUrlResponse("http://api.icndb.com/jokes/random/"+i);
			JSONObject tables = new JSONObject(rep);
			JSONArray table = tables.getJSONArray("value");
			for (i=0;i<table.length();i++) {
				JSONObject joke = table.getJSONObject(i);
				this.msg = joke.getString("joke");
				prompt.shown("[icndb] "+ this.msg);
			}
		}

	}

}
