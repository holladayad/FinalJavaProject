/*
Authors: Amber Holladay, Paige Kowahl, Zach Melusen, Emma Morell, Gonzo Ocampo
Date: Apr 28, 2020
Assignment: Group Project Part 2
Purpose: JavaFX Version of the Student Management System
 */
package FinalProject.FinalJavaProject;

// ArrayLists & Database Connection
import java.sql.*;
import oracle.jdbc.pool.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

// FX
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

// ComboBoxes
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.*;

public class StudentFXSystem extends Application
{
    
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

    public RadioButton rbAddStudent = new RadioButton();
    public RadioButton rbRemoveStudent = new RadioButton();
    public Label lblChooseStudent = new Label("Choose Student: ");       
    public Label lblToCourse = new Label("Choose Course:");
    public Label lblInstructIs = new Label("Instructor is:");

    public Button btnUpdateCourse = new Button("Save Changes ");
    
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
    public ComboBox cmboChooseStudent = new ComboBox(olStudents);
    public ComboBox cmboToCourse = new ComboBox(olCourses);
    public ComboBox cmboInstructIs = new ComboBox(olInstructors);
    
    // Display Box Creation
    public TextArea taDisplayArea = new TextArea();  
    
    //Database Connection
    public Connection conn;
    public Statement stmt;
    public ResultSet rs;
        
