package gestion;

import gestion.base.BotInvalide;
import gestion.base.Saisie;

public abstract class Bot extends Saisie{
	private String botName;
		
	public Bot(){
		this.botName = "system";
	}
		
	public void setName(String nom){
		this.botName = nom;
	}
	
	public String name(){
		return botName;
	}
	
	public abstract void lancer() throws BotInvalide;
	
}
