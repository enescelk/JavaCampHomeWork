package Abstract;

import Entities.Player;

public interface PlayerService {
	void delete(Player player);
	void update(Player player);
	
	void register(Player player);
	void login (Player player);

}
