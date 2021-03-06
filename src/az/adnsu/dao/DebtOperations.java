package az.adnsu.dao;

import az.adnsu.model.Debt;

public interface DebtOperations extends CrudOperations<Debt, Long> {
	
	boolean paidDebt(Long id , Boolean isPaid);
	
	Double sumOfDebtsByCurrentMonth();

}
