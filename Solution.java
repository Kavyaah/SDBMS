package sdbms;

import java.util.Scanner;

import Customexception.InvalidChoiceException;

public class Solution {
	public static void main(String[] args) {
		Scanner ip=new Scanner(System.in);
		StudentmanagementSystem s1=new StudentmanagementSystemImpl();
		while(true) {
		System.out.println("...welcome to Student Database management...");
		System.out.println("1:addstudent  2:displayStudent  3:displayAllStudents  4:removeStudent  5:removeAllStudents  6:updateStudents 7:countStudents  8:sortStudents  9:Studentwithhighestmarks  10:studentswithlowestmarks");
		System.out.println("enter the choice:");
		int choice=ip.nextInt();
		
			switch(choice) {

			case 1:
				s1.addStudent();

				break;
			case 2:
				s1.displayStudent();
				break;
			case 3:
				s1.displayAllStudents();
				break;
			case 4:
				s1.removeStudent();
				break;
			case 5:
				s1.removeAllStudents();
				break;
			case 6:
				s1.updateStudent();

				break;
			case 7:
				s1.countStudents();

				break;
			case 8:
				s1.sortStudent();
				break;
			case 9:
				s1.getStudentwithHighestMarks();
				break;
			case 10:
				s1.getStudentWithLowestMarks();
				break;
			case 11:
				System.exit(0);
				break;
			default:
				try {
					throw new InvalidChoiceException("please enter the valid choice"); 
				}
				catch(Exception e){
					System.out.println(e.getMessage());
					
				}
			}
			System.out.println("===========");
		}


	}
}
