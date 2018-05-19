package s_n.add;

//author:Shuai Gao	
//Student number:s3596156

import s_n.People.Adult;
import s_n.People.Person;
import s_n.People.Child;
import s_n.method.DataClean;

public class AddPerson {// for user to add person

	public static Person[] per = new Person[100]; // for create constractor
	public static String[] list = new String[100]; // for look up object

	// Getter and setter methods for array List
	public static String getList(int x, int y) {
		return list[x];
	}

	public static void setList(int no, String name) { // list setter
		list[no] = name;
	}

	// Method to input a person's details
	public boolean addAdult(String fname, String lname, int sex, int age, String status, boolean picture) { // add
		// person
		// method
		boolean flag = false;

		if (age >= 0 && age < 150) {

			per[Person.max] = new Adult(fname, lname, sex, age, status, picture);
			int index = Person.max;
			// new ImportData().outPeople(per[index-1]);
			flag = true;
		}

		if (!flag) {
			System.out.println("NoSuchAgeException ");
		}
		return flag;

	}

	public boolean addChild(String fname, String lname, int sex, int age, String status, boolean picture, String father,
			String mother) {
		boolean flag = false;

		if (new AddRelation().AddRelation(father, mother, fname)) {
			per[Person.max] = new Child(fname, lname, sex, age, status, picture);
			int index = Person.max;
			// new ImportData().outPeople(per[index-1]);
			flag = true;
		}

		return flag;
	}
}