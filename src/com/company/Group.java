package com.company;


import java.util.List;
import java.util.Objects;

import static com.company.InputClass.input;

class Group extends MainClass<Student>{

    Group(String mName, int mRating, List<Student> mObjects) {
        super(mName, mRating, mObjects);
    }

    Group() {
        super();
    }

    @Override
    public String getChildrenTypeName() {
        return "Student";
    }

    @Override
    public String getTypeName() {
        return "Group";
    }

    @Override
    int getTabCount() {
        return 2;
    }

    @Override
    Student createNewObject() {
        Student newStudent = new Student();

        System.out.print("\t\t\t       Name: ");
        newStudent.setName(input(String.class));

        System.out.print("\t\t\t     Family: ");
        newStudent.setFamily(input(String.class));

        System.out.print("\t\t\t  Last name: ");
        newStudent.setLastName(input(String.class));

        System.out.print("\t\t\t   Birthday: ");
        newStudent.setBirthday(input(String.class));

        System.out.print("\t\t\t        Age: ");
        newStudent.setAge(input(Integer.class));

        System.out.print("\t\t\t     Height: ");
        newStudent.setHeight(input(Double.class));

        System.out.print("\t\t\t     Weight: ");
        newStudent.setWeight(input(Double.class));

        System.out.print("\t\t\tScholarship: ");
        newStudent.setScholarship(input(Double.class));
        System.out.println();

        return newStudent;
    }
}
