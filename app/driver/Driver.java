package driver;

import db.DBConnector;
import db.DBConstruction;

public class Driver {

	public static void main(String[] args) {
		
		if (DBConnector.getConnection()) {
			DBConstruction construction = new DBConstruction();
			construction.createSchema();
			construction.createTableFromFile();
		}
	}

}
