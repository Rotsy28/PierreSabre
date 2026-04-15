package personnages;

public class Yakuza extends Humain {

	private String clan;
    private int reputation = 0; 

	public Yakuza(String nom, String boisson, int argent, String clan) {
		super(nom, boisson, argent);
		this.clan= clan;
	}
	
	public int obtenirreputation() {
		return reputation; 
	}
	
	public void extorquer( Commercant victime) {
	    parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
	    parler(victime.getNom() + ", si tu tiens à la vie donne moi ta bourse !");
	    int vol = victime.seFaireExtorquer();
	    gagnerArgent(vol);
	    reputation++;
	    parler("J’ai piqué les " + vol + " sous de " + victime.getNom() +
	           ", ce qui me fait " + getArgent() + " sous dans ma poche. Hi ! Hi !");
	}

	public int perdre() {
    	int montant = perdreToutArgent();;
    	reputation--;
    	parler("J’ai perdu mon duel et mes " + montant + " sous, snif... J'ai déshonoré le clan de " + clan + ".");
    	return montant;
	}

	public void gagner(int gain) {
		gagnerArgent(gain);
		reputation++;
		parler("Ce ronin pensait vraiment battre " + getNom() + " du clan " + clan +
           " ? Je l'ai dépouillé de ses " + gain + " sous.");
	}
}
