package homework2;

import java.util.Arrays;
import java.io.*;

public class Main {

	public static void main(String[] args) {
//		String fn, String ln, int id, double gpa, boolean hol, int gradeCnt, double rawG)
		
		Student student1 = new Student("Joe", "Smith", 12345, 0.0, false, 0, 0.0);
		Student student2 = new Student("Jane", "Doe", 54321, 4.0, false, 1, 100.0);
		Student student3 = new Student("Mary", "Sue", 12321, 3.0, false, 2, 160.0);
		Student student4 = new Student("Sam", "Brown", 11111, 2.0, false, 3, 225.0);
		Student student5 = new Student("Adam", "Lee", 10001, 3.0, false, 5, 435.0);
		
		Student[] students = new Student[5];
		students[0] = student1;
		students[1] = student2;
		students[2] = student3;
		students[3] = student4;
		students[4] = student5;
		
		System.out.println("Student 1 has a gpa of " + student1.getGpa() + " and is " + student1.holdCheck()); //student1 has no grades in the gradebook yet, so he isn't placed on hold despite having a 0.0 gpa
		System.out.println("Student 1 got a new grade in and now has a gpa of " + student1.gpaUpdate(90));
		System.out.println("Student 1 got a new grade in and now has a gpa of " + student1.gpaUpdate(59));
		System.out.println("Student 1 got a new grade in and now has a gpa of " + student1.gpaUpdate(100));
		System.out.println("Student 1 has a gpa of " + student1.getGpa() + " and is " + student1.holdCheck()); //student1 has a sub 3.0 gpa and is placed on hold
		System.out.println();
		
		try {
			FileWriter fw = new FileWriter("output.txt", false);
			PrintWriter pw = new PrintWriter(fw);
			
			pw.println("line 1");
		
		
		//3. Sort a set of student objects
		//By name
		Student.display(students);
		Student.sortByName(students);
		System.out.println();
		System.out.println("Sorted by last name");
		Student.display(students);
		//By student ID
		Student.sortById(students);
		System.out.println();
		System.out.println("Sorted by ID #");
		Student.display(students);
		//By GPA (high to low)
		Student.sortByGpa(students);
		System.out.println();
		System.out.println("Sorted by GPA");
		Student.display(students);
		
		//1. Sort a random set of integers
		System.out.println();
		System.out.println("_____________________________");
		System.out.println("Sorting a random set of new integers"); pw.print(("Sorting a random set of new integers"));
		System.out.print("Random set of integers: ");
		int randInts[] = new int[5];
		for(int i = 0; i < 5; i++) {
		randInts[i] = (int)(Math.random()*10);
		System.out.print(randInts[i] + " ");
			}
		System.out.println("Sorting random integers high to low:");
		sortIntAsc(randInts);
		System.out.println(Arrays.toString(randInts));
		
		System.out.println("Sorting random integers low to high:");
		sortIntDec(randInts);
		System.out.println(Arrays.toString(randInts));

		System.out.println();
		System.out.println();
		
		//2. Sort a set of characters
		char randChars[] = new char[10];
		for(int i = 0; i < 10; i++) {
			randChars[i] = (char) ((int)(Math.random()*100)%94+33);
			System.out.print(": \'" + randChars[i] + "\', ");
		}
		System.out.println();
		System.out.println("Sorting random characters");
		Arrays.sort(randChars);
		for(int i = 0; i < randChars.length; i++) {
			System.out.print(": \'" + randChars[i] + "\', ");
		}
		
		pw.close();
		}
		catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		

 }
	
	//sorts randInts ascending
	public static void sortIntAsc(int[] rand) {
	int min;
	for(int i = 0; i < rand.length-1; i++) {
		min = i;
		for(int j = i + 1; j < rand.length; j++) {
			if(rand[j] > rand[min]) min = j;
		}
		int temp = rand[i];
		rand[i] = rand[min];
		rand[min] = temp;
	  }
	}
	
	//sorts randInts descending
		public static void sortIntDec(int[] rand) {
		int min;
		for(int i = 0; i < rand.length-1; i++) {
			min = i;
			for(int j = i + 1; j < rand.length; j++) {
				if(rand[j] < rand[min]) min = j;
			}
			int temp = rand[i];
			rand[i] = rand[min];
			rand[min] = temp;
		  }
		}
	
	
	
}
	

