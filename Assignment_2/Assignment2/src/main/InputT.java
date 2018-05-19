/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import s_n.People.Adult;
import s_n.People.Child;
import s_n.People.Person;
import s_n.add.AddPerson;
import s_n.add.AddRelation;

/*
 Author: Shuai Gao
 */
public class InputT {	
	
	public static void inputT(File file){
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] datas = line.split(",");
				String line1 = datas[0].trim();
				String[] names = line1.split(" ");
				String fname = names[0].trim();
				String lname=null;

				try{
					lname = names[1].trim();}
				catch(ArrayIndexOutOfBoundsException e){
					lname=" unkonw";
				}
				boolean picture;
				if (datas[1].replace("\"", "").trim().length() == 0) {
					picture = false;
				} else {
					picture = true;
				}
				String status = datas[2].trim().replace("\"", "");
				int gender;
				if (datas[3].trim().equals("F")) {
					gender = 0;
				} else {
					gender = 1;
				}
				int age = Integer.parseInt(datas[4].trim());

				if (age >= 16) {
					// System.out.println("A: "+fname+" "+lname+" "+gender+" "+age+" "+status+" "+picture);
					AddPerson.per[Person.max] = new Adult(fname, lname, gender, age, status, picture);
				} else {
					//  System.out.println("C: "+fname+" "+lname+" "+gender+" "+age+" "+status+" "+picture);
					AddPerson.per[Person.max] = new Child(fname, lname, gender, age, status, picture);
				}
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			try {
				br.close();
			} 
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void inputRe(File filere){
		if(!(filere==null)){
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(filere));
				String line = null;
				while ((line = br.readLine()) != null) {
					String[] datas = line.split(",");
					try{
						String name1 = datas[0].trim();
						//                String line1=datas[0].trim();
						//                String [] name1=line1.split(" ");
						//                String fname1=name1[0].trim();
						String name2 = datas[1].trim();
						//                String line2=datas[1].trim();
						//                String [] name2=line2.split(" ");
						//                String fname2=name2[0].trim();

						String re = datas[2].trim();
						if (re.contains("friend")) {
							new AddRelation().AddRelation(name1, name2, 1);
						} else if (re.contains("colleague")) {
							new AddRelation().AddRelation(name1, name2, 2);
						} else if (re.contains("classmate")) {
							new AddRelation().AddRelation(name1, name2, 3);
						} else if (re.contains("couple")) {
							new AddRelation().AddRelation(name1, name2, 4);
						} else {
							new AddRelation().AddRelation(name1, name2, re);
						}
					}
					catch(Exception e){
						continue;
					}
				}
			} 
			catch (IOException e) {
				e.printStackTrace();
			} 
			finally {
				try {
					br.close();
				} 
				catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
		else {
			Output.fileRe=new File("relations");
		}
	}
}