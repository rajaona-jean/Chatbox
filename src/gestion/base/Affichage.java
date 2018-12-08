package gestion.base;

public class Affichage {
	protected static Affichage prompt = new Affichage();
	protected String msg;
	
	
	public void show(String msg) {
		System.out.print(msg);
	}
	
	public void shown(String msg) {
		System.out.println(msg);
	}
	
	public void showTabl(String[] tabl){
		
		int tablLenght = tabl.length;
		for(int j = 0; j<tablLenght;j++) {
			prompt.shown("       "+(j+1)+") "+tabl[j]);
		}
	}

}
