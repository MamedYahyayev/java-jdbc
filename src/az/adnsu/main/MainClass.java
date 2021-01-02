package az.adnsu.main;

import java.util.List;
import java.util.Scanner;
import az.adnsu.model.FamilyMembers;
import az.adnsu.service.FamilyMembersService;

public class MainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		FamilyMembersService membersService = new FamilyMembersService();
		FamilyMembers familyMembers = new FamilyMembers();
		System.out.print(
				"Choose Operations: 1. Save , 2. Find All , 3. Find By Id , 4. Update , 5. Delete , 6. Greater Than Age; Choice: ");
		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			System.out.println("Save method");

			System.out.print("Enter the name: ");
			String name = sc.next();

			System.out.print("Enter the surname: ");
			String surname = sc.next();

			System.out.print("Enter the age: ");
			int age = sc.nextInt();

			System.out.print("Enter the gender, Please type m for male or type f for female: ");
			String gender = sc.next();

			System.out.print("Enter the salary: ");
			Double salary = sc.nextDouble();

			System.out.print("Enter the role, Please type your role: ");
			String role = sc.next();

			familyMembers.setName(name);
			familyMembers.setSurname(surname);
			familyMembers.setAge(age);
			familyMembers.setGender(gender);
			familyMembers.setSalary(salary);
			familyMembers.setRole(role.toUpperCase());

			membersService.save(familyMembers);
			break;

		case 2:
			System.out.println("Find All method");
			List<FamilyMembers> membersList = membersService.getAll();
			for (FamilyMembers members : membersList) {
				System.out.println(members);
			}
			break;
		case 3:
			System.out.println("Find By Id method");
			System.out.print("Enter the id: ");
			familyMembers = membersService.getById(sc.nextLong());
			System.out.println(familyMembers);
			break;
		case 4:
			System.out.println("Update method");
			System.out.print("Enter the id: ");
			familyMembers = membersService.getById(sc.nextLong());
			if (familyMembers != null) {
				System.out.print("Enter the age: ");
				familyMembers.setAge(sc.nextInt());

				System.out.print("Enter tha salary: ");
				familyMembers.setSalary(sc.nextDouble());
			}
			membersService.update(familyMembers);
			break;
		case 5:
			System.out.println("Delete method");
			familyMembers = membersService.getById(5L);
			if (familyMembers != null) {
				membersService.deleteById(familyMembers.getId());
			}
			break;
		case 6:
			System.out.println("Greatet Than Age Method");
			membersList = membersService.findAllByAgeGreaterThan(20);
			for (FamilyMembers members : membersList) {
				System.out.println(members);
			}
			break;
		default:
			System.err.println("Choice not found !!! Please type number between 1 and 5");
			break;
		}

		sc.close();
	}

}
