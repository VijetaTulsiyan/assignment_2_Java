/*
 * Author: Vijeta Tulsiyan
 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import org.hsqldb.Server;

import s_n.People.Person;
import s_n.add.AddPerson;
import s_n.add.AddRelation;
import s_n.connection.Classmate;
import s_n.connection.Colleague;
import s_n.connection.Couple;
import s_n.connection.Family;
import s_n.connection.FriendShip;
import s_n.connection.Relationship;

/*
 The setFile will look for people.text and relations.text file. If file is found, it will read from file
 Else it will look for Database Connection
 */
public class Output {
	public static File file = null;
	public static File fileRe = null;
	public static boolean fileAccessPassed = true;

	public static void setFile(){
		file = new File("src\\data\\people.text");
		fileRe = new File("src\\data\\relations.text");		
		
		if(file.exists() && !file.isDirectory()) { 
			if(!(fileRe.exists() && !fileRe.isDirectory())) {
				System.out.println("Doesn't has relations text file");
			}
		}
		else {
			System.out.println("Doesn't has people text file, system is going to use database.");
			fileAccessPassed = false;
		}		
	}

	public File getFile(){
		return file;
	}

	public File getFileRe(){
		return fileRe;
	}

	public static void outPeople(File file) {
		if(file.exists()){
			file.delete();
		}

		for (int i = 0; i < Person.max; i++) {
			if ((AddPerson.per[i] instanceof Person)) {

				Person person=AddPerson.per[i];
				
				BufferedWriter bw = null;
				String fname = person.getFname();
				String lname = person.getLname();
				String picture = "";
				String status = "";
				String gender = "";
				int age = person.getAge();
				if (person.isImage()) {
					picture = "True";
				}
				if (!(person.getStatus().trim() == null)) {
					status = person.getStatus().trim();
				}

				if (person.getSex() == 1) {
					gender = "M";
				} else {
					gender = "F";
				}

				try {
					bw = new BufferedWriter(new FileWriter(file, true));
					bw.write(fname + " " + lname + "," + picture + "," + "\"" + status + "\"," + gender + "," + age);
					bw.newLine();
					bw.flush();

				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						bw.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			}
		}
	}

	public static void outRelation(File filere){
		filere.delete();

		for (int i = 0; i < AddRelation.numre; i++) {
			if ((AddRelation.re[i] instanceof Relationship)) {
				Relationship re=AddRelation.re[i];
				
				BufferedWriter bw1 = null;
				String name1=re.getName1();
				String name2=re.getName2();
				//    String type=re.friend(name1, name2);
				//   System.out.println(type);
				String co = null;
				if (re instanceof Couple) {
					if(((Couple) re).getChild()==null){
						co="couple";
					}
					else{
						continue;
					}
				} 
				else if (re instanceof FriendShip) {
					co="friend";
				}
				else if (re instanceof Colleague) {
					co="colleague";
				}
				else if (re instanceof Classmate) {
					co="classmate";
				}
				
				try {
					bw1 = new BufferedWriter(new FileWriter(filere, true));
					bw1.write(name1 +"," + name2 + ","+co);
					bw1.newLine();
					bw1.flush();
				} 
				catch (IOException e) {
					e.printStackTrace();
				} 
				finally {
					try {
						bw1.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			}
		}

		for (int i = 0; i < AddRelation.numre; i++) {

			if ((AddRelation.re[i] instanceof Couple)) {
				if(!(((Couple)AddRelation.re[i]).getChild()==null)){
					String father=(((Couple)AddRelation.re[i])).getFather();
					String mother=(((Couple)AddRelation.re[i])).getMother();
					String child=(((Couple)AddRelation.re[i])).getChild();
					try {
						BufferedWriter bw = new BufferedWriter(new FileWriter(filere, true));
						bw.write(father +"," + mother + ","+child);
						bw.newLine();
						bw.flush();

					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}