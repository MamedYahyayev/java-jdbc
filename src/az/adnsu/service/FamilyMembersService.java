package az.adnsu.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import az.adnsu.dao.CrudOperations;
import az.adnsu.dao.DatabaseHelper;
import az.adnsu.model.FamilyMembers;
import az.adnsu.util.Utility;

public class FamilyMembersService implements CrudOperations<FamilyMembers> {

	@Override
	public void save(FamilyMembers familyMembers) {
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO family_members(name,surname,age,gender,salary,family_role) "
				+ " VALUES (?,?,?,?,?,?)";

		try {
			c = DatabaseHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				ps.setString(1, familyMembers.getName());
				ps.setString(2, familyMembers.getSurname());
				ps.setInt(3, familyMembers.getAge());
				ps.setString(4, familyMembers.getGender().getValue());
				ps.setDouble(5, familyMembers.getSalary());
				ps.setString(6, familyMembers.getRole().name());
				ps.execute();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Utility.close(c, ps, null);
		}

	}

	@Override
	public List<FamilyMembers> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FamilyMembers getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(FamilyMembers t) {
	}

	@Override
	public void delete(FamilyMembers t) {
	}

}
