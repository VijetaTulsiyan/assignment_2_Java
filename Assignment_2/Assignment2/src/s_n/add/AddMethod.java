//Author:- Vijeta Tulsiyan

package s_n.add;

import s_n.method.LookUp;
import s_n.method.MyExceptions;



public class AddMethod {

    public static int ageType(int age) {
        if (age <= 2) {
            return 1;
        } else if (age <= 16) {
            return 2;
        } else {
            return 3;
        }
    }

    public static boolean ageDistance(int age1, int age2) {

        if ((age1 - age2) * (age1 - age2) <= 9) {

            return true;
        } else {
      
            System.out.println("CantBeFriendsException");
            return false;

        }

    }
  //compare if they can be friends based on age
    public static boolean compareCan(int age1, int age2, int cType) {
        boolean can = false;
        switch (cType) {
            case 1:
                can = canFriend(age1, age2);

                break;

            case 2:
                can = canColleague(age1, age2);

                break;
            case 3:
                can = canClassmate(age1, age2);

                break;
            case 4:
                can = canCouple(age1, age2);

                break;

        }
        return can;

    }

    public static boolean canFriend(int age1, int age2) {
        if (ageType(age1) == 1 || ageType(age2) == 1) {
 System.out.println("TooYoungException ");
            return false;
        } else if (ageType(age1) == ageType(age1)) {
            if (ageType(age1) == 3) {

                return true;
            } else {

                return ageDistance(age1, age2);
            }
        } else {
            
            return false;
        }

    }

    public static boolean canColleague(int age1, int age2) {
        if (ageType(age1) == 3 && ageType(age2) == 3) {
            return true;
        } else {
            System.out.println("CantBeColleaguesException");
            return false;
        }
    }

    public static boolean canClassmate(int age1, int age2) {
        if (ageType(age1) == 1 || ageType(age2) == 1) {
            System.out.println("CantBeClassmatesException ");
            return false;
        } else {
            return true;
        }

    }

    public static boolean canCouple(int age1, int age2) {
         if (ageType(age1) == 3 && ageType(age2) == 3) {
            return true;
        } else {
            System.out.println("CantBeCoupledException ");
            return false;
        }

    }

    public static boolean sameSex(String name1, String name2) {
        if (new LookUp().lookUpSex(name1) == new LookUp().lookUpSex(name2)) {

            return true;
        } else {

            return false;
        }
    }
}
