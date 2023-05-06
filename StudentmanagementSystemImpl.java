package sdbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import CustomSorting.SortStudentByAge;
import CustomSorting.SortStudentByName;
import CustomSorting.SortStudentBymarks;
import CustomSorting.SortstudentByid1;
import Customexception.InvalidChoiceException;
import Customexception.studentNotFoundException;

public class StudentmanagementSystemImpl implements StudentmanagementSystem {
	Scanner ip=new Scanner(System.in);
	Map<String,Student> db=new LinkedHashMap<String, Student>();


	@Override
	public void addStudent() {
		System.out.println("Enter age:");
		int age=ip.nextInt();
		System.out.println("Enter name:");
		String name=ip.next();
		System.out.println("Enter marks:");
		int marks=ip.nextInt();
		Student s1=new Student(age,name,marks);

		db.put(s1.getid(), s1);
		System.out.println("student record inserted successfully..");
		System.out.println("student id is:"+s1.getid());

	}
	@Override
	public void displayStudent() {

		String id=ip.next().toUpperCase();

		Student s1=db.get(id);
		if(db.containsKey(id)) {
			System.out.println(s1.getage()+" "+s1.getname()+" "+s1.getmarks());

		}
		else {
			try {
				throw new studentNotFoundException("Student with Id"+id+"is not found");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void displayAllStudents() {
		if(db.size()!=0) {
			Set<String> keys=db.keySet();
			for(String key:keys) {
				System.out.println("Student Records are as Follows:");
				System.out.println("===============");
				System.out.println(db.get(key));
			}
		}
		else {
			try {
				throw new studentNotFoundException("Student database is empty.! nothing to display...");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void removeStudent() {
		System.out.println("enter student id:");
		String id=ip.next().toUpperCase();

		if(db.containsKey(id)) {
			System.out.println("student records found");
			System.out.println(db.get(id));
			db.remove(id);
			System.out.println("student records removed successfully");
		}
		else {
			try {
				throw new studentNotFoundException("Student database is empty.! nothing to remove...");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}




	@Override
	public void removeAllStudents() {
		if(db.size()!=0) {
			System.out.println("students records available:"+db.size());
			db.clear();	
			System.out.println("student records are deleted successfully");
			System.out.println("students records available:"+db.size());
		}
		else {
			try {
				throw new studentNotFoundException("Student database is empty.! nothing to delete..");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}

		}

	}
	@Override
	public void updateStudent() {
		System.out.println("enter student id:");
		String id=ip.next().toUpperCase();
		if(db.containsKey(id)) {
			Student s1=db.get(id);

			System.out.println("1:Update age   2:Updatename  3:Updateamrks");
			System.out.println("Enter Your Choice:");
			int choice=ip.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter age:");
				int age=ip.nextInt();
				s1.setage(age);
				break;
			case 2:
				System.out.println("Enter name:");
				String name=ip.next();
				s1.setname(name);
				break;
			case 3:
				System.out.println("Enter marks:");
				int marks=ip.nextInt();
				s1.setmarks(marks);
				break;
			default:

				try {
					throw new InvalidChoiceException("Invalid choice,please enter the valid choice");
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}

			}
		}

		else {


			try {
				throw new studentNotFoundException("Student database is empty.! nothing to update..");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}

		}


	}


    @Override
	public void countStudents() {
		System.out.println("No. of Students records:"+db.size());

	}
	@Override
	public void sortStudent() {
		if(db.size()>=2) {
		Set<String> keys=db.keySet();
		List<Student> list=new ArrayList<Student>();
		for(String key:keys) {
			Student s1=db.get(key);
			list.add(s1);
		}
		System.out.println("1:sortstudentbyid  2:sortstudentbyname  3:sortstudentbyage  4:sortstudentmarks" );
		System.out.println("Enter your choice:");
		int choice=ip.nextInt();
		switch(choice) {
		case 1:
			Collections.sort(list,new SortstudentByid1());
			display(list);
			break;
		case 2:
			Collections.sort(list,new SortStudentByName());
			display(list);
			break;
		case 3:
			Collections.sort(list,new SortStudentByAge());
			display(list);
			break;
		case 4:
			Collections.sort(list,new SortStudentBymarks());
			display(list);
			break;
			default:try {
				throw new InvalidChoiceException("Invalid choice,please enter the valid choice");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
				
		}
		}
		else {
			try {
				throw new studentNotFoundException("No student records to sort");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
		private static void display(List<Student> list) {
			for(Student s:list) {
				System.out.println(s);
			}
		


	}
	@Override
	public void getStudentwithHighestMarks() {
		if(db.size()>=2) {
		Set<String> keys=db.keySet();
		List<Student> list=new ArrayList<Student>();
		for(String key:keys) {
			Student s1=db.get(key);
			list.add(s1);
		}
		Collections.sort(list,new SortStudentBymarks());
		System.out.println(list.get(list.size()-1));
	}
		else {
			try {
				throw new studentNotFoundException("No sufficient student records to compare");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void getStudentWithLowestMarks() {
		if(db.size()>=2) {
		Set<String> keys=db.keySet();
		List<Student> list=new ArrayList<Student>();
		for(String key:keys) {
			Student s1=db.get(key);
			list.add(s1);
		}
		Collections.sort(list,new SortStudentBymarks());
		System.out.println(list.get(0));
	}
		else {
			try {
				throw new studentNotFoundException("No sufficient student records to compare");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
}
}
