package s_n.connection;
//Author: Vijeta Tulsiyan

import s_n.add.AddRelation;
import s_n.method.Forre;


//Creating Abstract class Relationship
public abstract class Relationship implements Forre {
//instance variables to store names
	private String name1;
	private String name2;
        
	
	//Getters and Setters

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	//Constructor
	public Relationship(String friend1, String friend2) {
		this.name1 = friend1;
		this.name2 = friend2;
		AddRelation.numre++;

	}

	//Abstract Method to add 2 names as friend
	public String friend(String name1, String name2) {
		return null;
		
	};

	//Abstract Method to add 2 names as family
	public String family(String cheak) {
            return null;
	}
	
	//Concrete Method to check if 2 names are friends
	public String checkFriend(String c) {
	
            return null;
		
	}
}
