package driver;

import db.DBConnector;
import db.DBConstruction;

public class Driver {

	public static void main(String[] args) {
		DBConnector connecter = new DBConnector();
		if(connecter.getConnection()) {
			DBConstruction construction = new DBConstruction();
			construction.createSchema();
			construction.createTableFromFile();
			
		}
	}

}
