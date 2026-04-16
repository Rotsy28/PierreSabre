package personnages;

public class Commercant extends Humain {
	
	public Commercant(String nom, int argent) {
		super(nom, "thé" , argent);
	}
	
	public int seFaireExtorquer() {
		int somme = argent;
		argent = 0;
		parler("J'ai tout perdu! Le monde est vraiment trop injuste...");
		return somme;
	}
	
	public void recevoir( int argent) {
		gagnerArgent(argent);
		parler( argent + " sous! Je te remercie généreux donateur!");
	}

}
