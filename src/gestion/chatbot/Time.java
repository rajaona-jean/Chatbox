package gestion.chatbot;
import java.text.SimpleDateFormat;
import java.util.Date;

import gestion.*;

public class Time extends Bot{
	private SimpleDateFormat date;
	private SimpleDateFormat time;
	private String msg;
	
	public Time(){
		super();
		Date now = new Date();
		this.date = new SimpleDateFormat("EEEE dd MMMM");
		this.time = new SimpleDateFormat("kk:mm");
		this.msg = "[time] Nous sommes "+this.date.format(now)+" et il est "+this.time.format(now)+".";
	}
	
	public void lancer(){
		System.out.println(this.msg);
	}
}
