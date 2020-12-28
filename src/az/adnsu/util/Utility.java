package az.adnsu.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Utility {

	public static void close(Connection c, PreparedStatement ps, ResultSet rs) {
		try {
			if (c != null)
				c.close();
			if (ps != null)
				ps.close();
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void getChoiceMessage() {
		System.out.print("Choose Operations: 1. Save , 2. Find All , 3. Find By Id , 4. Update , 5. Delete; Choice: ");
	}

	public static void getChoiceMessage(String[] choices) {
		String choiceMessage = "Choose Operations: 1. Save , 2. Find All , 3. Find By Id , 4. Update , 5. Delete, ";
		int num = 6;
		if (choices != null) {
			for (String choice : choices) {
				choiceMessage += num + "." + choice;
			}
		}
		choiceMessage += "; Choice:";

		System.out.println(choiceMessage);
	}

}
