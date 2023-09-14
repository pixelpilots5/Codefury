package view;

import java.util.Scanner;
import entity.Bug;
import exception.*;
import service.*;
import dao.*;


public class BugMain {
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Options");
		System.out.println("1.Register bug");
		System.out.println("2.Close bug");
		System.out.println("3.View bug status");
		System.out.println("Enter the number");
		int i = s.nextInt();
		
		switch(i) {
		
		case 1:
			Bug bug = new Bug();
			//take bug parameters as input and register a new
			//bug in db
			System.out.println("Enter bug id");
			int id = s.nextInt();
			System.out.println("Enter bug title");
			String t = s.next();
			System.out.println("Enter bug description");
			String d = s.next();
			bug.setUniqueID(id);
			bug.setTitle(t);
			bug.setDescription(d);
			try {
				BugService.registerBug(bug);
			}
			catch(BugAlreadyExistsException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 2:
			System.out.println("enter id of bug to delete");
			int x = s.nextInt();
			try {
				BugService.closeBug(x);
			}
			catch (BugAlreadyClosedException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 3:
			System.out.println("enter id of bug to delete");
			int x = s.nextInt();
			BugService.viewBugStatus(x);
			break;
		}
		
	}
}
