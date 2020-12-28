package az.adnsu.main;

import java.util.List;
import java.util.Scanner;

import az.adnsu.model.Tax;
import az.adnsu.service.TaxService;
import az.adnsu.util.Utility;

public class TaxMainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TaxService taxService = new TaxService();
		Tax tax = new Tax();
		Utility.getChoiceMessage(new String[] { "Find By Tax Name" });
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Save method");
			System.out.print("Enter the Tax name: ");
			String taxName = sc.next();
			tax.setTaxName(taxName);
			taxService.save(tax);
			break;
		case 2:
			System.out.println("Find All method");
			List<Tax> taxList = taxService.getAll();
			for (Tax taxs : taxList) {
				System.out.println(taxs);
			}
			break;
		case 3:
			System.out.println("Find By Id method");
			System.out.print("Enter the id: ");
			tax = taxService.getById(sc.nextLong());
			System.out.println(tax);
			break;
		case 4:
			System.out.println("Update method");
			System.out.print("Enter the id: ");
			tax = taxService.getById(sc.nextLong());
			if (tax != null) {
				System.out.print("Enter the Tax Name: ");
				sc.nextLine();
				tax.setTaxName(sc.nextLine());
			}
			taxService.update(tax);
			break;
		case 5:
			System.out.println("Delete method");
			System.out.print("Enter the id: ");
			tax = taxService.getById(sc.nextLong());
			if (tax != null) {
				taxService.deleteById(tax.getId());
			}
			break;
		case 6:
			System.out.println("Find By Tax Name method");
			System.out.print("Enter the Tax Name: ");
			sc.nextLine();
			tax = taxService.findByTaxName(sc.nextLine());
			System.out.println(tax);
			break;
		default:
			System.err.println("Choice not found !!! Please type number between 1 and 5");
			break;
		}

		sc.close();

	}

}
