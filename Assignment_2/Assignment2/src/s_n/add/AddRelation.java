package s_n.add;
//author:Shuai Gao
//Student number:s3596156

import s_n.method.LookUp;
import s_n.add.AddPerson;
import s_n.connection.Classmate;
import s_n.connection.Colleague;
import s_n.connection.Couple;
import s_n.connection.FriendShip;
import s_n.connection.Relationship;
import s_n.connection.Family;

//Creating class to add count and add relationship
public class AddRelation {

    public static int numre; // count the relationship number
    public static Relationship re[] = new Relationship[100];
    // protected static Relationship 

    public AddRelation() {

    }



    //Method to add to person to the Friendship after checking their age and age difference
    public boolean AddRelation(String name1, String name2, int type) {
        int n1 = new LookUp().lookUpAge(name1);// search input in list get identifier
        int n2 = new LookUp().lookUpAge(name2);
        boolean add = false;
        if (AddMethod.compareCan(n1, n2, type)) {
            switch (type) {
                case 1:
                    re[numre] = new FriendShip(name1, name2);

                    add = true;
                    break;

                case 2:
                    re[numre] = new Colleague(name1, name2);

                    add = true;
                    break;
                case 3:
                    re[numre] = new Classmate(name1, name2);

                    add = true;
                    break;
                case 4:
                    if (!AddMethod.sameSex(name1, name2)) {
                      
                        
                      
                            
                            
                        if ((countRe(new LookUp().lookUp(name1), 4).equals("0")) && (countRe(new LookUp().lookUp(name2), 4).equals("0"))) {

                            re[numre] = new Couple(name1, name2);

                            add = true;
                        } else {
                         
                            if (countRe(new LookUp().lookUp(name1), 4).substring(1,countRe(new LookUp().lookUp(name1), 4).length())
                                    .trim().toLowerCase().equals(name2.trim().toLowerCase())) {

                             //   re[numre] = new Couple(name1, name2);
                                add = true;

                            } else {

                                System.out.println("NoAvailableException ");
                                add=false;
                            }
                        }
                        break;
                    }

                    add = false;

            }
        }

        return add;

    }

    //Method to create family of father, mother and child after checking their gender and age
    public boolean AddRelation(String name1, String name2, String child) {

        int n1 = new LookUp().lookUpAge(name1);
        int n2 = new LookUp().lookUpAge(name2);

        if(AddRelation(name1, name2, 4)) {
        
                if (new LookUp().lookUpSex(name1) == 1) {
                   
                    
                    
                    
                    	AddPerson.per[new LookUp().lookUp(name1)].setFather(true);
                        AddPerson.per[new LookUp().lookUp(name2)].setMother(true);
                    re[numre] = new Family(name1, name2, child);
                    
                } else {
                    AddPerson.per[new LookUp().lookUp(name2)].setFather(true);
                    AddPerson.per[new LookUp().lookUp(name1)].setMother(true);
                    
                    re[numre] = new Family(name2, name1, child);
                    	
                    }
                
                return true;
        }else {
        	System.out.println("parent error!");
        	return false;
        }

       
    }

    public static String countRe(int id, int judge) {
        int k = 0;//count number of relation

        boolean look;

        String connection = "";

        for (int t = 0; t < AddRelation.numre; t++) {

            if (judge == 1) {
                look = !(AddRelation.re[t] instanceof FriendShip);
            } else if (judge == 2) {
                look = !(AddRelation.re[t] instanceof Colleague);
            } else if (judge == 3) {
                look = !(AddRelation.re[t] instanceof Classmate);
            } else if (judge == 4) {
                look = !(AddRelation.re[t] instanceof Couple);
            } else {
                look = !(AddRelation.re[t] instanceof Relationship);
            }

            if (look) {

            } else {
                String ret = AddRelation.re[t].checkFriend(AddPerson.per[id].getFname());//ret get return connnection name

                if (ret != null) {
                	
                    if (!connection.contains(AddRelation.re[t].checkFriend(AddPerson.per[id].getFname()))) {
                        k = k + 1;
                        connection = connection + " " + AddRelation.re[t].checkFriend(AddPerson.per[id].getFname()) + " ";
                    }

                }
            }
        }
        return (k + connection.trim());

    }

}
