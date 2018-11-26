package gestion;
import java.io.IOException;
import java.util.Scanner;

public class Main extends Saisie{
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		String msg = "";
		System.out.println("Welcom on the chatbox\n");
		Gestionnaire gs = new Gestionnaire(args[1]);
		while( msg.equals("++") != true ){
			System.out.print("["+args[1]+"] ");
			msg = sc.next();
			Saisie.msg = msg;
			if (msg.charAt(0) == '@'){
				gs.start(msg.substring(1));
			}

		}

		System.out.println("\nend");
		sc.close();
	}			
}
