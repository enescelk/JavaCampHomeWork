import Adapters.MernisServiceAdapters;
import Concrete.GameManager;
import Concrete.PlayerManager;
import Concrete.SaleManager;
import Entities.Game;
import Entities.Player;

public class Main {

	public static void main(String[] args) {
		
		Player player = new Player();
		player.setId(1);
		player.setFirstName("Enes");
		player.setLastName("Karataþ");
		player.setDateOfBirth(2005);
		player.setNationalityId("30247853350");
		
		Game game = new Game();
		game.setGameId(1);
		game.setGameName("Assassin's Creed 3");
		game.setGameDetails("Aksiyon ve macera oyunu");
		game.setAllReviews("Guzel oyun");
		game.setReleaseDate("2012");
		
		PlayerManager playerManager = new PlayerManager(new MernisServiceAdapters());
		
		playerManager.register(player);
		
		GameManager gameManager = new GameManager();
		gameManager.add(game);
		
		SaleManager saleManager = new  SaleManager();
		saleManager.sale(player, game);
		
		

	}

}
