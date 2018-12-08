package gestion;

import gestion.base.BotInvalide;
import gestion.base.Saisie;

public class Main extends Saisie{
	public static void main(String[] args) throws BotInvalide{
		String msg = "";
		prompt.shown("Welcom on the chatbox\n");
		Gestionnaire gs = new Gestionnaire(args[1]);
		saisie.setUserName("["+args[1]+"] ");
		while( msg.equals("++") != true ){
			saisie.setStopCondition("++");
			prompt.show(saisie.getUserName());
			msg = saisie.getLine();
			saisie.set(msg);
			if (msg.charAt(0) == '@'){
				gs.start(saisie.get().substring(1));
			}
		}
		prompt.shown("\nend");
	}			
}
