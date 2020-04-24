/*
Author: Paige Kowahl (unless otherwise noted), Amber Holladay
Date: Apr 21, 2020
Assignment: Group Project Part 1
Purpose: Instructor Class to create new Instructor Objects for the overall program.
 */
package FinalProject.FinalJavaProject;


public class Instructor
{
    private String name;
    private String prefix;
    private String officeLocation;
    private String department;
    private String email;
    private int instructorID;
    private static int nextInstructorID = 2000;
    
    public Instructor(String name, String prefix, String office, String dept, String email)
    {
        this.name = name;
        this.prefix = prefix;
        this.officeLocation = office;
        this.department = dept;
        this.email = email;
        instructorID = nextInstructorID;
        nextInstructorID++;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setPrefix(String prefix)
    {
        this.prefix = prefix;
    }
    
    public void setDepartment(String dept)
    {
        this.department = dept;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public void setOfficeLocation(String office)
    {
        this.officeLocation = office;
    }
    
    public String getTitle()
    {
        return this.prefix;
    }
    
    @Override
    public String toString() //Amber Holladay
    {
        return "Name: " + this.name + " Department: " + this.department + " Office: "
                + this.officeLocation + " Email: " + this.email;
    }
}
