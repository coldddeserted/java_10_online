package ua.com.alevel.hw7.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import ua.com.alevel.hw7.entity.Student;
import ua.com.alevel.hw7.reactiv.NativePubSub;
import ua.com.alevel.hw7.service.StudentService;
import ua.com.alevel.hw7.service.impl.StudentServiceImpl;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentViewController implements Initializable {
    private final StudentService studentService = new StudentServiceImpl();

    @FXML
    private TextField studentIdText;

    @FXML
    private TextField studentFirstNameText;

    @FXML
    private TextField studentLastNameText;

    @FXML
    private TextField studentGroupIdText;

    @FXML
    private Button createStudent;

    @FXML
    private Button updateStudent;

    @FXML
    private Button deleteStudent;

    @FXML
    private TableView<Student> studentTable;

    @FXML
    private TableColumn<Student, String> idColumn;

    @FXML
    private TableColumn<Student, String> firstNameColumn;

    @FXML
    private TableColumn<Student, String> lastNameColumn;

    @FXML
    private TableColumn<Student, String> groupIdColumn;


    private ObservableList<Student> students = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        students.addAll(studentService.findAll());
        idColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("id"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("lastName"));
        groupIdColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("groupId"));
        studentTable.setItems(students);

        studentTable.setRowFactory(tv -> {
            TableRow<Student> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                Student rowData = row.getItem();
                studentIdText.setText(rowData.getId());
                studentFirstNameText.setText(rowData.getFirstName());
                studentLastNameText.setText(rowData.getLastName());
                studentGroupIdText.setText(rowData.getGroupId());
            });
            return row;
        });

        NativePubSub.getInstance().subscribeStudent(this::updateStudents);
    }

    public void create() {
        Student student = new Student();
        student.setFirstName(studentFirstNameText.getText());
        student.setLastName(studentLastNameText.getText());
        student.setGroupId(studentGroupIdText.getText());
        studentService.create(student);
        NativePubSub.getInstance().publishStudent(true);
    }

    public void update() {
        Student student = new Student();
        student.setId(studentIdText.getText());
        student.setFirstName(studentFirstNameText.getText());
        student.setLastName(studentLastNameText.getText());
        student.setGroupId(studentGroupIdText.getText());
        studentService.update(student);
        NativePubSub.getInstance().publishStudent(true);
    }

    public void delete() {
        studentService.delete(studentIdText.getText());
        NativePubSub.getInstance().publishStudent(true);
    }

    private void updateStudents(Boolean b) {
        if(b) {
            students = FXCollections.observableArrayList();
            students.addAll(studentService.findAll());
            studentTable.setItems(students);
        }
    }
}
