package FinalProject.FinalJavaProject;


public class Student {
    private String firstName;
    private String lastName;
    private String studentYear;
    private String studentMajor;
    private double GPA;
    private String studentEmail;
    private int studentID;
    private static int nextStudentID = 1000;
    
    
    
    
    
    
    
    public String getName()
    {
        return this.lastName + ", " + this.firstName;
    }
    
    
    public int getStudentID()
    {
        
        return this.studentID;
    }
    
    public String getStudentYear()
    {
        return this.studentYear;
    }
    
    public String getStudentMajor()
    {
        return this.studentMajor;
    }
}
