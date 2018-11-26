package gestion;

public abstract class Bot {
	private String bot_name;
	
	public Bot(){
		this.bot_name = "system";
	}
		
	public void set_name(String nom){
		this.bot_name = nom;
	}
	
	public String name(){
		return bot_name;
	}
	
	public abstract void lancer();
	public abstract void lancer(String msg);
	
	
}
