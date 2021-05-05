package Concrete;

import Abstract.PlayerCheckService;
import Abstract.PlayerService;
import Entities.Player;

public class PlayerManager implements PlayerService{
	
	PlayerCheckService playerCheckService;
	
	public PlayerManager(PlayerCheckService playerCheckService) {
		this.playerCheckService = playerCheckService;
	}

	@Override
	public void register(Player player) {
		if(playerCheckService.CheckIfRealPerson(player)) {
			System.out.println("Tebrikler basariyla sisteme kayit oldunuz");
		}else {
			System.out.println("Bilgileriniz eksik lutfen formu eksiksiz doldurunuz");
		}
	}

	@Override
	public void login(Player player) {
		System.out.println("Basariyla giris yapildi ana sayfaya yonlendirliyorsunuz..");
	}

	@Override
	public void delete(Player player) {
		System.out.println(player.getFirstName() + " " + player.getLastName() +  " Adli oyuncu sistemden silindi");
	}

	@Override
	public void update(Player player) {
		System.out.println(player.getFirstName() + " " + player.getLastName() +  " Adli oyuncunun bilgileri guncellendi");
	}

}
