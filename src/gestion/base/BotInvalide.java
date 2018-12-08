package gestion.base;
import java.io.IOException;

public class BotInvalide extends Exception{
	private String msg;

	public BotInvalide(IOException msg){
		super(msg);
	}
		
	public BotInvalide(String botname) {
		super();
		if(botname.equals("icnb")) {
			this.msg = Saisie.saisie.getArg();
			System.out.println("[system] Je ne sais pas quoi faire avec "+this.msg+" !");	
		}
		
		if(botname.equals("quiz")) {
			this.msg = Saisie.saisie.getArg();
			System.out.println("[system] Je ne sais pas quoi faire avec "+this.msg+" !");	
		}

	}

}
