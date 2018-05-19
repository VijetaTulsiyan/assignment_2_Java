package s_n.connection;
//Author: Shuai Gao

public class Colleague extends Relationship {
String co1;
String co2;
	public Colleague(String friend1, String friend2) {
		super(friend1, friend2);
               co1=friend1;
               co2=friend2;
		// TODO Auto-generated constructor stub
	}

	public String friend(String name1, String name2) {//method for check if friends

		if (((super.getName1().toLowerCase().equals(name1.toLowerCase())) && (super.getName2().toLowerCase().equals(name2.toLowerCase())))
				|| (((super.getName2()).toLowerCase().equals(name1.toLowerCase())) && ((super.getName1()).toLowerCase().equals(name2.toLowerCase())))) {
			return "2";
			

		}else {
			return "0";
		}

	}
         public String checkFriend(String c) {
		if(co1.equals(c)) {
			
                        return (co2);
			
		}else if(co2.equals(c)) {
			
                        return (co1);
		}
            return null;
		
	}



}
