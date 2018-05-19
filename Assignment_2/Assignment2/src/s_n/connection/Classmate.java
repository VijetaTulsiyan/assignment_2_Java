package s_n.connection;
//Author: Shuai Gao

public class Classmate extends Relationship {
String class1;
String class2;
	public Classmate(String friend1, String friend2) {
		super(friend1, friend2);
                class1=friend1;
                class2=friend2;
		// TODO Auto-generated constructor stub
	}

	public String friend(String name1, String name2) {//method for check if friends

		if (((super.getName1().toLowerCase().equals(name1.toLowerCase())) && (super.getName2().toLowerCase().equals(name2.toLowerCase())))
				|| (((super.getName2()).toLowerCase().equals(name1.toLowerCase())) && ((super.getName1()).toLowerCase().equals(name2.toLowerCase())))) {
			return "3";
			

		}else {
			return "0";
		}

	}

 public String checkFriend(String c) {
		if(class1.equals(c)) {
			
                        return (class2);
			
		}else if(class2.equals(c)) {
			
                        return (class1);
		}
            return null;
		
	}

}
