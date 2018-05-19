package main;
/* 
 Author:- Vijeta Tulsiyan
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hsqldb.Server;

import s_n.People.Adult;
import s_n.People.Child;
import s_n.People.Person;
import s_n.add.AddPerson;
import s_n.add.AddRelation;
import s_n.connection.Classmate;
import s_n.connection.Colleague;
import s_n.connection.Couple;
import s_n.connection.FriendShip;
import s_n.connection.Relationship;


public class DatabaseHandler {
	private static Connection connection = null;
	
	public Connection getConnection() {
		return connection;
	}
	
	public static boolean setDatabase()
	{
		boolean isSuccess = true;
		try {
			Server hsqlServer = new Server();
			hsqlServer.setLogWriter(null);
			hsqlServer.setSilent(true);
			hsqlServer.setDatabaseName(0, "mininetdb");		
			hsqlServer.setDatabasePath(0, "file:db/mininetdb");
			hsqlServer.start();
			
			Class.forName("org.hsqldb.jdbcDriver");
			connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/mininetdb", "sa", "");
			if (connection != null) {
				System.out.print("Database connection success");
			}
			else {
				System.out.print("Database connection is not success");
				isSuccess = false;
			}
		}
		catch (Exception ex) {
			System.out.print("Error occured while starting database server: " + ex.getMessage());
			isSuccess = false;
		}
		return isSuccess;
	}
	
	public static void readPeople(){
		try {
			Statement stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery("SELECT Id, FirstName, LastName, Age, Gender, Status, Image FROM People");
	         
	         while(result.next()){
	        	 String fname = result.getString("FirstName");
	        	 String lname = result.getString("LastName");
	        	 
	        	 int age = result.getInt("Age");
	        	 int gender = result.getString("Gender").trim().equals("F") ? 0 : 1;	        	 
	        	 
	        	 String status = result.getString("Status");
	        	 boolean picture = result.getBoolean("Image");
	        	 
	        	 if (age >= 16) {						
	        		 AddPerson.per[Person.max] = new Adult(fname, lname, gender, age, status, picture);
	        	 }
	        	 else {						
	        		 AddPerson.per[Person.max] = new Child(fname, lname, gender, age, status, picture);
	        	 }
	         }
		}
		catch (SQLException ex) {
			System.out.print("Error occured while reading Peoples from database: " + ex.getMessage());
			ex.printStackTrace();		
		}
	}
	
	public static void readRelationship(){
		try {
			Statement stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery("SELECT Id, FirstNameFirst, FirstNameSecond, RelationshipType FROM Relationship");
	         
	         while(result.next()){
	        	 String name1 = result.getString("FirstNameFirst");
	        	 String name2 = result.getString("FirstNameSecond");	        	 
	        	 
	        	 String relationship = result.getString("RelationshipType");
	        	 int type = 0;
	        	 switch (relationship.toLowerCase()) {
	        	 	case "friend":
	        	 		type = 1;
	        	 		break;
	        	 	case "colleague":
	        	 		type = 2;
	        	 		break;
	        	 	case "classmate":
	        	 		type = 3;
	        	 		break;
	        	 	case "couple":
	        	 		type = 4;
	        	 		break;
	        	 }
	        	 AddRelation relation = new AddRelation();
	        	 if (type == 0) {
	        		 relation.AddRelation(name1, name2, relationship);
	        	 }
	        	 else {
	        		 relation.AddRelation(name1, name2, type);
	        	 }	        	 
	         }
		}
		catch (SQLException ex) {
			System.out.print("Error occured while reading Peoples from database: " + ex.getMessage());
			ex.printStackTrace();		
		}
	}
	
	public static void writePeople(){
		try {
			String ids = "";
			Statement stmt = connection.createStatement(); 
			
			ResultSet result = stmt.executeQuery("SELECT Id FROM People");
			while(result.next()){
				ids += "," + result.getString("Id");	        	 
	        }
			ids = ids.substring(1);
         
			for (int i = 0; i < Person.max; i++) {
				if ((AddPerson.per[i] instanceof Person)) {					
					Person person = AddPerson.per[i];
					
					String sql = "INSERT INTO People (FirstName, LastName, Gender, Age, Status, Image) VALUES ('" + 
							person.getFname() + "','" +
							person.getLname() + "','" +
							(person.getSex() == 1 ? "M" : "F") + "'," +
							String.valueOf(person.getAge()) + ",'" +
							(person.getStatus() != null ? person.getStatus() : "") + "','" +
							(person.isImage() ? 1 : 0) + "')";
					
					stmt.executeUpdate(sql); 
			        connection.commit();
				}
			}
			
			result = stmt.executeQuery("DELETE FROM People WHERE Id IN (" + ids + ")");
			connection.commit();
		}
		catch (SQLException ex) {
			System.out.print("Error occured while reading Peoples from database: " + ex.getMessage());
			ex.printStackTrace();		
		}
	}
	
	public static void writeRelationship(){
		try {
			String ids = "";
			Statement stmt = connection.createStatement(); 
			
			ResultSet result = stmt.executeQuery("SELECT Id FROM Relationship");
			while(result.next()){
				ids += "," + result.getString("Id");	        	 
	        }
			if (ids != "") ids = ids.substring(1);
         
			for (int i = 0; i < AddRelation.numre; i++) {
				if ((AddRelation.re[i] instanceof Relationship)) {					
					Relationship relationship = AddRelation.re[i];					
					
					String relationshipType = null;
					if (relationship instanceof Couple) {
						if(((Couple)relationship).getChild() == null){
							relationshipType = "couple";
						}
						else{
							continue;
						}
					} 
					else if (relationship instanceof FriendShip) {
						relationshipType = "friend";
					}
					else if (relationship instanceof Colleague) {
						relationshipType = "colleague";
					}
					else if (relationship instanceof Classmate) {
						relationshipType = "classmate";
					}
					
					String sql = "INSERT INTO Relationship (FirstNameFirst, FirstNameSecond, RelationshipType) VALUES ('" + 
							relationship.getName1() + "','" +
							relationship.getName2() + "','" +
							relationshipType + "')";
					
					stmt.executeUpdate(sql); 
			        connection.commit();
				}
			}
			
			if (ids != "") {
				result = stmt.executeQuery("DELETE FROM Relationship WHERE Id IN (" + ids + ")");
				connection.commit();
			}
		}
		catch (SQLException ex) {
			System.out.print("Error occured while reading Peoples from database: " + ex.getMessage());
			ex.printStackTrace();		
		}
	}
}
