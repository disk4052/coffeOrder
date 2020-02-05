package main;

import db.DBConnection;
import view.Viewer;

public class main {
	public static void main(String[] args) {
		DBConnection.initConnection();
		new Viewer();
	}
}
