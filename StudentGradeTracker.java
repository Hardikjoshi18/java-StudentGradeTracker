import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private ArrayList<Double> grades;

    // Constructor
    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    // Add grade
    public void addGrade(double grade) {
        grades.add(grade);
    }

    // Calculate average grade
    public double getAverageGrade() {
        if (grades.isEmpty()) return 0.0;
        double sum = 0.0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    // Get student performance
    public String getPerformance() {
        double average = getAverageGrade();
        if (average >= 90) {
            return "Excellent";
        } else if (average >= 75) {
            return "Good";
        } else if (average >= 50) {
            return "Average";
        } else {
            return "Poor";
        }
    }

    // Get name
    public String getName() {
        return name;
    }

    // Display grades
    public void displayGrades() {
        System.out.println("Grades for " + name + ": " + grades);
    }
}

public class StudentGradeTracker {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // Add student
    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        students.add(new Student(name));
        System.out.println("Student added successfully.");
    }

    // Add grade to a student
    private static void addGrade() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        Student student = findStudent(name);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.print("Enter grade (0-100): ");
        double grade = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        if (grade < 0 || grade > 100) {
            System.out.println("Invalid grade. Please enter a value between 0 and 100.");
        } else {
            student.addGrade(grade);
            System.out.println("Grade added successfully.");
        }
    }

    // Display student details
    private static void displayStudentDetails() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        Student student = findStudent(name);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        student.displayGrades();
        System.out.println("Average Grade: " + student.getAverageGrade());
        System.out.println("Performance: " + student.getPerformance());
    }

    // Find student by name
    private static Student findStudent(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }

    // Main menu
    private static void displayMenu() {
        System.out.println("\n--- Student Grade Tracker ---");
        System.out.println("1. Add Student");
        System.out.println("2. Add Grade");
        System.out.println("3. Display Student Details");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    // Main method
    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    addGrade();
                    break;
                case 3:
                    displayStudentDetails();
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
