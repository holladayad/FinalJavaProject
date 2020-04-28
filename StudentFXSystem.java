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
import javafx.geometry.*;

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
    public Label lblInstructIs = new Label("Instrucotr is:");
    
    // BUTTONS
    public Button btnAddStudent = new Button("Add Student ->");
    public Button btnAddCourse = new Button("Add Course ->");
    public Button btnAddInstructor = new Button("Add Instructor ->");
    public Button btnUpdateCourse = new Button("Update Course ->");
    
    // COMBOBOX - Listed in directions as pre-populated
    
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
    
    // Check Box
    public CheckBox chkNewInstruct = new CheckBox("New Instructor?");
        
    @Override
    public void start(Stage primaryStage) {
        // All Controls
        
        // Pane
        GridPane primaryPane = new GridPane();
        GridPane addStudentPane = new GridPane();
        GridPane addCoursePane = new GridPane();
        GridPane addInstructPane = new GridPane();
        GridPane buildCoursePane = new GridPane();
        
        TabPane tpTabs = new TabPane();
        Tab tabAddStudent = new Tab("Add Student");
        Tab tabAddCourse = new Tab("Add Course");
        Tab tabAddInstructor = new Tab("Add Instructor");
        Tab tabBuildCourse = new Tab("Build a Course");
        
        tpTabs.getTabs().add(tabAddStudent);
        tpTabs.getTabs().add(tabAddCourse);
        tpTabs.getTabs().add(tabAddInstructor);
        tpTabs.getTabs().add(tabBuildCourse);
        
        primaryPane.add(tpTabs, 0,0);
        
        tabAddStudent.setContent(addStudentPane);
        tabAddCourse.setContent(addCoursePane);
        tabAddInstructor.setContent(addInstructPane);
        tabBuildCourse.setContent(buildCoursePane);
        
        addStudentPane.setPadding(new Insets(3,3,3,3));
        addCoursePane.setPadding(new Insets(3,3,3,3));
        addInstructPane.setPadding(new Insets(3,3,3,3));
        buildCoursePane.setPadding(new Insets(3,3,3,3));
        
        // Add Student Section
        addStudentPane.add(lblStudent, 0, 0);
        
        addStudentPane.add(lblNameStudent, 0, 1);
        addStudentPane.add(txtStudentName, 1, 1);
        
        addStudentPane.add(lblYear, 0, 2);
        addStudentPane.add(cmboYear, 1, 2);
        
        addStudentPane.add(lblMajor, 0, 3);
        addStudentPane.add(txtStudentMajor, 1, 3);
        
        addStudentPane.add(lblGPA, 0, 4);
        addStudentPane.add(txtStudentGPA, 1, 4);
        
        addStudentPane.add(lblEmailStudent, 0, 5);
        addStudentPane.add(txtStudentEmail, 1, 5);
        
        addStudentPane.add(btnAddStudent, 1, 6);
        
        // Add Course Section
        addCoursePane.add(lblCourse, 2, 0);
        
        addCoursePane.add(lblNameCourse, 2, 1);
        addCoursePane.add(txtCourseName, 3, 1);
        
        addCoursePane.add(lblBuilding, 2, 2);
        addCoursePane.add(cmboBuilding, 3, 2);
        
        addCoursePane.add(lblRoom, 2, 3);
        addCoursePane.add(txtCourseRoom, 3, 3);
        
        addCoursePane.add(lblMaxCap, 2, 4);
        addCoursePane.add(txtCourseMaxCap, 3, 4);
        
        addCoursePane.add(btnAddCourse, 3, 5);
        
        // Add Instructor Section
        addInstructPane.add(lblInstructor, 4, 0);
        
        addInstructPane.add(lblNameInstructor, 4, 1);
        addInstructPane.add(txtInstructName, 5, 1);
        
        addInstructPane.add(lblPrefix, 4, 2);
        addInstructPane.add(cmboPrefix, 5, 2);
        
        addInstructPane.add(lblOffice, 4, 3);
        addInstructPane.add(txtInstructOffice, 5, 3);
        
        addInstructPane.add(lblDept, 4, 4);
        addInstructPane.add(txtInstructDept, 5, 4);
        
        addInstructPane.add(lblEmailInstructor, 4, 5);
        addInstructPane.add(txtInstructEmail, 5, 5);
        
        addInstructPane.add(btnAddInstructor, 5, 6);
        
        // Add Build Section
        buildCoursePane.add(lblBuild, 0, 7);
        
        buildCoursePane.add(lblAddStudent, 0, 8);
        buildCoursePane.add(cmboAddStudent, 1, 8);
        
        buildCoursePane.add(lblToCourse, 0, 9);
        buildCoursePane.add(cmboToCourse, 1, 9);
        
        buildCoursePane.add(chkNewInstruct, 0, 10);
        
        buildCoursePane.add(lblInstructIs, 0, 11);
        buildCoursePane.add(cmboInstructIs, 1, 11);
        
        buildCoursePane.add(btnUpdateCourse, 1, 12);
        
        buildCoursePane.add(taDisplayArea, 2, 13);
        
        //Scene
        Scene primaryScene = new Scene(primaryPane, 700, 300);
        primaryStage.setTitle("Student Management System");
        primaryStage.setScene(primaryScene);
        primaryStage.show();
        
    }

    // Method one: Non-static, update ComboBox Lists
    
    // Method Two: Non-static, populate output area based on selected course

    public static void main(String[] args) {
        launch(args);
    }
    
}
