import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
/**
 * DialogueTwitter est la classe permettant d'obtenir les tweets tendance de Twiiter  
 * 
 * @author william
 *
 */
public class DialogueTwitter {

/**
 * Constructeur DialogueTwitter.
 * 
 */
	private Twitter twitter = new TwitterFactory().getInstance();

/**
 * Afin de pouvoir accèder aux informations de Twitter un compte programmeur est necessaire.
 * On rentre ici les idendifiants fournit par Twitter.
 */
	public void identification() {
		twitter.setOAuthConsumer("hoCmn6JJf1O0G8OrrfEhgNSVd",
				"XqRPkpG1fEJMBllBYt63YjdygEAFbt8DC3ZWCpAUzG9gVLXB1j");
		twitter.setOAuthAccessToken(new AccessToken(
				"2867128532-IqEpOMHnSXipHDNvSWZsETgqLE87TrKRsHmWSAQ",
				"pqao9pf7RIZDzW2lgFk2Kvf8zDnCcTUhHbdVoq22YrIDz"));
	}

	
/**
 * Retourne les 10 Trends Topics
 * @param position
 * 					Le lieu géographique lors de l'écriture du tweet.
 * @return Une liste de 10 sujet ayant le plus de hashtag sur twitter.
 */
	public Trends recupTends(int position) {
		try {
			Trends trends = twitter.getPlaceTrends(position);
			for (int i = 0; i < trends.getTrends().length; i++) {
				System.out.println(trends.getTrends()[i].getName());
			}
			return trends;
		} catch (TwitterException e) {
			System.out.println("Erreur");
			return null;
		}
	}
}
