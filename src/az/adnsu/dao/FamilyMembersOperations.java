package az.adnsu.dao;

import java.util.List;

import az.adnsu.model.FamilyMembers;

public interface FamilyMembersOperations extends CrudOperations<FamilyMembers, Long> {
	
	List<FamilyMembers> findAllByAgeGreaterThan(Integer age);
	
	Double findSalarySum();

}
