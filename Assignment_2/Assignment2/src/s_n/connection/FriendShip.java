package s_n.connection;

import s_n.add.AddRelation;

//Author: Vijeta Tulsiyan

public class FriendShip extends Relationship {
	
    String friend1;
    String friend2;
//Constructors to store friends
	public FriendShip(String friend1, String friend2) {
		super(friend1, friend2);
                this.friend1=friend1;
                this.friend2=friend2;
               
	}

	public String friend(String name1, String name2) {//method for check if friends

		if (((super.getName1().toLowerCase().equals(name1.toLowerCase())) && (super.getName2().toLowerCase().equals(name2.toLowerCase())))
				|| (((super.getName2()).toLowerCase().equals(name1.toLowerCase())) && ((super.getName1()).toLowerCase().equals(name2.toLowerCase())))) {
			return "1";
			

		}else {
			return "0";
		}

	}

	public String checkFriend(String c) {
		if(friend1.equals(c)) {
			
                        return (friend2);
			
		}else if(friend2.equals(c)) {
			
                        return (friend1);
		}
            return null;
		
	}
}
