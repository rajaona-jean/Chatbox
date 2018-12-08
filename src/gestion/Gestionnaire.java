package gestion;
import gestion.base.BotInvalide;
import gestion.chatbot.*;

public class Gestionnaire{
	private int taille = 5;
	private Bot tabl[] = new Bot[this.taille];


	public Gestionnaire(String user_name){
		Bot Unknown = new Unknown();
		this.tabl[0]=Unknown;
		Bot hello = new Hello(user_name);
		hello.setName("hello");
		this.tabl[1] = hello;
		Bot time = new Time();
		time.setName("time");
		this.tabl[2] = time;
		Bot icnb = new Icnb();
		icnb.setName("icnb");
		this.tabl[3] = icnb;
		Bot quiz = new Quiz();
		quiz.setName("quiz");
		this.tabl[4] = quiz;
	}

	public void start(String msg) throws BotInvalide{
		int i = 0;
		short find = 0;
		String bot_name;
		while(i<this.taille && find==0){
			bot_name = this.tabl[i].name();
			if(bot_name.equals(msg)){
				tabl[i].lancer();
				find = 1;
			}
			i++;
		}
		if(find == 0) {
			tabl[0].lancer();
		}


	}

}
