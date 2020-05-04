/*
Author: Emma Morell (unless otherwise noted), Amber Holladay
Date: Apr 24, 2020
Assignment: Group Project Part 1
Purpose: Student Class to create new Student Objects for the overall program.
 */
package FinalProject.FinalJavaProject;

import java.util.*;

public class Student {
    private String firstName;
    private String lastName;
    private String studentYear;
    private String studentMajor;
    private double GPA;
    private String studentEmail;
    private int studentID;
    private static int nextStudentID = 1000;
    
    Scanner in = new Scanner(System.in);
    
    public Student(String name, int year, String major, double GPA, String email){
        
        String first; //first name 
        String last; //last name
        int end = 0; //end of first name
        int beg; //beg of last name
        
        //Find the first name index values
        for (int count = 0; count < name.length(); count++){
            if (name.charAt(count) == ' '){ //if the current character is a space, record the index
                end = count;
            }
        }      
        beg = end + 1; //record the index of the beginning of the last name
                
        first = name.substring(0, end);
        last = name.substring(beg, name.length());
        
        String newYear = "";
        
        switch (year) {
            case 1: newYear = "Freshman";
            break;
            case 2: newYear = "Sophomore";
            break;
            case 3: newYear = "Junior";
            break;
            case 4: newYear = "Senior";
            break;
        }
            
        this.firstName = first;
        this.lastName = last;
        this.studentYear = newYear;
        this.studentMajor = major;
        this.GPA = GPA;
        this.studentEmail = email;
        this.studentID = nextStudentID;
            
        nextStudentID++;
    }
    
    public Student(String name, String year, String major, double GPA, String email){
        
        String first; //first name 
        String last; //last name
        int end = 0; //end of first name
        int beg; //beg of last name
        
        //Find the first name index values
        for (int count = 0; count < name.length(); count++){
            if (name.charAt(count) == ' '){ //if the current character is a space, record the index
                end = count;
            }
        }      
        beg = end + 1; //record the index of the beginning of the last name
                
        first = name.substring(0, end);
        last = name.substring(beg, name.length());
            
        this.firstName = first;
        this.lastName = last;
        this.studentYear = year;
        this.studentMajor = major;
        this.GPA = GPA;
        this.studentEmail = email;
        this.studentID = nextStudentID;
            
        nextStudentID++;
    }
    public Student(int ID, String name, String year, String major, double GPA, String email)
    {
        
    }
    
    
    public void setGPA(double GPA){
        
        this.GPA = GPA;
    }
    
    //Start Amber Holladay
    public double getGPA(){
        
        return this.GPA;
    }
    
    public String getName(){
        
        return this.lastName + ", " + this.firstName;
    }
    
    
    public int getStudentID(){
        
        return this.studentID;
    }
    //End Amber Holladay
    
    public String getStudentEmail(){
        
        return this.studentEmail;
    }
    
    public void setStudentEmail(String email){
        
        this.studentEmail = email;
    }
    
    //Begin Amber Holladay
    public String getStudentYear(){
        
        return this.studentYear;
    }
    //End Amber Holladay
    
    public void setStudentYear(int year){
        
        String newYear = "";
        
        switch (year) {
            case 1: newYear = "Freshman";
            break;
            case 2: newYear = "Sophomore";
            break;
            case 3: newYear = "Junior";
            break;
            case 4: newYear = "Senior";
            break;
        }
        this.studentYear = newYear;                
        
    }
    
    public String getStudentMajor(){
        
        return this.studentMajor;
    }
    
    public void setStudentMajor(String major){
        
        this.studentMajor = major;
    }
}