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
        int end; //end of first name
        int beg; //beg of last name
        
        //Find the first name index values
        for (int count = 0; count < this.name.length(); count++){
            if (this.name.charAt(count) == ' '){ //if the current character is a space, record the index
                end = count;
            }
        }      
        beg = end + 1; //record the index of the beginning of the last name
                
        first = name.substring(0, end);
        last = name.substring(beg, name.length)
        
        String newYear;
        
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
        
        while (GPA > 5.0 | GPA < 0.0){
            
            System.out.print ("Error! Invalid GPA. GPA must be between 0.0 and 5.0.\nPlease enter a new GPA: ");
            GPA = in.nextDouble();
        }
        
        boolean test;
        test = false;
        
        while (test == false){
            for (int i = 0; i < this.email.length(); i++){
                if (this.email.charAt(i) == '@'){
                    test = true
                }
            }

            if (test == false){
                System.out.print("Error! Invalid email address.\nPlease enter a new email address: ");
                    email = in.nextString();
            }
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
    
    
    public void setGPA(double GPA){
        
        this.GPA = GPA;
    }
    
    
    public double getGPA(){
        
        return this.GPA;
    }
    
    
    public String getName(){
        
        return this.lastName + ", " + this.firstName;
    }
    
    
    public int getStudentID(){
        
        return this.studentID;
    }
    
    
    public void setStudentEmail(String email){
        
        this.StudentEmail = email;
    }
    
    
    public String getStudentYear(){
        
        return this.studentYear;
    }
    
    
    public void setStudentYear(int year){
        
        this.StudentYear = year;
    }
    
    
    public String getStudentMajor(){
        
        return this.studentMajor;
    }
    
    
    public void setStudentMajor(String major){
        
        this.StudentMajor = major;
    }
}
