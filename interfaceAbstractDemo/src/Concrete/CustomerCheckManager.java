package Concrete;

import Entities.Customer;
import Abstract.CustomerCheckService;
import Adapters.MernisServiceAdapters;

public class CustomerCheckManager implements CustomerCheckService{

	@Override
	public boolean CheckIfRealPerson(Customer customer) {
		
		return true;
	}
	
	

}
