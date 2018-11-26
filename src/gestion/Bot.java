package gestion;

import java.io.IOException;

public abstract class Bot extends Saisie{
	private String bot_name;
	
	public Bot(){
		this.bot_name = "system";
	}
		
	public void set_name(String nom){
		this.bot_name = nom;
	}
	
	public String name(){
		return bot_name;
	}
	
	public abstract void lancer() throws IOException;
	
}
