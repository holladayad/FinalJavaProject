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
            // Needs error checking for email and GPA
            }

            if(userSelect == 2)
            {
                
            }

            if(userSelect == 3)
            {
                
            }

            if(userSelect == 4)
            {
            // Needs error checking for email
            }

            if(userSelect == 5)
            {
                
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
