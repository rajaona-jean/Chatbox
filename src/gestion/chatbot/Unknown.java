package gestion.chatbot;
import gestion.*;
public class Unknown extends Bot{
	private String msg = "oups";
	
	public Unknown(){
		
	}
	
	public void lancer(){
		System.out.println(this.msg);
	}
	
	public void lancer(String msg) {
		System.out.println("[system] Je ne connais pas de bot @"+msg+" !");
	}
	

}
