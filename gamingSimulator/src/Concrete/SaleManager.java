package Concrete;

import Abstract.SaleService;
import Entities.Campaign;
import Entities.Game;
import Entities.Player;

public class SaleManager implements SaleService{

	@Override
	public void sale(Player player, Game game) {
			System.out.println(player.getFirstName() +  " isimli adli oyuncu " + game.getGameName() + " adli oyunu satil aldi" );
		
		
		
	}

	@Override
	public void sale(Player player, Game game, Campaign campaign) {
		
		System.out.println(player.getFirstName()+" isimli adli oyuncu "+game.getGameId()+" id numarasýna sahip "+game.getGameName()+" isimli oyunu "+ campaign.getCampaignName()
		+" isimli kampanyadan faydalanarak "+game.getPrice()+" TL yerine "+campaign.getDiscountRate() + " indirim oranina " + game.getPrice() +  " Tl'ye basariyla satin aldi");
		
	}

}
