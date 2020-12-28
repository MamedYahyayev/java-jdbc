package az.adnsu.dao;

import az.adnsu.model.Tax;

public interface TaxOperations extends CrudOperations<Tax, Long>{
	
	Tax findByTaxName(String taxName);

}
