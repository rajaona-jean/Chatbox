package gestion;
import java.io.IOException;

import gestion.chatbot.*;

public class Gestionnaire{
	private int taille = 4;
	private Bot tabl[] = new Bot[this.taille];


	public Gestionnaire(String user_name){
		Bot Unknown = new Unknown();
		this.tabl[0]=Unknown;
		Bot hello = new Hello(user_name);
		hello.set_name("hello");
		this.tabl[1] = hello;
		Bot time = new Time();
		time.set_name("time");
		this.tabl[2] = time;
		Bot icnb = new Icnb();
		icnb.set_name("icnb");
		this.tabl[3] = icnb;
	}

	public void start(String msg) throws IOException{
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
