/**
 * @author Bin Lan (blan)
 */
package db;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConstruction {

	public void createSchema() {
		PreparedStatement pre;
		try {
			Connection connect = DBConnector.connection;
			pre = connect
					.prepareStatement("CREATE SCHEMA IF NOT EXISTS `RecommendationDB` DEFAULT CHARACTER SET big5 ;");
			pre.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void createTableFromFile() {

		try (BufferedReader br = new BufferedReader(new FileReader(
				"CreateTable.sql"))) {
			String line = null;
			StringBuilder sb = new StringBuilder();
			Connection connect = DBConnector.connection;
			PreparedStatement pre = connect.prepareStatement("");
			while ((line = br.readLine()) != null) {
				if (line.trim().equals("")) {
					System.out.println(sb.toString());
					String sql = sb.toString().trim();
					if (sql.length() > 1)
						pre.addBatch(sql);
					sb = new StringBuilder();
					continue;
				}
				sb.append(line);
			}
			pre.executeBatch();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

	}
}
