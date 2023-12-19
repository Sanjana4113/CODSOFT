import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student 
{
    String name;
    int rollNumber;
    String grade;

    public Student(String name, int rollNumber, String grade) 
    {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() 
    {
        return name;
    }

    public int getRollNumber() 
    {
        return rollNumber;
    }

    public String getGrade() 
    {
        return grade;
    }

    public String toString() 
    {
        return "Name: " + name + "\n" + "Roll no.: " + rollNumber + "\n" + "Grade: " + grade + "\n";
    }
}

class StudentManagementSystem extends Student
{
    List<Student> studentList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    
    static String name;
    static int rollNumber;
    static String grade;
    StudentManagementSystem() 
    {
        super(name,rollNumber,grade);
    }

    public void addStudent(Student student) 
    {
        studentList.add(student);
    }

    public void removeStudent(Student student) 
    {
        studentList.remove(student);
    }

    public Student searchStudent(int rollNumber) 
    {
        for (Student student : studentList) 
        {
            if (student.getRollNumber() == rollNumber) 
            {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() 
    {
        for (Student student : studentList) 
        {
            System.out.println(student);
        }
    }

    public void addNewStudent() 
    {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student roll number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter student grade: ");
        String grade = scanner.nextLine();

        Student newStudent = new Student(name, rollNumber, grade);
        addStudent(newStudent);
        System.out.println("Student added successfully.");
    }

    public void removeExistingStudent() 
    {
        System.out.print("Enter roll number of student to remove: ");
        int rollNumber = scanner.nextInt();
        Student studentToRemove = searchStudent(rollNumber);
        if (studentToRemove != null) 
        {
            removeStudent(studentToRemove);
            System.out.println("Student removed successfully.");
        } 
        else 
        {
            System.out.println("Student not found.");
        }
    }

    public void searchForStudent() 
    {
        System.out.print("Enter roll number of student to search: ");
        int rollNumber = scanner.nextInt();
        Student foundStudent = searchStudent(rollNumber);
        if (foundStudent != null) 
        {
            System.out.println("Student found:");
            System.out.println(foundStudent);
        } 
        else 
        {
            System.out.println("Student not found.");
        }
    }
}

public class StudentManagement
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem system = new StudentManagementSystem();

        while(true)
        {
            System.out.print("1. Add student\n2. Remove student\n3. Search student\n4. Display all students\nEnter your choice: ");
            int ch = scanner.nextInt();
            switch (ch) 
            {
                case 1: system.addNewStudent();
                        break;
                    
                case 2: system.removeExistingStudent();
                        break;
                    
                case 3: system.searchForStudent();
                        break;
                    
                case 4: system.displayAllStudents();
                        break;
                    
                default: System.out.println("Invalid choice.");
                         System.exit(0);
            }
        } 
    }
}
