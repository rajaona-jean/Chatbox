package gestion;
import java.io.IOException;

public class BotInvalide extends Exception{
	private String msg;

	public BotInvalide(IOException msg){
		super();
	}
		
	public BotInvalide(NumberFormatException e) {
		super();
		this.msg = Saisie.saisie.get2();
		System.out.println("[system] Je ne sais pas quoi faire avec "+this.msg+" !");	

	}

}
