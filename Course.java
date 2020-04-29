/*
Author: Amber Holladay and Gonzo Ocamp
Date: Apr 24, 2020
Assignment: Group Project Part 1
Purpose: Course Class to create new Course objects for overall program
 */

package FinalProject.FinalJavaProject;
import java.util.*;

public class Course 
{
   private String courseName; 
   private String courseBuilding;
   private String courseBldgRoom;
   private int courseCapacity; 
   private int CourseID;
   private static int nextCourseID = 0;
   private ArrayList<Student> enrolledStudents;
   private Instructor courseInstructor;
      
   //comment
   
    // constructor 
    public Course(String name, String building, String room, int capacity)
    {
        this.CourseID = nextCourseID++;
        this.courseName = name;
        this.courseBuilding = building;
        this.courseBldgRoom = room;
        this.courseCapacity = capacity;
        this.enrolledStudents = new ArrayList<>();
        this.courseInstructor = null;

    }
    
   public void enrollStudent(Student newStudent)
   {
      this.enrolledStudents.add(newStudent);
   }
   
   public boolean removeStudent(int studentID)
   {
       for (int i=0; i<enrolledStudents.size();i++)
       {
           Student currentStudent = this.enrolledStudents.get(i);
           if (currentStudent.getStudentID() == studentID)
           {
               this.enrolledStudents.remove(i);
               return true;
           }
       }
       return false;
   }
   
   public void assignInstructor(Instructor newInstructor)
   {
      this.courseInstructor = newInstructor;
   }
  
   public String setCourseBldgroom(String room)
   {
       this.courseBldgRoom = room;
       return room;
   }
   
   public void setCourseBuilding(String building)
   {
      this.courseBuilding = building;
   }
   
   public void setCapacity(int newCapacity)
   {
      this.courseCapacity = newCapacity;
   }
   
   public void setCourseName(String name)
   {
       this.courseName = name;
   }
   
   @Override
   public String toString()
   {
       String instructor = "None";
       if (this.courseInstructor!=null)
       {
           instructor = this.courseInstructor.toString();
       }
       String toString = String.format("Course #%d Course: %s Location: %s Room: %s Capacity: %d\n"
               + "Instructor of Record: %s", this.CourseID, this.courseName, this.courseBuilding,
               this.courseBldgRoom, this.courseCapacity, instructor);
       return toString;
   }
   
   public String getRoster()
   {
       if(this.enrolledStudents.isEmpty())
       {
           return "This course has no students enrolled.";
       }
       
       String roster = "";
       
       for(int i=0;i<this.enrolledStudents.size();i++)
       {
          Student current = this.enrolledStudents.get(i);
          String s = String.format("Student ID#: %d %s Major: %s Year: %s\n", 
                  current.getStudentID(), current.getName(), current.getStudentMajor(), 
                  current.getStudentYear());
          roster += s;
       }
       return roster;
   }
}