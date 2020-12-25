package az.adnsu.main;

import az.adnsu.enums.FamilyRole;
import az.adnsu.enums.Gender;
import az.adnsu.model.FamilyMembers;
import az.adnsu.service.FamilyMembersService;

public class MainClass {

	public static void main(String[] args) {
		FamilyMembersService membersService = new FamilyMembersService();

		FamilyMembers familyMembers = new FamilyMembers();
		familyMembers.setName("Samir");
		familyMembers.setSurname("Samirov");
		familyMembers.setAge(44);
		familyMembers.setGender(Gender.MALE);
		familyMembers.setSalary(3200D);
		familyMembers.setRole(FamilyRole.FATHER);

		membersService.save(familyMembers);
	}

}
