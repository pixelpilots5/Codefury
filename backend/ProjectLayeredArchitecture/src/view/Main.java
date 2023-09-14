package view;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import entity.Project;
import exception.NoProjectException;
import exception.ProjectAlreadyExistsException;
import service.ProjectService;
import service.ProjectServiceImpl;

public class Main {
	static int[] users;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ProjectService ps=new ProjectServiceImpl();
		while(true) {
			System.out.println("Welcome to all the options you can do on Projects");
			System.out.println("Options:");
			System.out.print("1. Create a project"); System.out.println("     2. Display a project by ID");
			System.out.print("3. Display all projects"); System.out.println(" 4. Change status for a project");
			System.out.println("Enter an option");
			int a=sc.nextInt();
			switch(a) {
			case 1:
				System.out.println("Enter project id:");
				int b=sc.nextInt();
				System.out.println("Enter project name:");
				String c=sc.next();
				System.out.println("Enter project details:");
				String d=sc.next();
				System.out.println("Enter the project start date(yyyy-MM-dd)");
				String e=sc.next();
				DateTimeFormatter dt=DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate d1=LocalDate.parse(e,dt);
				Date sqlDate=Date.valueOf(d1);
				System.out.println("Enter project status:");
				String f=sc.next();
				System.out.println("-> Enter the project team members ids:");
				System.out.println("=> Enter the number of members:");
				int n=sc.nextInt();
				for(int i=0;i<n;i++) {
					users=new int[n];
					users[i]=sc.nextInt();
				}
				Project p1=new Project(b,c,d,d1,f,users);
				try {
					ps.createProject(p1);
				} catch(ProjectAlreadyExistsException e1) {
					e1.printStackTrace();
				}
				break;
				
			case 2:
				System.out.println("Enter the id of the project you want to display:");
				int id=sc.nextInt();
				try {
					Project project=ps.getProjectById(id);	
				} catch(NoProjectException e1) {
					e1.printStackTrace();
				}
				break;
				
			case 3:
				System.out.println("Displaying all the projects:");
				try {
					List<Project> list=ps.displayAllProjects();
					for(Project p:list) {
						System.out.println(p.toString());
					}
				} catch(NoProjectException e1) {
					e1.printStackTrace();
				}
				break;
				
			case 4:
				System.out.println("Enter the id of the project you want to change:");
				int idChange=sc.nextInt();
				Project statusChangeP=new Project(idChange);
				try {
					ps.changeStatus(statusChangeP);
				} catch(NoProjectException e1) {
					e1.printStackTrace();
				}
				break;
				
			default: System.out.println("! Enter valid option !");
				
			}
		}
	}

}
