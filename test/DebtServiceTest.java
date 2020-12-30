import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.Test;

import az.adnsu.model.Debt;
import az.adnsu.model.Tax;

public class DebtServiceTest {

	@Test
	void testCurrentMonth() {
		Calendar calendar = Calendar.getInstance();
		int currentMonth = calendar.get(Calendar.MONTH) + 1;
		assertEquals(12, currentMonth);
	}

	@Test
	void testSumOfDebts() {
		Debt debt1 = new Debt();
		debt1.setDebt(15D);
		debt1.setMonth(12);

		Debt debt2 = new Debt();
		debt2.setDebt(5D);
		debt2.setMonth(12);
		
		Debt debt3 = new Debt();
		debt3.setDebt(10D);
		debt3.setMonth(12);
		debt3.setIsPaid(true);
		
		Debt debt4 = new Debt();
		debt4.setDebt(10D);
		debt4.setMonth(12);

		Tax tax1 = new Tax(1L, "Azersu");
		Tax tax2 = new Tax(2L, "Internet");

		debt1.setTax(tax1);
		debt2.setTax(tax2);
		debt3.setTax(tax1);

		List<Debt> debts = new ArrayList<>();
		debts.add(debt1);
		debts.add(debt2);
		debts.add(debt3);
		debts.add(debt4);
		
		Double d = debts.stream()
					.filter(this::filterDebt)
					.map(Debt::getDebt)
					.reduce((double) 0, (total,num) -> total + num);
						
		
		assertEquals(20 , d);
	}
	
	boolean filterDebt(Debt debt) {
		return debt.getTax() != null && debt.getMonth() == 12 && debt.getIsPaid() == false;
	}

}
