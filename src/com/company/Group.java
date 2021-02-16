package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.company.InputClass.TypeVariable;

public class Group implements Shower, Action {

    private String mGroupName;

    private int mGroupRating;

    private List<Student> mStudents;

    Group(String mGroupName, int mGroupRating, List<Student> mStudents) {
        this.mGroupName = mGroupName;
        this.mGroupRating = mGroupRating;
        this.mStudents = mStudents;
    }

    Group() {this.mStudents = new ArrayList<>();}

    String getGroupName() {
        return mGroupName;
    }

     void setGroupName(String mGroupName) {
        this.mGroupName = mGroupName;
    }

    int getGroupRating() {
        return mGroupRating;
    }

    void setGroupRating(int mGroupRating) {
        this.mGroupRating = mGroupRating;
    }

    List<Student> getStudents() {
        return mStudents;
    }

    public void setStudents(List<Student> mStudents) {
        this.mStudents = mStudents;
    }

    @Override
    public void show(int id) {
        String builder =
                "\t\tGroup: " + id +
                ",\tGroup name: " + mGroupName +
                ", Group rating: " + mGroupRating;

        System.out.println(builder);

        for (int i = 0; i < mStudents.size(); i++) {
            Shower shower = mStudents.get(i);
            shower.show(i + 1);
        }
    }

    @Override
    public String getClassName() {
        return "Student";
    }

    private Student createNewStudent(){
        Student newStudent = new Student();

        System.out.print("\t\t\t\t       Name: ");
        newStudent.setName(Objects.requireNonNull(InputClass.input(TypeVariable.String)).toString());

        System.out.print("\t\t\t\t     Family: ");
        newStudent.setFamily(Objects.requireNonNull(InputClass.input(TypeVariable.String)).toString());

        System.out.print("\t\t\t\t  Last name: ");
        newStudent.setLastName(Objects.requireNonNull(InputClass.input(TypeVariable.String)).toString());

        System.out.print("\t\t\t\t   Birthday: ");
        newStudent.setBirthday(Objects.requireNonNull(InputClass.input(TypeVariable.String)).toString());

        System.out.print("\t\t\t\t        Age: ");
        newStudent.setAge((int) InputClass.input(TypeVariable.Int));

        System.out.print("\t\t\t\t     Height: ");
        newStudent.setHeight((double) InputClass.input(TypeVariable.Double));

        System.out.print("\t\t\t\t     Weight: ");
        newStudent.setWeight((double) InputClass.input(TypeVariable.Double));

        System.out.print("\t\t\t\tScholarship: ");
        newStudent.setScholarship((double) InputClass.input(TypeVariable.Double));
        System.out.println();

        return newStudent;
    }

    @Override
    public void Add() {

        System.out.print("\t\t\tInsert students number: ");
        int studentsSize = (int) InputClass.input(InputClass.TypeVariable.Int);

        for (int i = 0; i < studentsSize; i++) {
            System.out.println("\t\t\tStudent: " + (i+1));

            Student newStudent = createNewStudent();

            mStudents.add(newStudent);
        }
    }

    @Override
    public void Delete() {
        int deletedId;
        do {
            System.out.print("Enter the Student ID to be deleted: ");
            deletedId = (int) InputClass.input(InputClass.TypeVariable.Int);
            if (deletedId < mStudents.size()+1 && deletedId > 0){
                break;
            }
            System.out.println("This id was not found");
        }while (true);

        mStudents.remove(deletedId-1);
        System.out.println("Group data has been deleted");
    }

    @Override
    public void Update() {

    }

    @Override
    public void Search() {
        int id;
        do {
            System.out.print("Enter the Student id: ");
            id = (int) InputClass.input(InputClass.TypeVariable.Int);
            if (id < mStudents.size()+1 && id > 0){
                break;
            }
            System.out.println("This id was not found");
        }while (true);

        Student student = mStudents.get(id-1);
        student.show(id);
    }
}
