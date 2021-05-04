import Abstract.BaseCustomerManager;
import Adapters.MernisServiceAdapters;
import Concrete.StarbucksCustomerManager;
import Entities.Customer;

public class Main {

	public static void main(String[] args) {
		BaseCustomerManager customerManager = new StarbucksCustomerManager(new MernisServiceAdapters());
		Customer customer = new Customer();
		customer.setId(1);
		customer.setFirstName("Enes");
		customer.setLastName("Karataþ");
		customer.setDateOfBirth(2005);
		customer.setNationalityId("30247853350");
		
		customerManager.save(customer);
			
		};
	}
