package personnages;

public class Humain {
	
	private String nom;
	private String boisson;
	protected int argent= 0;
	protected int nbConnaissance=0;
	private Humain[] memoire = new Humain[30];
	
	public Humain(String nom, String boisson, int argent) {
		this.nom = nom;
		this.boisson = boisson;
		this.argent = argent;
	}

	public String getNom() {
		return nom;
	}

	public int getArgent() {
		return argent;
	}

	
	protected void gagnerArgent(int gain) {
		argent+=gain;
	}
	
	protected void perdreArgent( int perte) {
		argent-=perte;
	}
	
	public void parler( String texte) {
		System.out.println("(" + nom + ")-" + texte);
	}
	
	public void direBonjour() {
		parler("Bonjour!Je m'appelle " + nom + " et j'aime boire du " + boisson);
	}
	
	public void boire() {
		parler("Mmm, un bon verre de " + boisson+ "! GLOUPS!");
	}
	
	protected int perdreToutArgent() {
	    int temp = argent;
	    argent = 0;
	    return temp;
	}

	
	public void acheter(String bien, int prix) {
		if (argent >= prix) {
			parler("J'ai " + argent + " sous en poche. Je vais pouvoir m'offir un " + bien + " à " + prix + " sous.");
			argent-=prix;
		}
		else {
			parler("Je n'ai plus que " + argent + " sous en poche. Je ne peux même pas m'offrir un " + bien+ " à "+ prix + " sous.");
		}
	}
	
	public void faireConnaisanceAvec( Humain autrehumain) {
		direBonjour();
		autrehumain.repondre(this);
		memoriser(autrehumain);
	}
	
	private void memoriser(Humain autrehumain) {
		if (nbConnaissance <30) {
			memoire[nbConnaissance]= autrehumain;
			nbConnaissance ++;
		}
		else {
			for (int i = 0; i < 29; i++) {
				memoire[i] = memoire[i + 1];
			}
			memoire[29] = autrehumain;
		}
	}
		
	
	
	private void repondre(Humain autrehumain) {
		direBonjour();
		memoriser(autrehumain);
	}
	
	public void listerConnaissance() {
		System.out.print("(" + nom + ") - Je connais beaucoup de monde dont : ");
		for (int i = 0; i < nbConnaissance; i++) {
			System.out.print(memoire[i].getNom());
			if (i < nbConnaissance - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}
	
	
}
