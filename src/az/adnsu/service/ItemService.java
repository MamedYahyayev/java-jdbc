package az.adnsu.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import az.adnsu.dao.DatabaseHelper;
import az.adnsu.dao.ItemOperations;
import az.adnsu.model.Items;
import az.adnsu.util.Utility;

public class ItemService implements ItemOperations {

	@Override
	public void save(Items items) {
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO items(item_name,item_type,item_price,bought_at,is_available) "
				+ " VALUES (?,?,?,?,?)";

		try {
			c = DatabaseHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				ps.setString(1, items.getItemName());
				ps.setString(2, items.getItemType());
				ps.setDouble(3, items.getItemPrice());
				ps.setObject(4, items.getBoughtAt());
				ps.setBoolean(5, items.getIsAvailable());
				ps.execute();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Utility.close(c, ps, null);
		}
	}

	@Override
	public List<Items> getAll() {
		List<Items> itemsList = new ArrayList<>();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT id, item_name, item_type, item_price ,bought_at , is_available FROM items";
		try {
			c = DatabaseHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					Items items = new Items();
					items.setId(rs.getLong("id"));
					items.setItemName(rs.getString("item_name"));
					items.setItemType(rs.getString("item_type"));
					items.setItemPrice(rs.getDouble("item_price"));
					items.setBoughtAt(rs.getDate("bought_at"));
					items.setIsAvailable(rs.getBoolean("is_available"));

					itemsList.add(items);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Utility.close(c, ps, rs);
		}

		return itemsList;
	}

	@Override
	public Items getById(Long id) {
		Items items = null;
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT id, item_name, item_type, item_price ,bought_at , is_available FROM items WHERE id = ?";
		try {
			c = DatabaseHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				ps.setLong(1, id);
				ps.execute();
				rs = ps.executeQuery();
				if (rs.next()) {
					items = new Items();
					items.setId(rs.getLong("id"));
					items.setItemName(rs.getString("item_name"));
					items.setItemType(rs.getString("item_type"));
					items.setItemPrice(rs.getDouble("item_price"));
					items.setBoughtAt(rs.getDate("bought_at"));
					items.setIsAvailable(rs.getBoolean("is_available"));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Utility.close(c, ps, rs);
		}

		return items;
	}

	@Override
	public void update(Items items) {
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "UPDATE items SET item_name = ?, item_price = ? where id = ?";
		try {
			c = DatabaseHelper.getConnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				ps.setString(1, items.getItemName());
				ps.setDouble(2, items.getItemPrice());
				ps.setLong(3, items.getId());
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
		String sql = "DELETE FROM items where id = ?";
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
