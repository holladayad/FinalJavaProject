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
    
    public static void main(String[] args) {
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

        userSelect = in.nextInt();

        while (userSelect != 6)
        {

            if(userSelect == 1)
            {
                System.out.println("Creating Class...");
                System.out.println("Enter Course Name: ");
                System.out.println("Enter Building: ");
                System.out.println("Enter Room Number: ");
                System.out.println("Enter Room Capacity: ");
            }

            if(userSelect == 2)
            {
                System.out.println("Enter Student Information: ");
                System.out.println("Name (firstname lastname): ");
                
                System.out.println("Major: ");
                System.out.println("Year: ");
                System.out.println("GPA: ");
                System.out.println("Email: ");
                
                while (GPA > 5.0 | GPA < 0.0){
                    System.out.print ("Error! Invalid GPA. GPA must be between 0.0 and 5.0.\nPlease enter a new GPA: ");
                    GPA = in.nextDouble();
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
                        email = in.toString();
                    }
                }
                
                System.out.println("Please Choose a Class: "); // Print all created courses
                System.out.println("Choose Class #: "); // User input course #
            }

            if(userSelect == 3)
            {
                System.out.println("Please Choose a Student: "); // Print all created courses
                System.out.println("Type ID of Student to Remove: "); // User input course #
                System.out.println("Student Successfully Removed!");
            }

            if(userSelect == 4)
            {
                System.out.println("Enter Instructor Information");
                System.out.println("Name: ");
                System.out.println("Prefix: ");
                System.out.println("Office: ");
                System.out.println("Department: ");
                System.out.println("Email: ");
                
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
                
                System.out.println("Please Choose a Couse for this Instructor: "); // Print all created courses
                System.out.println("Choose Class #: "); // User input course #
            }

            if(userSelect == 5)
            {
                System.out.println("Please Choose a Class: "); // Print all created courses
                System.out.println("Choose Class #: "); // User input course #
                // Print all student info
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
    }
    
}