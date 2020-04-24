// Created By Amber Holladay and Gonzo Ocampo
// Course Class

package FinalProject.FinalJavaProject;
import java.util.*;

// test 
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
        
        
        // I don't think this will work well
        //  this needs to be added into main:   (So im writing the class assuming its already in there 
        // public static ArrayList<Student> studentList = new ArrayList<Student>();
        // Application.studentList.add(this);
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