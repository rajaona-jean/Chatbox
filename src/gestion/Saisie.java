package gestion;

public class Saisie {
	protected static Saisie saisie = new Saisie();
	protected String msg;
	protected String arg;
	
	public Saisie(){
	}
	
	public void set(String msg) {
		int i = msg.indexOf(" ");
		if(i!=-1) {
			Saisie.saisie.setarg(msg.substring(i).trim());
			this.msg = msg.substring(0,i).trim();
		}
		else {
			this.arg = "1";
			this.msg = msg;
		}

	}
	
	public void setarg(String msg) {
		this.arg = msg;
	}
	
	public String get() {
		return this.msg;
	}
	
	public String getarg() {
		return this.arg;
	}
	
	public int getint() throws BotInvalide{
		int i = 1;
		String msg2 = this.arg;
		i = Integer.parseInt(msg2);
		return i;
	}
	
	public String get2() {
		return arg;
	}
}
