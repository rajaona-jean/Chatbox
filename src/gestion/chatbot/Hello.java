package gestion.chatbot;
import gestion.*;

public class Hello extends Bot{
	private String nom;
	private String msg;
	
	public Hello(String name){
		super();
		this.nom = name;
		this.msg = "[hello] Salut "+this.nom+"!";
	}
			
	public void lancer(){
		prompt.shown(this.msg);
	}
	
}
