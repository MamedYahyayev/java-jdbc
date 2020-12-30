package az.adnsu.main;

import java.util.Scanner;

import az.adnsu.model.IncomeExpense;
import az.adnsu.service.DebtService;
import az.adnsu.service.FamilyMembersService;
import az.adnsu.service.IncomeExpenseService;
import az.adnsu.service.ItemService;
import az.adnsu.util.DateUtility;

public class IncomeExpenseMainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		FamilyMembersService membersService = new FamilyMembersService();
		DebtService debtService = new DebtService();
		ItemService itemsService = new ItemService();
		IncomeExpenseService incomeExpenseService = new IncomeExpenseService();

		System.out.print("Press 1 to calculate Result for Current Month: ");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Save method");
			Double income = membersService.findSalarySum();
			Double expense = itemsService.sumOfItemsPriceByCurrentMonth() + debtService.sumOfDebtsByCurrentMonth();
			Double result = income - expense;

			System.out.println("Current Month: " + DateUtility.getCurrentMonth());
			System.out.println("Income: " + income);
			System.out.println("Expense: " + expense);
			System.out.println("Result: " + result);

			IncomeExpense incomeExpense = new IncomeExpense();
			incomeExpense.setIncome(income);
			incomeExpense.setExpense(expense);
			incomeExpense.setResult(result);
			incomeExpense.setIncomeExpenseMonth(DateUtility.getCurrentMonth());
			
			incomeExpenseService.save(incomeExpense);
			break;

			
		default:
			System.err.println("Choice not found !!! Please type number between 1 and 5");
			break;
		}

		sc.close();
	}

}
