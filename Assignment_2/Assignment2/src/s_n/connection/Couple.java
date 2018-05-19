package s_n.connection;
//Author: Vijeta Tulsiyan

import s_n.method.LookUp;


//Student number:s3596156

//Creating Subclass of abstract class Relationship 

public class Couple extends Relationship {// class for store couple

	private String child;
	private String father;
	private String mother;
	private int id1 = 999;
	private int id2 = 998;
	private int sex = 99;
	// 2 Constructors for Couple class

	public Couple(String name1, String name2) {
		super(name1, name2);
		id1 = new LookUp().lookUp(name1);
		id2 = new LookUp().lookUp(name2);
		
			this.father = name1;
			this.mother = name2;
		
	}

	public Couple(String name1, String name2, String child) {
		this(name1, name2);
		this.child = child;
		//sex = new LookUp().lookUpSex(child);
	}

	// Getters and setters

	public String getChild() {// getter
		return child;
	}

	public void setChild(String child) {// setter
		this.child = child;
	}



	// Method to check if the child belongs to him/her after checking gender

	public int getSex() {                
		return (new LookUp().lookUpSex(child));
}

    public String getFather() {
        return father;
    }

    public String getMother() {
        return mother;
    }

    public String family(String cheak) {
      
        return null;
    }



	// Method to find if the person has a friend
	// Overrides method in Relationship class

	

	// Method to check if two person are in the Relationship class
   
	public String friend(String name1, String name2) {// override friend for couple
		if (((super.getName1().toLowerCase().equals(name1.toLowerCase())) && (super.getName2().toLowerCase().equals(name2.toLowerCase())))
				|| (((super.getName2()).toLowerCase().equals(name1.toLowerCase())) && ((super.getName1()).toLowerCase().equals(name2.toLowerCase())))) {
			return "4";

		} else {
			return "0";
		}

	}
        
        
        public String checkFriend(String c) {
		if(father.equals(c)) {
			
                        return (mother);
			
		}else if(mother.equals(c)) {
			
                        return (father);
		}
            return null;
		
	}
}
