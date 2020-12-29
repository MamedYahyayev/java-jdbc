
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import az.adnsu.model.FamilyMembers;

public class FamilyMembersServiceTest {

	@Test
	void testFindMaxSalary() {
		FamilyMembers samir = new FamilyMembers("Samir", "Samirov", 1700D);
		FamilyMembers lale = new FamilyMembers("Lale", "Samirova", 1200D);
		FamilyMembers lale2 = new FamilyMembers("Lale", "Samirova", null);

		List<FamilyMembers> members = new ArrayList<>();
		members.add(samir);
		members.add(lale);
		members.add(lale2);

		Double sum = members.stream()
									.filter(Objects::nonNull)
									.map(FamilyMembers::getSalary)
									.filter(Objects::nonNull)
									.reduce((double) 0,(total, number) -> total + number);

		Assertions.assertEquals(2900, sum);

	}

}