    @Override
    public void start(Stage primaryStage) throws SQLException
    {        
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

        rbAddStudent.setText("Add Student");
        rbRemoveStudent.setText("Remove Student");
        primaryPane.add(rbAddStudent, 2, 1);
        primaryPane.add(rbRemoveStudent, 3, 1);
        
        // Disabling combo box by default, so that user will add a student first
        cmboChooseStudent.setDisable(true);

        // Disabling check box remove student if add student check box is selected
        rbAddStudent.setOnAction(e ->
        {
            cmboChooseStudent.setDisable(!rbAddStudent.isSelected());
            rbRemoveStudent.setDisable(rbAddStudent.isSelected());
        });
        
        // Doing the inverse 
        rbRemoveStudent.setOnAction(e ->
        {
            cmboChooseStudent.setDisable(!rbRemoveStudent.isSelected());
            rbAddStudent.setDisable(rbRemoveStudent.isSelected());
        });

        primaryPane.add(lblChooseStudent, 2, 2);
        primaryPane.add(cmboChooseStudent, 3, 2);

        primaryPane.add(lblToCourse, 2, 3);
        primaryPane.add(cmboToCourse, 3, 3);
        
        primaryPane.add(chkNewInstruct, 2, 4);
      
        cmboInstructIs.setDisable(true);
       
        chkNewInstruct.setOnAction(e ->
        {
            cmboInstructIs.setDisable(!chkNewInstruct.isSelected());
        });
  
        primaryPane.add(lblInstructIs, 2, 5);
        primaryPane.add(cmboInstructIs, 3, 5);
        
        primaryPane.add(btnUpdateCourse, 3, 6);
        
        primaryPane.add(taDisplayArea, 2, 9, 12, 12);
        
        //Scene
        Scene primaryScene = new Scene(primaryPane, 750, 575);
        primaryStage.setTitle("Student Management System");
        primaryStage.setScene(primaryScene);
        primaryStage.show();
        
        loadDataFromDB();
        
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
            
            if (!failure)
            {
                // Create new Student object
                Double dblGPA = Double.valueOf(txtStudentGPA.getText());
                
                int year = 0;
                
                if(cmboYear.getValue().toString().equals("Freshman"))
                {
                    year = 1;
                }
                
                if(cmboYear.getValue().toString().equals("Sophomore"))
                {
                    year = 2;
                }
                
                if(cmboYear.getValue().toString().equals("Junior"))
                {
                    year = 3;
                }
                
                if(cmboYear.getValue().toString().equals("Senior"))
                {
                    year = 4;
                }
                
                Student newStudent = new Student(txtStudentName.getText(), year, txtStudentMajor.getText(), 
                dblGPA, txtStudentEmail.getText());
                
                studentArray.add(newStudent);
                
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
            
            if (!failure)
            {         
                // Create new Course object
                int cap = Integer.valueOf(txtCourseMaxCap.getText());
                
                Course newCourse = new Course(txtCourseName.getText(), cmboBuilding.getValue().toString(),
                txtCourseRoom.getText(), cap);

                courseArray.add(newCourse);
                olCourses.add(newCourse.getName());
            }
            
            // Clear all fields
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
            
            if (!failure)
            {
            // Create new Instruct object

            Instructor newInstructor = new Instructor(txtInstructName.getText(), cmboPrefix.getValue().toString(),
            txtInstructOffice.getText(),txtInstructDept.getText(), txtInstructEmail.getText());
            
            instructorArray.add(newInstructor);
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
            if (cmboChooseStudent.getValue() != null)
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
                if (rbAddStudent.isSelected())
                {
                    Student currentStudent = studentArray.get(cmboChooseStudent.getSelectionModel().getSelectedIndex());
                    currentCourse.enrollStudent(currentStudent);
                }
                if (rbRemoveStudent.isSelected())
                {
                    Student currentStudent = studentArray.get(cmboChooseStudent.getSelectionModel().getSelectedIndex());
                    currentCourse.removeStudent(currentStudent.getStudentID());
                }

                taDisplayArea.appendText(currentCourse.toString()+"\n");
                taDisplayArea.appendText(currentCourse.getRoster()+"\n");
            }
            
            //Clear all fields
            cmboChooseStudent.getSelectionModel().clearSelection();
            cmboToCourse.getSelectionModel().clearSelection();
            cmboInstructIs.getSelectionModel().clearSelection();
            chkNewInstruct.setSelected(false);
            cmboInstructIs.setDisable(true);
        });
    }

    @Override
    public void stop()
    {
        //Saves everything to the database
        //runs automatically when the program closes
        
        ArrayList<Student> courseStudent;
        Course currentCourse;
        Student currentStudent;
        Instructor currentInstructor;

        //Insert statements for studentenrollment table
        for (int i = 0; i < courseArray.size(); i++)
        {
            currentCourse = courseArray.get(i);
            courseStudent = currentCourse.getStudentArray();

            for (int j = 0; j < courseStudent.size(); j++)
            {
                currentStudent = courseStudent.get(j);

                String sql = "INSERT INTO JAVAUSER.STUDENTENROLLMENT (COURSEID, STUDENTID) VALUES (";
                sql += currentCourse.getCourseID() + ",";
                sql += currentStudent.getStudentID() + ")";

                System.out.println(sql); //Tested on one iteration before crash due to db connection

                sendCommand(sql);

            }
        }

        //insert statements for Student table
        for ( int i = 0; i < studentArray.size(); i++)
        {                
            currentStudent = studentArray.get(i);

            String sql = "INSERT INTO JAVAUSER.STUDENT (STUDENTID, STUDENTNAME, STUDENTYEAR, STUDENTMAJOR"
                    + ", STUDENTGPA, STUDENTEMAIL) VALUES (";
            sql += currentStudent.getStudentID() + ",'";
            sql += currentStudent.getName() + "','";
            sql += currentStudent.getStudentYear() + "','";
            sql += currentStudent.getStudentMajor() + "',";
            sql += currentStudent.getGPA() + ",'";
            sql += currentStudent.getStudentEmail() + "')";

            System.out.println(sql);//Tested, works

            sendCommand(sql);
        }

        //insert statements for course table

        for ( int i = 0; i < courseArray.size(); i++)
        {                
            currentCourse = courseArray.get(i);

            String sql = "INSERT INTO JAVAUSER.COURSE (COURSEID, COURSENAME, COURSEBLDG, COURSEROOM"
                    + ", COURSECAPACITY) VALUES (";
            sql += currentCourse.getCourseID() + ",'";
            sql += currentCourse.getName() + "','";
            sql += currentCourse.getCourseBuilding() + "','";
            sql += currentCourse.getCourseBldgroom() + "',";
            sql += currentCourse.getCapacity() + ")";

            System.out.println(sql);//Tested, works

            sendCommand(sql);
        }

        //insert statements for instructor table
        for ( int i = 0; i < instructorArray.size(); i++)
        {                
            currentInstructor = instructorArray.get(i);

            String sql = "INSERT INTO JAVAUSER.INSTRUCTOR (INSTRID, INSTRNAME, INSTRPREFIX, INSTROFFICE"
                    + ", INSTRDEPT, INSTREMAIL) VALUES (";
            sql += currentInstructor.getID() + ",'";
            sql += currentInstructor.getName() + "','";
            sql += currentInstructor.getTitle() + "','";
            sql += currentInstructor.getOffice() + "','";
            sql += currentInstructor.getDept() + "','";
            sql += currentInstructor.getEmail() + "')";

            System.out.println(sql);//Tested, Works

            sendCommand(sql);
        }
    }
    
    public void sendCommand(String query)
    {
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "javauser";
        String pass = "javapass";
        
        OracleDataSource ds;
        
        try
        {          
            //create the connection using the object from Oracle
            ds = new OracleDataSource();
            
            //set the connection url in the object
            ds.setURL(url);
            
            //attempt to connect with specified username and login, default as "javauser" and "javapass"
            conn = ds.getConnection(user, pass);
            
            //handling the results
            stmt = conn.createStatement(rs.TYPE_SCROLL_SENSITIVE, rs.CONCUR_READ_ONLY);
            
            //send the query to oracle
            rs = stmt.executeQuery(query);
            
        }
        
        catch(SQLException e)
        {           
            System.out.println(e.toString());           
        }       
    }
    
    // Implements a data read from the Student DB Table
    public void loadDataFromDB() throws SQLException
    {
        String allRows = "SELECT * FROM STUDENT";
        sendCommand(allRows);
        
        int rowCt = 0;

            Student createStu;
            while(rs.next())
            {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String year = rs.getString(3);
                String major = rs.getString(4);
                double gpa = rs.getDouble(5);
                String email = rs.getString(6);
                
                int newYear = 0;
        
        switch (year)
        {
            case "Freshman": newYear = 1;
            break;
            case "Sophomore": newYear = 2;
            break;
            case "Junior": newYear = 3;
            break;
            case "Senior": newYear = 4;
            break;
        }

                createStu = new Student(id, name, newYear, major, gpa, email);

                studentArray.add(createStu);
                olStudents.add(createStu.getName());
            }
        
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
    
}