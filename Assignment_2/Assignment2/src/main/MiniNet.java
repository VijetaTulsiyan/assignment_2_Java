package main;

// Author: Shuai Gao

import java.io.File;
import s_n.method.DataClean;
import java.util.Scanner;
import s_n.add.AddPerson;
import s_n.add.AddRelation;
import s_n.connection.Relationship;
import s_n.method.MyExceptions;

public class MiniNet {
	// Main method
	public static void main(String[] args) {
		Output.setFile();
		
		if (Output.fileAccessPassed) {
			InputT.inputT(new Output().getFile());
			InputT.inputRe(new Output().getFileRe());
			
			DataClean.deleteC();	
			
			Output.outPeople(new Output().getFile());
			Output.outRelation(new Output().getFileRe());
		}
		else {
			boolean isSuccess = DatabaseHandler.setDatabase();
			if (isSuccess) {
				DatabaseHandler.readPeople();
				DatabaseHandler.readRelationship();
				
				DataClean.deleteC();
			}
		}
		
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(viewer.window.Menu.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new viewer.window.Menu().setVisible(true);
			}
		});
	}
}
