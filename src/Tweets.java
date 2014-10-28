/**
 * Tweets est la classe affichant la liste des tweets tendance sur twitter.
 * @author william
 *
 */
public class Tweets {
/**
 * S'identifie sur Twitter.
 * Récupère les sujets tendances dans le monde (position=1).
 * @see DialogueTwitter
 * 
 * @param args
 */
	public static void main(String[] args) {
		DialogueTwitter d = new DialogueTwitter();
		d.identification();
		d.recupTends(1);
		System.out.println("Bonjour");
		IHM fenetre = new IHM();
		fenetre.setVisible(true);
	}
}
