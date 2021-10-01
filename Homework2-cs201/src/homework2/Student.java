package homework2;

public class Student {
	private String firstName;
	private String lastName;
	private int id;
	private double gpa;
	private boolean isHold;
	private int gradeCnt;
	private double rawGrade;
	private double convGrade;
	private String fullName;
	
//	Create setName method which takes 3 string inputs and assigns the firstName, lastName, and idNum values to their respective inputs
//	Create updateGPA method which takes 
//	Create placeHold method which has an if statement saying if gpa < 3.0 then set isOnHold to true

	public Student(String fn, String ln, int id, double gpa, boolean hol, int gradeCnt, double rawG) {
		firstName = fn;
		lastName = ln;
		this.id = id;
		this.gpa = gpa;
		isHold = hol;
		this.gradeCnt = gradeCnt;
		rawGrade = rawG;
		fullName = ln + ", " + fn;
	}
	
	public double getGpa() {
		return gpa;
	}
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isHold() {
		return isHold;
	}

	public void setHold(boolean isHold) {
		this.isHold = isHold;
	}

	public int getGradeCnt() {
		return gradeCnt;
	}

	public void setGradeCnt(int gradeCnt) {
		this.gradeCnt = gradeCnt;
	}

	public double getRawGrade() {
		return rawGrade;
	}

	public void setRawGrade(double rawGrade) {
		this.rawGrade = rawGrade;
	}

	public double getConvGrade() {
		return convGrade;
	}

	public void setConvGrade(double convGrade) {
		this.convGrade = convGrade;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public double gpaUpdate(double gradeInput) { //inputs grades based on the 100 point scale
		rawGrade += gradeInput;
		gradeCnt++;
		convGrade = (rawGrade / gradeCnt) - 60; //sets up for gpa scale of 60-69 = 1.0, 70-79 = 2.0, 80-89 = 3.0, 90-100 = 4.0
		
		if(convGrade>=30) gpa = 4.0;
		else if(convGrade>=20) gpa = 3.0;
		else if(convGrade>=10) gpa = 2.0;
		else if(convGrade>=0) gpa = 1.0;
		else if(convGrade<0) gpa = 0.0;
		holdCheck();
		return gpa;
	}
	
	public String holdCheck() {
		if(gpa<3.0 && gradeCnt != 0) isHold = true;
		else isHold = false;
		if(isHold) return "is on hold";
		else return "is not on hold";
	}
	
	public static void sortByName(Student arr[]) {
		int min;
		for(int i = 0; i < arr.length-1; i++) {
			min = i;
			for(int j = i + 1; j < arr.length; j++) {
				if((arr[j].getFullName()).compareTo(arr[min].getFullName()) < 0) min = j;
			}
			Student temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
			
		}
	}
	
	public static void sortById(Student arr[]) {
		int min;
		for(int i = 0; i < arr.length-1; i++) {
			min = i;
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[j].getId() < arr[min].getId()) min = j;
			}
			Student temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
	}
	
	public static void sortByGpa(Student arr[]) {
		int min;
		for(int i = 0; i < arr.length-1; i++) {
			min = i;
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[j].getGpa() > arr[min].getGpa()) min = j;
			}
			Student temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
	}
	
	public static String display(Student arr[]) {
		String output = "";
		for(int i = 0; i < arr.length; i++) {
			output += arr[i].toString() + "\n";
		}
		return output;
	}
	
	public String toString() {
		return "Name: " + fullName + " \t | ID: " + id + "\t| GPA: " + getGpa() + "\t| Hold Status: " + holdCheck(); //add gpa before hold status
	}

}
