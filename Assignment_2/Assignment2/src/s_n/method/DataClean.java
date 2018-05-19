package s_n.method;

//auther:Vijeta Tulsiyan
//Student number:s3398979

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import s_n.add.AddRelation;
import s_n.add.AddPerson;
import s_n.People.Adult;
import s_n.People.Child;
import s_n.People.Person;
import s_n.connection.Relationship;

//Creating class to store persons' details in AddPerson and AddRelation class 
public class DataClean {

	public static void deleteC() {
		for (int x = 0; x < Person.max; x++) {
			if ((AddPerson.per[x] instanceof Child)) {
				int id = x;
				String parent = null;
				for (int i = 0; i < AddRelation.numre; i++) {
					if (AddRelation.re[i] instanceof Relationship) {
						String check = AddRelation.re[i].family(AddPerson.per[id].getFname());

						if (check != null) {
							parent = check;
						}
					}
				}
				try {
					String p[] = parent.split(",");
				} 
				catch (NullPointerException e) {
					System.out.println(AddPerson.per[id].getFname() + " input false due to without parents!");
					AddPerson.per[id] = null;
					AddPerson.setList(id, null);
				}
			}
		}
	}

	// Constructor
	public DataClean() {
	}

	public static void inputI() {
	}
}
