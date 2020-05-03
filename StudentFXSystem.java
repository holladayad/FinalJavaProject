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
import javafx.event.EventType;
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
    public Label lblInstructor = new Label("Add Instructor:");
    public Label lblBuild = new Label("Build a Course:");
    
    // Add Student
    public Label lblNameStudent = new Label("Name:");
    public TextField txtStudentName = new TextField();
    
    public Label lblYear = new Label("Year:");
    
    public Label lblMajor = new Label("Major:");
    public TextField txtStudentMajor = new TextField();
    
    public Label lblGPA = new Label("GPA:");
    public TextField txtStudentGPA = new TextField();
    
    public Label lblEmailStudent = new Label("Email:");
    public TextField txtStudentEmail = new TextField();
    
    public Button btnAddStudent = new Button("Add Student ->");
    
    // Add Course
    public Label lblNameCourse = new Label("Name:");
    public TextField txtCourseName = new TextField();
    
    public Label lblBuilding = new Label("Building:");
    
    public Label lblRoom = new Label("Room:");
    public TextField txtCourseRoom = new TextField();
    
    public Label lblMaxCap = new Label("Max Capacity:");
    public TextField txtCourseMaxCap = new TextField();
    
    public Button btnAddCourse = new Button("Add Course ->");
    
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
    
    public Button btnAddInstructor = new Button("Add Instructor ->");
   
    // Build a Course
    public Label lblAddStudent = new Label("Add Student:");
    public Label lblToCourse = new Label("To Course:");
    public Label lblInstructIs = new Label("Instructor is:");

    public Button btnUpdateCourse = new Button("Update Course ->");
    
    public CheckBox chkNewInstruct = new CheckBox("New Instructor?");
    
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
    
    // ComboBox Build
    public ComboBox cmboAddStudent = new ComboBox(olStudents);
    public ComboBox cmboToCourse = new ComboBox(olCourses);
    public ComboBox cmboInstructIs = new ComboBox(olInstructors);
    
    // Display Box Creation
    public TextArea taDisplayArea = new TextArea();    
        
    @Override
    public void start(Stage primaryStage) {
        
        // Pane
        GridPane primaryPane = new GridPane();
        
        primaryPane.setHgap(10);
        primaryPane.setVgap(3);
        primaryPane.setPadding(new Insets(3,3,3,3));
        
        // Add Student Section
        primaryPane.add(lblStudent, 0, 0);
        
        primaryPane.add(lblNameStudent, 0, 1);
        primaryPane.add(txtStudentName, 1, 1);
        
        primaryPane.add(lblYear, 0, 2);
        primaryPane.add(cmboYear, 1, 2);
        
        primaryPane.add(lblMajor, 0, 3);
        primaryPane.add(txtStudentMajor, 1, 3);
        
        primaryPane.add(lblGPA, 0, 4);
        primaryPane.add(txtStudentGPA, 1, 4);
        
        primaryPane.add(lblEmailStudent, 0, 5);
        primaryPane.add(txtStudentEmail, 1, 5);
        
        primaryPane.add(btnAddStudent, 1, 6);
        
        // Add Course Section
        primaryPane.add(lblCourse, 0, 7);
        
        primaryPane.add(lblNameCourse, 0, 8);
        primaryPane.add(txtCourseName, 1, 8);
        
        primaryPane.add(lblBuilding, 0, 9);
        primaryPane.add(cmboBuilding, 1, 9);
        
        primaryPane.add(lblRoom, 0, 10);
        primaryPane.add(txtCourseRoom, 1, 10);
        
        primaryPane.add(lblMaxCap, 0, 11);
        primaryPane.add(txtCourseMaxCap, 1, 11);
        
        primaryPane.add(btnAddCourse, 1, 12);
        
        // Add Instructor Section
        primaryPane.add(lblInstructor, 0, 13);
        
        primaryPane.add(lblNameInstructor, 0, 14);
        primaryPane.add(txtInstructName, 1, 14);
        
        primaryPane.add(lblPrefix, 0, 15);
        primaryPane.add(cmboPrefix, 1, 15);
        
        primaryPane.add(lblOffice, 0, 16);
        primaryPane.add(txtInstructOffice, 1, 16);
        
        primaryPane.add(lblDept, 0, 17);
        primaryPane.add(txtInstructDept, 1, 17);
        
        primaryPane.add(lblEmailInstructor, 0, 18);
        primaryPane.add(txtInstructEmail, 1, 18);
        
        primaryPane.add(btnAddInstructor, 1, 19);
        
        // Add Build Course Section
        primaryPane.add(lblBuild, 2, 0);
        
        primaryPane.add(lblAddStudent, 2, 1);
        primaryPane.add(cmboAddStudent, 3, 1);
        
        primaryPane.add(lblToCourse, 2, 2);
        primaryPane.add(cmboToCourse, 3, 2);
        
        primaryPane.add(chkNewInstruct, 2, 3);
        
        cmboInstructIs.setDisable(true);
        
        chkNewInstruct.setOnAction(e ->{
            cmboInstructIs.setDisable(!chkNewInstruct.isSelected());
        });
        
        primaryPane.add(lblInstructIs, 2, 4);
        primaryPane.add(cmboInstructIs, 3, 4);
        
        primaryPane.add(btnUpdateCourse, 3, 5);
        
        primaryPane.add(taDisplayArea, 2, 9, 12, 12);
        
        //Scene
        Scene primaryScene = new Scene(primaryPane, 750, 575);
        primaryStage.setTitle("Student Management System");
        primaryStage.setScene(primaryScene);
        primaryStage.show();
        
        /*        
        TO APPLICATION FILE:
        
        Method one: Non-static, update ComboBox Lists
        Method Two: Non-static, populate output area based on selected course
        */
        
        // Code for when Add Student Button Clicked
        btnAddStudent.setOnAction(e -> 
        {            
            taDisplayArea.clear();
            boolean failure = false;
            if(txtStudentName.getText().isEmpty())
            {
                failure = true;
                taDisplayArea.appendText("Error! Please Input Name!\n");
            }
            
            // Error Check for Year Combo Box Being Empty
            if (cmboYear.getValue()== null)
            {
                failure = true;
                taDisplayArea.appendText("Error! Please select Year!\n");
            }
            
            if(txtStudentMajor.getText().isEmpty())
            {
                failure = true;
                taDisplayArea.appendText("Error! Please Input Major!\n");
            }
            
            if(txtStudentGPA.getText().isEmpty())
            {
                failure = true;
                taDisplayArea.appendText("Error! Please Input Valid GPA!\n");
            }
            
            if(!txtStudentGPA.getText().isEmpty())
            {
                // Convert GPA to a Double for error checking purposes
                Double dblGPA = Double.valueOf(txtStudentGPA.getText());
                
                if(dblGPA < 0.0 || dblGPA > 5.0)
                {
                    failure = true;
                    taDisplayArea.appendText("Error! Please Input Valid GPA!\n");
                }
            }
            
            if(txtStudentEmail.getText().isEmpty())
            {
                failure = true;
                taDisplayArea.appendText("Error! Please Input Valid Email!\n");
            }
            
            if(!txtStudentEmail.getText().isEmpty())
            {
                boolean test;
                test = false;
                
                String email = txtStudentEmail.getText();

                for (int i = 0; i < email.length(); i++)
                {
                    if (email.charAt(i) == '@')
                    {
                        test = true;
                    }
                }
                
                if(test == false)
                {
                    failure = true;
                    taDisplayArea.appendText("Error! Please Input Valid Email!\n");
                }
            }
            
            // Convert the Year selection to the int equivalent
            
            if (!failure){
                // Create new Student object
                Double dblGPA = Double.valueOf(txtStudentGPA.getText());
                Student newStudent = new Student(txtStudentName.getText(), cmboYear.getValue().toString(), txtStudentMajor.getText(), 
                dblGPA, txtStudentEmail.getText());
                // Add Student to ArrayList
                studentArray.add(newStudent);
                // Add Student to ListView
                olStudents.add(newStudent.getName());
            }
            
            // Clear all fields
            txtStudentName.clear();
            txtStudentMajor.clear();
            txtStudentGPA.clear();
            txtStudentEmail.clear();
            cmboYear.getSelectionModel().clearSelection();
                        
        });
        
        // Code for when Add Course Button Clicked
        btnAddCourse.setOnAction(e -> 
        {
            taDisplayArea.clear();
            boolean failure = false;
            if(txtCourseName.getText().isEmpty())
            {
                failure = true;
                taDisplayArea.appendText("Error! Please Input Name!\n");
            }
            //Error Check for Building Combo Box Being Empty
            if (cmboBuilding.getValue()== null)
            {
                failure = true;
                taDisplayArea.appendText("Error! Please select a Building!\n");
            }
            if(txtCourseRoom.getText().isEmpty())
            {
                failure = true;
                taDisplayArea.appendText("Error! Please Input Valid Room Number!\n");
            }
            
            if(txtCourseMaxCap.getText().isEmpty())
            {
                failure = true;
                taDisplayArea.appendText("Error! Please Input Valid Capacity!\n");
            }
            
            if (!failure){
                                
                // Convert Course Cap to int
                int cap = Integer.valueOf(txtCourseMaxCap.getText());
                // Create new Course object
                Course newCourse = new Course(txtCourseName.getText(), cmboBuilding.getValue().toString(),
                txtCourseRoom.getText(), cap);
                // Add Course to ArrayList
                courseArray.add(newCourse);
                // Add Course to ListView
                olCourses.add(newCourse.getName());
            }
            // Clear all values
            txtCourseName.clear();
            txtCourseRoom.clear();
            txtCourseMaxCap.clear();
            cmboBuilding.getSelectionModel().clearSelection();
        });
        
        // Code for when Add Instructor Button Clicked
        btnAddInstructor.setOnAction(e -> 
        {
            
            taDisplayArea.clear();
            boolean failure = false;
            if(txtInstructName.getText().isEmpty())
            {
                failure = true;
                taDisplayArea.appendText("Error! Please Input Name!\n");
            }
            
            // Error Check for Prefix Combo Box Being Empty
            if (cmboPrefix.getValue()== null)
            {
                failure = true;
                taDisplayArea.appendText("Error! Please select a Prefix!\n");
            }
            
            if(txtInstructOffice.getText().isEmpty())
            {
                failure = true;
                taDisplayArea.appendText("Error! Please Input Valid Office Number!\n");
            }
            
            if(txtInstructDept.getText().isEmpty())
            {
                failure = true;
                taDisplayArea.appendText("Error! Please Input Valid Department!\n");
            }
            
            if(txtInstructEmail.getText().isEmpty())
            {
                failure = true;
                taDisplayArea.appendText("Error! Please Input Valid Email!");
            }
            
            if(!txtInstructEmail.getText().isEmpty())
            {
                boolean test;
                test = false;
                
                String email = txtInstructEmail.getText();

                for (int i = 0; i < email.length(); i++)
                {
                    if (email.charAt(i) == '@')
                    {
                        test = true;
                    }
                }
                
                if(test == false)
                {
                    failure = true;
                    taDisplayArea.appendText("Error! Please Input Valid Email!\n");
                }
                
            }
            if (!failure){
            // Create new Instruct object
            //public Instructor(String name, String prefix, String office, String dept, String email)
            Instructor newInstructor = new Instructor(txtInstructName.getText(), cmboPrefix.getValue().toString(),
            txtInstructOffice.getText(),txtInstructDept.getText(), txtInstructEmail.getText());
            
            // Add Instruct to ArrayList
            instructorArray.add(newInstructor);
            // Add Instruct to ListView
            olInstructors.add(newInstructor.getName());
            }
            // Clear all values
            txtInstructName.clear();
            txtInstructOffice.clear();
            txtInstructDept.clear();
            txtInstructEmail.clear();
            cmboPrefix.getSelectionModel().clearSelection();
        });
        
        // Code for when Update Course Button Clicked
        btnUpdateCourse.setOnAction(e -> 
        {
            taDisplayArea.clear();
            boolean failure = false;
            boolean isStudent = false;
            
            if (cmboToCourse.getValue() == null)
                {
                    failure = true;
                    taDisplayArea.appendText("Error! Please select Course!\n");
                }
            if (cmboAddStudent.getValue() != null)
            {
                isStudent = true;
            }
            if (chkNewInstruct.isSelected())
            {
                 if (cmboInstructIs.getValue() == null)
                {
                    failure = true;
                    taDisplayArea.appendText("Error! Please select Instructor!\n");
                }
            }
            else
            {
                if (!isStudent)
                {
                    failure = true;
                    taDisplayArea.appendText("Error! Please select Student!\n");
                }
            }
            if (!failure)
            {
                Course currentCourse = courseArray.get(cmboToCourse.getSelectionModel().getSelectedIndex());
                if (chkNewInstruct.isSelected())
                {
                   Instructor currentInstructor = instructorArray.get(cmboInstructIs.getSelectionModel().getSelectedIndex());
                   currentCourse.assignInstructor(currentInstructor);
                }
                if (isStudent)
                {
                    Student currentStudent = studentArray.get(cmboAddStudent.getSelectionModel().getSelectedIndex());
                    currentCourse.enrollStudent(currentStudent);
                }
                taDisplayArea.appendText(currentCourse.toString()+"\n");
                taDisplayArea.appendText(currentCourse.getRoster()+"\n");
            }
            //Clear all fields
            cmboAddStudent.getSelectionModel().clearSelection();
            cmboToCourse.getSelectionModel().clearSelection();
            cmboInstructIs.getSelectionModel().clearSelection();
            chkNewInstruct.setSelected(false);
            cmboInstructIs.setDisable(true);
        });
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}