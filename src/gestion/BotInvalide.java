package gestion;
import java.io.IOException;

public class BotInvalide extends Exception{
	private String msg;

	public BotInvalide(IOException msg){
		super();
	}
		
	public BotInvalide(String botname) {
		super();
		if(botname.equals("icnb")) {
			this.msg = Saisie.saisie.get2();
			System.out.println("[system] Je ne sais pas quoi faire avec "+this.msg+" !");	
		}

	}

}
