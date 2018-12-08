package gestion.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Saisie extends Affichage{
	protected static Saisie saisie = new Saisie();
	protected String msg;
	protected String arg;
	protected String userName;

	private String stop;
	private Scanner sc = new Scanner(System.in);


	// SET ///////////////////////////////////////////
	public void set(String msg) {
		int i = msg.indexOf(" ");
		if(i!=-1) {
			Saisie.saisie.setArg(msg.substring(i).trim());
			this.msg = msg.substring(0,i).trim();
		}
		else {
			this.arg = "1";
			this.msg = msg;
		}

	}

	public void setArg(String msg) {
		this.arg = msg;
	}

	public void setUserName(String msg) {
		this.userName=msg;
	}

	public void setStopCondition(String stopCondition) {
		this.stop = stopCondition;
	}

	// FIN SET ///////////////////////////////////////////////

	// GET ///////////////////////////////////////////////////
	public String getLine() {
		String msg;
		msg = sc.nextLine();
		if (msg.equals(this.stop) == true)
			sc.close();

		return msg;
	}

	public String getUserName() {
		return this.userName;
	}

	public String getArg() {
		return this.arg;
	}

	public String get() {
		return this.msg;
	}

	public int getInt() throws BotInvalide{
		int i = 1;
		try {
			i = Integer.parseInt(this.arg);
		}
		catch(NumberFormatException e) {
			new BotInvalide(saisie.get().substring(1));
			i = 0;
		}
		return i;
	}

	public String getUrlResponse(String url) throws BotInvalide{
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

	// Fin GET ////////////////////////////////////////////////////////////

	public int shuffleTabl(String[] tabl) { //Mélange tableau et renvoie l'indice du derniere 
		// Element echangé
		int min = 0;
		int max = tabl.length;
		int nbAlea = min + (int)(Math.random()*(max-min));
		int tablLenght = tabl.length;

		String permute = tabl[tablLenght-1];
		tabl[tablLenght-1]=tabl[nbAlea];
		tabl[nbAlea] = permute;

		return nbAlea;
	}
}
