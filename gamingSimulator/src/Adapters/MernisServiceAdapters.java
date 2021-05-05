package Adapters;

import Abstract.PlayerCheckService;
import Entities.Player;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapters implements PlayerCheckService{

	@Override
	public boolean CheckIfRealPerson(Player player) {
		
		boolean result = true;
		
		KPSPublicSoap kpsPublic = new KPSPublicSoapProxy();
		try {
			result = kpsPublic.TCKimlikNoDogrula(Long.parseLong(player.getNationalityId()),player.getFirstName().toUpperCase(),player.getLastName(),player.getDateOfBirth());
		}catch(Exception exception){
			
		}
		
		return result;
	}
	
}
