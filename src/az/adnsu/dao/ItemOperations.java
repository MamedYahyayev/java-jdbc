package az.adnsu.dao;

import az.adnsu.model.Items;

public interface ItemOperations extends CrudOperations<Items, Long> {
	
	Double sumOfItemsPriceByCurrentMonth();

}
