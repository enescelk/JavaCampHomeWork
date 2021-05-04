package Adapters;

import Abstract.CustomerCheckService;
import Entities.Customer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapters implements CustomerCheckService{

	@Override
	public boolean CheckIfRealPerson(Customer customer) {
		
		boolean result = true;
		
		KPSPublicSoap kpsPublic = new KPSPublicSoapProxy();
		try {
			result = kpsPublic.TCKimlikNoDogrula(Long.parseLong(customer.getNationalityId()),customer.getFirstName().toUpperCase(),customer.getLastName(),customer.getDateOfBirth());
		}catch(Exception exception){
			
		}
		
		return result;
	}
	
}
