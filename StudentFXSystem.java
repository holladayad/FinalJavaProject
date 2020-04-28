/*
Authors:
Date: Apr 28, 2020
Assignment: Group Project Part 2
Purpose: JavaFX Version of the Student Management System
 */
package FinalProject.FinalJavaProject;

// ArrayLists
import java.util.*;

// FX
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

// ComboBoxes
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;

public class StudentFXSystem extends Application {
    
    public static ArrayList<Student> studentArray = new ArrayList<>();
    public static ArrayList<Course> courseArray = new ArrayList<>();
    public static ArrayList<Instructor> instructorArray = new ArrayList<>();
    
    public static ObservableList olStudents = FXCollections.observableArrayList();
    public static ObservableList olCourses = FXCollections.observableArrayList();
    public static ObservableList olInstructors = FXCollections.observableArrayList();
    
    // LABELS & ASSOCIATED TEXTFIELDS
    
    // Headers
    public Label lblStudent = new Label("Add Student:");
    public Label lblCourse = new Label("Add Course:");
    public Label lblInstructor = new Label("Add Instrcutor:");
    public Label lblBuild = new Label("Build a Course:");
    
    // Student
    public Label lblNameStudent = new Label("Name:");
    public TextField txtStudentName = new TextField();
    
    public Label lblYear = new Label("Year:");
    
    public Label lblMajor = new Label("Major:");
    public TextField txtStudentMajor = new TextField();
    
    public Label lblGPA = new Label("GPA:");
    public TextField txtStudentGPA = new TextField();
    
    public Label lblEmailStudent = new Label("Email:");
    public TextField txtStudentEmail = new TextField();
    
    // Add Course
    public Label lblNameCourse = new Label("Name:");
    public TextField txtCourseName = new TextField();
    
    public Label lblBuilding = new Label("Building:");
    
    public Label lblRoom = new Label("Room:");
    public TextField txtCourseRoom = new TextField();
    
    public Label lblMaxCap = new Label("Max Capacity:");
    public TextField txtCourseMaxCap = new TextField();
    
    // Add Instructor
    public Label lblNameInstructor = new Label("Name:");
    public TextField txtInstructName = new TextField();
    
    public Label lblPrefix = new Label("Prefix:");
    
    public Label lblOffice = new Label("Office:");
    public TextField txtInstructOffice = new TextField();
    
    public Label lblDept = new Label("Department:");
    public TextField txtInstructDept= new TextField();
    
    public Label lblEmailInstructor = new Label("Email:");
    public TextField txtInstructEmail = new TextField();
   
    // Build a Course
    public Label lblAddStudent = new Label("Add Student:");
    public Label lblToCourse = new Label("To Course:");
    public Label lblNewInstruct = new Label("New Instructor?");
    public Label lblInstrucIs = new Label("Instrucotr is:");
    
    // BUTTONS
    public Button btnAddStudent = new Button("Add Student ->");
    public Button btnAddCourse = new Button("Add Course ->");
    public Button btnAddInstructor = new Button("Add Instructor ->");
    public Button btnUpdateCourse = new Button("Update Course ->");
    
    // COMBOBOX
    
    // Years
    public String years[] = { "Freshman", "Sophomore", "Junior", "Senior" };
    public ComboBox cmboYear = new ComboBox(FXCollections.observableArrayList(years));
    
    // Buildings
    public String building[] = { "Showker", "Chandler", "Burruss Hall", "Godwin" };
    public ComboBox cmboBuilding = new ComboBox(FXCollections.observableArrayList(building));
    
    // Prefix
    public String prefix[] = { "Dr.", "Ms.", "Mrs.", "Mr." };
    public ComboBox cmboPrefix = new ComboBox(FXCollections.observableArrayList(prefix));
    
    // Building A Course
    public ComboBox cmboAddStudent = new ComboBox(olStudents);
    public ComboBox cmboToCourse = new ComboBox(olCourses);
    public ComboBox cmboInstructIs = new ComboBox(olInstructors);
    
    // Display Box
    public TextArea taDisplayArea = new TextArea();
        
    @Override
    public void start(Stage primaryStage) {
        //All Controls
        
        //Pane
        
        //Scene
        
    }

    // Method one: Non-static, update ComboBox Lists
    
    // Method Two: Non-static, populate output area based on selected course

    public static void main(String[] args) {
        launch(args);
    }
    
}
