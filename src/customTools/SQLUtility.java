package customTools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Set;

import DBUtil.DBUtility;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class SQLUtility {
	static Scanner in = new Scanner(System.in);
	public static Set<String> resultset = new HashSet<String>();
	// public static Map<String, String> resultMap = new HashMap<String,
	// String>();
	public static Set<String> queryHistory = new HashSet<String>();

	public SQLUtility() {

	}

	public static void executeSQL() {

		System.out.println("Enter username");
		String username = in.nextLine();
		System.out.println("Enter password");
		String password = in.nextLine();
		while (true) {
			System.out.println("SQL>");
			String query = in.nextLine();
			queryHistory.add(query);
			String result = null;
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;

			try {
				int count = 0;
				Class.forName("oracle.jdbc.driver.OracleDriver");
				// con = DriverManager.getConnection("jdbc:oracle:thin:sys as
				// sysdba/oracle@localhost:1521:orcl");
				con = DriverManager
						.getConnection("jdbc:oracle:thin:" + username + "/" + password + "@localhost:1521:orcl");
				stmt = con.createStatement();
				rs = stmt.executeQuery(query);
				ResultSetMetaData rsmd = rs.getMetaData();
				for (int i = 1; i < rsmd.getColumnCount() + 1; i++) {
					System.out.print(" " + rsmd.getColumnName(i));
				}
				System.out.println("\n" + "---------------------------------------------------");
				while (rs.next() && count < 10) {
					for (int i = 1; i < rsmd.getColumnCount() + 1; i++) {
						System.out.print(rs.getString(i) + "\t");
						result += rs.getString(i) + "\t";
					}
					System.out.println("\n");
					result += "\n";
					count++;
				}
				resultset.add(result);
				System.out.println(resultset);
			} catch (SQLException e) {
				System.err.println("You have enetered an invalid sql statement");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.err.println("Data you are searching for is unavailable");
				e.printStackTrace();
			} finally {
				try {
					// rs.close();
					stmt.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static ResultSet runSQL( String query) {
		while (true) {
			System.out.println("SQL>");
			queryHistory.add(query);
			String result = null;
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;

			try {
				int count = 0;
				Class.forName("oracle.jdbc.driver.OracleDriver");
				// con = DriverManager.getConnection("jdbc:oracle:thin:sys as
				// sysdba/oracle@localhost:1521:orcl");
				con = DriverManager
						.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
				stmt = con.createStatement();
				rs = stmt.executeQuery(query);
//				ResultSetMetaData rsmd = rs.getMetaData();
//				for (int i = 1; i < rsmd.getColumnCount() + 1; i++) {
//					System.out.print(" " + rsmd.getColumnName(i));
//				}
//				System.out.println("\n" + "---------------------------------------------------");
//				while (rs.next() && count < 10) {
//					for (int i = 1; i < rsmd.getColumnCount() + 1; i++) {
//						System.out.print(rs.getString(i) + "\t");
//						result += rs.getString(i) + "\t";
//					}
//					System.out.println("\n");
//					result += "\n";
//					count++;
//				}
//				resultset.add(result);
//				System.out.println(resultset);
				
			} catch (SQLException e) {
				System.err.println("You have enetered an invalid sql statement");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.err.println("Data you are searching for is unavailable");
				e.printStackTrace();
			} finally {
				try {
					// rs.close();
					stmt.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		
			}
        return rs;
		}				
	}

}