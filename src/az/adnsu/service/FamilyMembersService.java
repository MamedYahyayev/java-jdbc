package az.adnsu.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import az.adnsu.dao.DatabaseHelper;
import az.adnsu.dao.FamilyMembersOperations;
import az.adnsu.model.FamilyMembers;
import az.adnsu.util.Utility;

public class FamilyMembersService implements FamilyMembersOperations {

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
				ps.setString(4, familyMembers.getGender());
				ps.setDouble(5, familyMembers.getSalary());
				ps.setString(6, familyMembers.getRole());
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
		List<FamilyMembers> membersList = new ArrayList<>();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT id , name , surname , age , gender , salary , family_role from family_members";
		try {
			c = DatabaseHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					FamilyMembers members = new FamilyMembers();
					members.setId(rs.getLong("id"));
					members.setName(rs.getString("name"));
					members.setSurname(rs.getString("surname"));
					members.setAge(rs.getInt("age"));
					members.setSalary(rs.getDouble("salary"));
					members.setGender(rs.getString("gender"));
					members.setRole(rs.getString("family_role"));

					membersList.add(members);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Utility.close(c, ps, rs);
		}

		return membersList;
	}

	@Override
	public FamilyMembers getById(Long id) {
		FamilyMembers members = null;
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT id , name , surname , age , gender , salary , family_role from family_members where id = ?";
		try {
			c = DatabaseHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				ps.setLong(1, id);
				ps.execute();
				rs = ps.executeQuery();
				while (rs.next()) {
					members = new FamilyMembers();
					members.setId(rs.getLong("id"));
					members.setName(rs.getString("name"));
					members.setSurname(rs.getString("surname"));
					members.setAge(rs.getInt("age"));
					members.setSalary(rs.getDouble("salary"));
					members.setGender(rs.getString("gender"));
					members.setRole(rs.getString("family_role"));

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Utility.close(c, ps, rs);
		}

		return members;
	}

	@Override
	public void update(FamilyMembers familyMembers) {
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "UPDATE family_members SET age = ?, salary = ? where id = ?";
		try {
			c = DatabaseHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				ps.setInt(1, familyMembers.getAge());
				ps.setDouble(2, familyMembers.getSalary());
				ps.setLong(3, familyMembers.getId());
				ps.execute();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Utility.close(c, ps, null);
		}
	}

	@Override
	public void deleteById(Long id) {
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM family_members where id = ?";
		try {
			c = DatabaseHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				ps.setLong(1, id);
				ps.execute();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Utility.close(c, ps, null);
		}
	}

	@Override
	public List<FamilyMembers> findAllByAgeGreaterThan(Integer age) {
		List<FamilyMembers> membersList = new ArrayList<>();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT id , name , surname , age , gender , salary , family_role from family_members where age > ?";
		try {
			c = DatabaseHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				ps.setInt(1, age);
				rs = ps.executeQuery();
				while (rs.next()) {
					FamilyMembers members = new FamilyMembers();
					members.setId(rs.getLong("id"));
					members.setName(rs.getString("name"));
					members.setSurname(rs.getString("surname"));
					members.setAge(rs.getInt("age"));
					members.setSalary(rs.getDouble("salary"));
					members.setGender(rs.getString("gender"));
					members.setRole(rs.getString("family_role"));

					membersList.add(members);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Utility.close(c, ps, rs);
		}

		return membersList;
	}

	@Override
	public Double findSalarySum() {
		List<FamilyMembers> members = getAll();
		Double sumOfSalary = members.stream()
										.filter(Objects::nonNull)
										.map(FamilyMembers::getSalary)
										.filter(Objects::nonNull)
										.reduce((double) 0,(total, number) -> total + number);
		return sumOfSalary;
	}

}


 
