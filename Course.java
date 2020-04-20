package FinalProject.FinalJavaProject;

public class Course 
{
   private String courseName; 
   private String courseBuilding;
   private String courseBldgRoom;
   private int courseCapacity; 
   private int CourseID;
   private static int nextCourseID = 0;
      
    // constructor 
    public Course(String name, String building, String room, int capacity)
    {
        this.CourseID = nextCourseID++;
        this.courseName = name;
        this.courseBuilding = building;
        this.courseBldgRoom = room;
        this.courseCapacity = capacity;
        
        //  this needs to be added into main:   (So im writing the class assuming its already in there 
        // public static ArrayList<Student> studentList = new ArrayList<Student>();
        Application.studentList.add(this);
    }
    
   public void enrollStudent(Student newStudent)
   {
      
   }
   
   public boolean removeStudent(int studentID)
   {
       
       return true;
   }
   
   public void assignInstructor(Instructor newInstructor)
   {
      
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
   
   public String toString()
   {
       String toString = "";
       return toString;
   }
   
   public String getRoster()
   {
       return this.roster;
   }
}