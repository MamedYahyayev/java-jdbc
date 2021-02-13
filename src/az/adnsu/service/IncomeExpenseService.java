package az.adnsu.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import az.adnsu.dao.DatabaseHelper;
import az.adnsu.dao.IncomeExpenseOperations;
import az.adnsu.model.IncomeExpense;
import az.adnsu.util.Utility;

public class IncomeExpenseService implements IncomeExpenseOperations {

	@Override
	public void save(IncomeExpense incomeExpense) {
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO income_expense(income,expense,result,income_expense_month) " + " VALUES (?,?,?,?)";

		try {
			c = DatabaseHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				ps.setDouble(1, incomeExpense.getIncome());
				ps.setDouble(2, incomeExpense.getExpense());
				ps.setDouble(3, incomeExpense.getResult());
				ps.setObject(4, incomeExpense.getIncomeExpenseMonth());
				ps.execute();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Utility.close(c, ps, null);
		}
	}

	@Override
	public List<IncomeExpense> getAll() {
		List<IncomeExpense> incomeExpenseList = new ArrayList<>();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT id, income, expense , result , income_expense_month FROM income_expense";
		try {
			c = DatabaseHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				ps.setMaxRows(20);
				rs = ps.executeQuery();
				while (rs.next()) {
					IncomeExpense incomeExpense = new IncomeExpense();
					incomeExpense.setId(rs.getLong("id"));
					incomeExpense.setIncome(rs.getDouble("income"));
					incomeExpense.setExpense(rs.getDouble("expense"));
					incomeExpense.setResult(rs.getDouble("result"));
					incomeExpense.setIncomeExpenseMonth(rs.getInt("income_expense_month"));

					incomeExpenseList.add(incomeExpense);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Utility.close(c, ps, rs);
		}

		return incomeExpenseList;
	}

	@Override
	public IncomeExpense getById(Long id) {
		IncomeExpense incomeExpense = null;
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT id, income, expense , result , income_expense_month FROM income_expense WHERE id = ?";
		try {
			c = DatabaseHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				ps.setLong(1, id);
				ps.execute();
				rs = ps.executeQuery();
				if (rs.next()) {
					incomeExpense = new IncomeExpense();
					incomeExpense.setId(rs.getLong("id"));
					incomeExpense.setIncome(rs.getDouble("income"));
					incomeExpense.setExpense(rs.getDouble("expense"));
					incomeExpense.setResult(rs.getDouble("result"));
					incomeExpense.setIncomeExpenseMonth(rs.getInt("income_expense_month"));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Utility.close(c, ps, rs);
		}

		return null;
	}

	@Override
	public void update(IncomeExpense incomeExpense) {
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "UPDATE income_expense SET income = ?, expense = ?, result = ?  where id = ?";
		try {
			c = DatabaseHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				ps.setDouble(1, incomeExpense.getIncome());
				ps.setDouble(2, incomeExpense.getExpense());
				ps.setDouble(3, incomeExpense.getResult());
				ps.setLong(4, incomeExpense.getId());
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
		String sql = "DELETE FROM income_expense where id = ?";
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

}
