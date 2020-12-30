package az.adnsu.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import az.adnsu.dao.DatabaseHelper;
import az.adnsu.dao.DebtOperations;
import az.adnsu.model.Debt;
import az.adnsu.model.Tax;
import az.adnsu.util.DateUtility;
import az.adnsu.util.Utility;

public class DebtService implements DebtOperations {

	@Override
	public void save(Debt debt) {
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO taxes_debt(month,debt,isPaid,taxes_id) VALUES (?,?,?,?)";

		try {
			c = DatabaseHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				ps.setInt(1, debt.getMonth());
				ps.setDouble(2, debt.getDebt());
				ps.setBoolean(3, debt.getIsPaid());
				ps.setLong(4, debt.getTax().getId());
				ps.execute();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Utility.close(c, ps, null);
		}
	}

	@Override
	public List<Debt> getAll() {
		List<Debt> debtList = new ArrayList<>();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select taxes_debt.id, taxes_debt.month, taxes_debt.debt, taxes_debt.isPaid, taxes.id tax_id, taxes.tax_name "
				+ " from taxes_debt inner join taxes on taxes.id = taxes_debt.taxes_id";
		try {
			c = DatabaseHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					Debt debt = new Debt();

					Tax tax = new Tax();
					tax.setId(rs.getLong("tax_id"));
					tax.setTaxName(rs.getString("tax_name"));

					debt.setId(rs.getLong("id"));
					debt.setMonth(rs.getInt("month"));
					debt.setDebt(rs.getDouble("debt"));
					debt.setIsPaid(rs.getBoolean("isPaid"));
					debt.setTax(tax);

					debtList.add(debt);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Utility.close(c, ps, rs);
		}

		return debtList;
	}

	@Override
	public Debt getById(Long id) {
		Debt debt = null;
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select taxes_debt.id, taxes_debt.month, taxes_debt.debt, taxes_debt.isPaid, taxes.id tax_id, taxes.tax_name "
				+ "	from taxes_debt inner join taxes on taxes.id = taxes_debt.taxes_id WHERE taxes_debt.id = ? ";
		try {
			c = DatabaseHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				ps.setLong(1, id);
				ps.execute();
				rs = ps.executeQuery();
				if (rs.next()) {
					debt = new Debt();

					Tax tax = new Tax();
					tax.setId(rs.getLong("tax_id"));
					tax.setTaxName(rs.getString("tax_name"));

					debt.setId(rs.getLong("id"));
					debt.setMonth(rs.getInt("month"));
					debt.setDebt(rs.getDouble("debt"));
					debt.setIsPaid(rs.getBoolean("isPaid"));
					debt.setTax(tax);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Utility.close(c, ps, rs);
		}

		return debt;
	}

	@Override
	public void update(Debt debt) {
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "UPDATE taxes_debt SET debt = ? where id = ?";
		try {
			c = DatabaseHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				ps.setDouble(1, debt.getDebt());
				ps.setLong(2, debt.getId());
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
		String sql = "DELETE FROM taxes_debt where id = ?";
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
	public boolean paidDebt(Long id, Boolean isPaid) {
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "UPDATE taxes_debt SET isPaid = ? where id = ?";
		try {
			c = DatabaseHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				ps.setBoolean(1, isPaid);
				ps.setLong(2, id);
				ps.execute();
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Utility.close(c, ps, null);
		}
		return false;
	}

	@Override
	public Double sumOfDebtsByCurrentMonth() {
		List<Debt> debts = getAll();
		
		Double sumOfdebt = debts.stream()
				.filter(this::filterDebt)
				.map(Debt::getDebt)
				.reduce((double) 0, (total,num) -> total + num);

		return sumOfdebt;
	}

	boolean filterDebt(Debt debt) {
		int currentMonth = DateUtility.getCurrentMonth();
		return debt.getTax() != null && debt.getMonth() == currentMonth && debt.getIsPaid() == false;
	}
}
