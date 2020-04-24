/*
Author: Amber Holladay, Paige Kowahl, Emma Morell, Gonzo Ocampo
Date: Apr 21, 2020
Assignment: Group Project Part 1
Purpose: To run the Student Management System
 */
package FinalProject.FinalJavaProject;

import java.util.*;

public class StudentManagementSystem {
    
    
    
    public static ArrayList<Student> studentArray = new ArrayList<>();
    public static ArrayList<Course> courseArray = new ArrayList<>();
    public static ArrayList<Instructor> instructorArray = new ArrayList<>();
    
    
    
    public static void main(String[] args)
    {
        int userSelect;
        Scanner in = new Scanner(System.in);

        System.out.println("Student Management System");
        System.out.println("Please make a menu choice below:");
        System.out.println("--------------------------------");
        System.out.println("1: Create a Course");
        System.out.println("2: Add Student to Course");
        System.out.println("3: Remove Student from Course");
        System.out.println("4: Add Instructor to Course");
        System.out.println("5: Print Roster for Course");
        System.out.println("6: Quit");

        System.out.print("Choice: ");
        userSelect = in.nextInt();

        while (userSelect != 6) // If 6, exits
        {

            if(userSelect == 1) // Create a Course
            {
                String name = "";
                String building = "";
                String room = "";
                int capacity = 0;
                
                System.out.println("Creating Class...");
                System.out.println("Enter Course Name: ");
                name = in.nextLine();
                System.out.println("Enter Building: ");
                building = in.nextLine();
                System.out.println("Enter Room Number: ");
                room = in.nextLine();
                System.out.println("Enter Room Capacity: ");
                capacity = in.nextInt();
                
                Course newCourse = new Course(name, building, room, capacity);
                
                courseArray.add(newCourse);
                
            }

            if(userSelect == 2) // Add student to Course
            {
                String name = "";
                String major = "";
                int year = 0;
                double gpa = 0.0;
                String email = "";
                
                in.nextLine();
                System.out.println("Enter Student Information: ");
                System.out.print("Name (firstname lastname): ");
                name = in.nextLine();
                System.out.print("Major: ");
                major = in.nextLine();
                System.out.print("Year: ");
                year = in.nextInt();
                System.out.print("GPA: ");
                gpa = in.nextDouble();
                System.out.print("Email: ");
                email = in.nextLine();
                
                while (gpa > 5.0 | gpa < 0.0){
                    System.out.print ("Error! Invalid GPA. GPA must be between 0.0 and 5.0.\nPlease enter a new GPA: ");
                    gpa = in.nextDouble();
                }

                boolean test;
                test = false;

                while (test == false){
                    for (int i = 0; i < email.length(); i++){
                        if (email.charAt(i) == '@'){
                            test = true;
                        }
                    }

                    if (test == false){
                        System.out.print("Error! Invalid email address.\nPlease enter a new email address: ");
                        email = in.nextLine();
                    }
                }
                
                System.out.println("Please Choose a Class: ");
                for(int i = 0; i < courseArray.size(); i++)
                {
                    Course printCourse = courseArray.get(i);
                    
                    System.out.println(printCourse.toString());
                }
                
                Student addStudent = new Student(name, year, major, gpa, email);
                
                int classChoice;
                System.out.println("Choose Class #: ");
                classChoice = in.nextInt();
                
                Course courseSelection = courseArray.get(classChoice);
                
                courseSelection.enrollStudent(addStudent);
            }

            if(userSelect == 3)
            {
                int courseNum = 0;
                int studentNum = 0;
                
                System.out.println("\nPlease choose a class:");
                
                for (int i = 0; i < courseArray.size(); i++){
                    Course printCourse = courseArray.get(i);
                    
                    System.out.println(printCourse.toString());
                }
                
                System.out.println("------------------");
                System.out.println("Choose Class #: ");
                courseNum = in.nextInt();
                
                System.out.println("------------------");
                System.out.println("Please Choose a Student: ");
                
                System.out.println(courseArray.get(courseNum).getRoster());
                
                System.out.println("Type ID of Student to Remove: ");
                studentNum = in.nextInt();
                

        // for loop over the courses to find the one that matches the ID
                courseArray.get(courseNum).removeStudent(studentNum);
                
                
                System.out.println("Student Successfully Removed!");
            }

            if(userSelect == 4)
            {
                System.out.println("Enter Instructor Information");
                
                System.out.println("Name: ");
                String name = in.nextLine();
                
                System.out.println("Prefix: ");
                String prefix = in.nextLine();
                        
                System.out.println("Office: ");
                String office = in.nextLine();
                
                System.out.println("Department: ");
                String dept = in.nextLine();
                
                System.out.println("Email: ");
                String email = in.nextLine();
                
                boolean test;
                test = false;

                while (test == false){
                    for (int i = 0; i < email.length(); i++){
                        if (email.charAt(i) == '@'){
                            test = true;
                        }
                    }

                    if (test == false){
                        System.out.print("Error! Invalid email address.\nPlease enter a new email address: ");
                        email = in.toString();
                    }
                }
                
                Instructor newInstructor = new Instructor(name, prefix, office, dept, email);
                
                instructorArray.add(newInstructor);
                
                int classSelect = 0;
                
                System.out.println("Please Choose a Course for this Instructor: ");
                
                for(int i = 0; i < courseArray.size(); i++)
                {
                    Course printCourse = courseArray.get(i);
                    
                    System.out.println(printCourse.toString());
                }
                
                System.out.println("Choose Class #: ");
                classSelect = in.nextInt();
                
                //Add instructor to course
            }

            if(userSelect == 5)
            {
                int courseSelect = 0;
                
                System.out.println("Please Choose a Class: ");
                
                for(int i = 0; i < courseArray.size(); i++)
                {
                    System.out.println(courseArray.get(i));
                    
                }
                
                System.out.println("------------------");
                System.out.println("Choose Class #: ");
                courseSelect = in.nextInt();
                
                System.out.println(courseArray.get(courseSelect).getRoster());
            }
            
            System.out.println("Student Management System");
            System.out.println("Please make a menu choice below:");
            System.out.println("--------------------------------");
            System.out.println("1: Create a Course");
            System.out.println("2: Add Student to Course");
            System.out.println("3: Remove Student from Course");
            System.out.println("4: Add Instructor to Course");
            System.out.println("5: Print Roster for Course");
            System.out.println("6: Quit");

            userSelect = in.nextInt();
        }
        
        System.out.println("Exiting...");
    }
    
}