package s_n.method;
//author:Shuai Gao
//Student number:s3596156

import s_n.add.AddPerson;

public class LookUp {

	private int id = 9999;
	private int age = 9999;
	private int sex = 9999;

	//Method to look for identifier by input name
	public int lookUp(String name) {

		for (int i = 0; i <= AddPerson.list.length; i++) {
			String name2 = AddPerson.list[i];
                      
			if (name2.trim().toLowerCase().equals(name.trim().toLowerCase())) {

				this.id = i;
				break;
			}
		}

		return id;
	}
//Getters and Setters methods
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}
	
	//Methods

	public int lookUpAge(String name) {// look up age
		lookUp(name);
		age = AddPerson.per[id].getAge();
		return age;
	}

	public int lookUpSex(String name) {// look up gender
		this.lookUp(name);
		sex = AddPerson.per[id].getSex();
		return sex;
	}
}
