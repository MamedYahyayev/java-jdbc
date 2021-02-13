package az.adnsu.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import az.adnsu.dao.DatabaseHelper;
import az.adnsu.dao.TaxOperations;
import az.adnsu.model.Tax;
import az.adnsu.util.Utility;

public class TaxService implements TaxOperations {

	@Override
	public void save(Tax tax) {
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO taxes(tax_name) VALUES (?)";
		try {
			c = DatabaseHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				ps.setString(1, tax.getTaxName());
				ps.execute();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Utility.close(c, ps, null);
		}
	}

	@Override
	public List<Tax> getAll() {
		List<Tax> taxs = new ArrayList<>();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT id , tax_name from taxes";
		try {
			c = DatabaseHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				ps.setMaxRows(20);
				rs = ps.executeQuery();
				while (rs.next()) {
					Tax tax = new Tax();
					tax.setId(rs.getLong("id"));
					tax.setTaxName(rs.getString("tax_name"));

					taxs.add(tax);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Utility.close(c, ps, rs);
		}

		return taxs;
	}

	@Override
	public Tax getById(Long id) {
		Tax tax = null;
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT id , tax_name from taxes where id = ?";
		try {
			c = DatabaseHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				ps.setLong(1, id);
				ps.execute();
				rs = ps.executeQuery();
				if (rs.next()) {
					tax = new Tax();
					tax.setId(rs.getLong("id"));
					tax.setTaxName(rs.getString("tax_name"));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Utility.close(c, ps, rs);
		}

		return tax;
	}

	@Override
	public void update(Tax tax) {
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "UPDATE taxes SET tax_name = ? where id = ?";
		try {
			c = DatabaseHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				ps.setString(1, tax.getTaxName());
				ps.setLong(2, tax.getId());
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
		String sql = "DELETE FROM taxes where id = ?";
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
	public Tax findByTaxName(String taxName) {
		Tax tax = null;
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT id , tax_name from taxes WHERE tax_name = ?";
		try {
			c = DatabaseHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				ps.setString(1, taxName);
				ps.execute();
				rs = ps.executeQuery();
				if (rs.next()) {
					tax = new Tax();
					tax.setId(rs.getLong("id"));
					tax.setTaxName(rs.getString("tax_name"));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Utility.close(c, ps, rs);
		}
		return tax;
	}

}
