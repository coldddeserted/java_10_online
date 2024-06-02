package ua.com.alevel.hw7.db;

import ua.com.alevel.hw7.entity.Group;
import ua.com.alevel.hw7.entity.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class DBResourse {
    List<Group> groupList = new ArrayList<>();
    List<Student> studentList = new ArrayList<>();

    private final static DBResourse instance = new DBResourse();

    private DBResourse() { }

    public static DBResourse getInstance() {
        return instance;
    }

    public void createStudent(Student student) {
        student.setId(UUID.randomUUID().toString());
        studentList.add(student);
    }

    public void updateStudent(Student student) {
        for (Group currentGroup : groupList) {
            if(!currentGroup.getId().equals(student.getGroupId())) student.setGroupId(null);
        }

        for (int i = 0; i < studentList.size(); i++) {
            if(studentList.get(i).getId().equals(student.getId())) studentList.set(i, student);
        }
    }

    public void deleteStudent(String id) {
        for (Student currentStudent : studentList) {
            if(currentStudent.getId().equals(id)) studentList.remove(currentStudent);
        }
    }

    public Student findStudentById(String id) {
        Student studentToReturn = null;
        for (Student currentStudent : studentList) {
           if(currentStudent.getId().equals(id)) studentToReturn = currentStudent;
        }
        return studentToReturn;
    }

    public Collection<Student> findAllStudent() {
        return studentList;
    }

    public void createGroup(Group group) {
        group.setId(UUID.randomUUID().toString());
        groupList.add(group);
    }

    public void updateGroup(Group group) {
        for (int i = 0; i < groupList.size(); i++) {
            if(groupList.get(i).getId().equals(group.getId())) {
                groupList.set(i, group);
            }
        }
    }

    public void deleteGroup(String id) {
        for (Group currentGroup : groupList) {
            if(currentGroup.getId().equals(id)) groupList.remove(currentGroup);
        }

        for (int i = 0; i < studentList.size(); i++) {
            if(studentList.get(i).getGroupId().equals(id)) studentList.get(i).setGroupId(null);
        }
    }

    public Group findGroupById(String id) {
        Group groupToReturn = null;
        for (Group currentGroup : groupList) {
            if(currentGroup.getId().equals(id)) groupToReturn = currentGroup;
        }
        return groupToReturn;
    }

    public Collection<Group> findAllGroups() {
        return groupList;
    }
}
