package az.adnsu.main;

import java.util.List;
import java.util.Scanner;

import az.adnsu.model.Debt;
import az.adnsu.model.Tax;
import az.adnsu.service.DebtService;
import az.adnsu.service.TaxService;
import az.adnsu.util.Utility;

public class DebtMainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DebtService debtService = new DebtService();
		TaxService taxService = new TaxService();

		Debt debt = new Debt();
		Utility.getChoiceMessage();

		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Save method");

			System.out.print("Enter the Month: ");
			String month = sc.next();

			System.out.print("Enter the Debt: ");
			Double monthDebt = sc.nextDouble();

			List<Tax> taxList = taxService.getAll();
			for (Tax taxs : taxList) {
				System.out.println(taxs);
			}
			System.out.print("Enter the tax id: ");
			Long taxId = sc.nextLong();

			Tax tax = taxService.getById(taxId);
			if (tax != null) {
				debt.setTax(tax);
			}

			debt.setMonth(month);
			debt.setDebt(monthDebt);

			debtService.save(debt);
			break;
		case 2:
			System.out.println("Find All method");
			List<Debt> debtList = debtService.getAll();
			for (Debt d : debtList) {
				System.out.println(d);
			}
			break;
		case 3:
			System.out.println("Find By Id method");
			System.out.print("Enter the id: ");
			debt = debtService.getById(sc.nextLong());
			System.out.println(debt);
			break;
		case 4:
			System.out.println("Update method");
			System.out.print("Enter the id: ");
			debt = debtService.getById(sc.nextLong());
			if (debt != null) {
				System.out.print("Enter the Debt: ");
				debt.setDebt(sc.nextDouble());
			}
			debtService.update(debt);
			break;
		case 5:
			System.out.println("Delete method");
			System.out.print("Enter the id: ");
			debt = debtService.getById(sc.nextLong());
			if (debt != null) {
				debtService.deleteById(debt.getId());
			}
			break;
		default:
			System.err.println("Choice not found !!! Please type number between 1 and 5");
			break;
		}

		sc.close();
	}

}
