package az.adnsu.main;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import az.adnsu.model.Items;
import az.adnsu.service.ItemService;
import az.adnsu.util.DateUtility;
import az.adnsu.util.Utility;

public class ItemMainClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ItemService itemService = new ItemService();
		Items item = new Items();
		Utility.getChoiceMessage();
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Save method");

			System.out.print("Enter the Item name: ");
			sc.nextLine();
			String itemName = sc.nextLine();

			System.out.print("Enter the Item type: ");
			String itemType = sc.nextLine();

			System.out.print("Enter the Item price: ");
			Double itemPrice = sc.nextDouble();

			sc.nextLine();
			System.out.println("Enter the Item Bought at Time: ");
			System.out.print("Year: ");
			int year = sc.nextInt();

			System.out.print("Month: ");
			int month = sc.nextInt();

			System.out.print("Day: ");
			int day = sc.nextInt();

			Date boughtAt = DateUtility.getDateFromCalendar(year, month, day);

			item.setItemName(itemName);
			item.setItemType(itemType);
			item.setItemPrice(itemPrice);
			item.setBoughtAt(boughtAt);

			itemService.save(item);
			break;
		case 2:
			System.out.println("Find All method");
			List<Items> itemList = itemService.getAll();
			for (Items items : itemList) {
				System.out.println(items);
			}
			break;
		case 3:
			System.out.println("Find By Id method");
			System.out.print("Enter the id: ");
			item = itemService.getById(sc.nextLong());
			System.out.println(item);
			break;
		case 4:
			System.out.println("Update method");
			System.out.print("Enter the id: ");
			item = itemService.getById(sc.nextLong());
			if (item != null) {
				System.out.print("Enter the Item Name: ");
				sc.nextLine();
				item.setItemName(sc.nextLine());

				System.out.print("Enter the Item price: ");
				item.setItemPrice(sc.nextDouble());
			}
			itemService.update(item);
			break;
		case 5:
			System.out.println("Delete method");
			System.out.print("Enter the id: ");
			item = itemService.getById(sc.nextLong());
			if (item != null) {
				itemService.deleteById(item.getId());
			}
			break;
		default:
			System.err.println("Choice not found !!! Please type number between 1 and 5");
			break;
		}

		sc.close();
	}

}
