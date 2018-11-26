package gestion.chatbot;
import java.io.IOException;

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
		System.out.println(this.msg);
	}
	
	public void lancer(String msg){
	}

	@Override
	public void lancer_req() throws IOException {
		// TODO Auto-generated method stub
		
	}
}
