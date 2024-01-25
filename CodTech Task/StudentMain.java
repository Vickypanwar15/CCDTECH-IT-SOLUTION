import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student{
	int roll;
	String name;
	int totalsubject;
	String[] subjects;
	Double[] marks;
	Scanner sc = new Scanner(System.in);
	public static List<Student> slist = new ArrayList<Student>();
	
	
//	 Take the Student Details
	
	public void takeStudentDetails() {
        System.out.println("Enter the Student All Details:");
        System.out.print("Enter Student roll number: ");
        roll = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Student name:");
        name = sc.nextLine();
        System.out.print("Enter Student total subjects:");
        totalsubject = sc.nextInt();
        subjects = new String[totalsubject];
        marks = new Double[totalsubject];
        System.out.print("Enter Student every subject name:");
        for (int i = 0; i < totalsubject; i++) {
            subjects[i] = sc.next();
        }
        System.out.print("Enter Student every subject marks:");
        for (int i = 0; i < totalsubject; i++) {
            marks[i] = sc.nextDouble();
        }
    }

	
//	To find the percentage
    public double findPercentage() {
        double percentage = 0;
        double sum = 0;
        for (int i = 0; i < marks.length; i++) {
            sum += marks[i];
        }
        percentage = sum / marks.length;
        return percentage;
    }
    
    public String findGrade(double percent) {
    	if(percent <= 100 && percent >= 85) {
    		return "A+";
    	}
    	else if(percent<=84 && percent >= 80) {
    		return "A";
    	}
    	else if(percent<=79 && percent >= 75) {
    		return "B+";
    	}
    	else if(percent<=74 && percent >= 70) {
    		return "B";
    	}
    	else if(percent<=69 && percent >= 60) {
    		return "C+";
    	}
    	else if(percent<=59 && percent >= 50) {
    		return "C";
    	}
    	else if(percent<=49 && percent >= 34) {
    		return "D";
    	}
    	return "Fail";
    	
    }
    
//	To show the Details of the Student
    public void showDetails() {
    	 
        if (slist.isEmpty()) {
          
            System.out.println("Student Roll: " + roll);
            System.out.println("Student Name: " + name);
            System.out.println("Student Subjects: " + printSubjectNames());
            System.out.println("Subject Marks:    " + printAllMarks());
            System.out.println("Percentage: " + findPercentage());
            System.out.println("Student Grade:"+findGrade(findPercentage()));
            System.out.println();
            System.out.println();
        } else {
            System.out.println("Student Record is not present");
            System.out.println();
        }
    }

// It is use to print all subject Names
    public String printSubjectNames() {
        StringBuilder subjectNames = new StringBuilder();
        for (int i = 0; i < subjects.length; i++) {
            subjectNames.append(subjects[i]);
            if (i < subjects.length - 1) {
                subjectNames.append("   ");
            }
        }
        return subjectNames.toString();
    }

//    this is use to print all subject marks
    public String printAllMarks() {
        StringBuilder marksString = new StringBuilder();
        for (int i = 0; i < marks.length; i++) {
            marksString.append(marks[i]);
            if (i < marks.length - 1) {
                marksString.append("     ");
            }
        }
        return marksString.toString();
    }

// It is use to update the student information
    public static void updateStudent(List<Student> students, int roll) {
        for (Student student : students) {
            if (student.roll == roll) {
            	student.takeStudentDetails();
                System.out.println("Student details updated successfully");
                System.out.println();
                return;
            }
        }
        System.out.println("Student not found with roll number: " + roll);
    }

//  To Delete any student Details from the list
    public static void deleteStudent(List<Student> students, int roll) {
    for (int i = 0; i < students.size(); i++) {
        if (students.get(i).roll == roll) {
            students.remove(i);
            System.out.println("Student with roll number " + roll + " deleted successfully");
            System.out.println();
            return;
        }
    }
    System.out.println("Student not found with roll number: " + roll);
    }
}

public class StudentMain {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO STUDENT GRADE SYSTEM MANAGEMENT");

        while (true) {
            System.out.println("Enter Student Details press: 1");
            System.out.println("Show All Student Details press: 2");
            System.out.println("Update Student Details press: 3");
            System.out.println("Delete any student details press: 4");
            System.out.println("Exit the application press: 5");

            System.out.println("Enter your choice:");
            int key = sc.nextInt();

            switch (key) {
                case 1: {
                    Student newStudent = new Student();
                    newStudent.takeStudentDetails();
                    students.add(newStudent);
                    System.out.println("Student details filled successfully");
                    System.out.println();
                    break;
                }
                case 2: {
                	 System.out.println("********STUDENT INFORMATION********");
                    for (Student student : students) {
                        student.showDetails();
                    }
                    break;
                }
                case 3: {
                    System.out.println("Enter the roll number of the student to update:");
                    int rollToUpdate = sc.nextInt();
                    Student.updateStudent(students, rollToUpdate);
                    break;
                }
                case 4: {
                    System.out.println("Enter the roll number of the student to delete:");
                    int rollToDelete = sc.nextInt();
                    Student.deleteStudent(students, rollToDelete);
                    break;
                }
                case 5: {
                    // Exit the application
                	System.out.println("You terminated the application");
                    System.exit(0);
                }
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
