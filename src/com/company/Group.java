package com.company;


import java.util.List;
import java.util.Objects;

class Group extends MainClass{

    Group(String mName, int mRating, List<Object> mObjects) {
        super(mName, mRating, mObjects);
    }

    Group() {
        super();
    }

    @Override
    String getThisClassName() {
        return "Group";
    }

    @Override
    public String getChildrenClassName() {
        return "Student";
    }

    @Override
    int getTabCount() {
        return 2;
    }

    @Override
    Object createNewObject() {
        Student newStudent = new Student();

        System.out.print("\t\t\t       Name: ");
        newStudent.setName(Objects.requireNonNull(InputClass.input(InputClass.TypeVariable.String)).toString());

        System.out.print("\t\t\t     Family: ");
        newStudent.setFamily(Objects.requireNonNull(InputClass.input(InputClass.TypeVariable.String)).toString());

        System.out.print("\t\t\t  Last name: ");
        newStudent.setLastName(Objects.requireNonNull(InputClass.input(InputClass.TypeVariable.String)).toString());

        System.out.print("\t\t\t   Birthday: ");
        newStudent.setBirthday(Objects.requireNonNull(InputClass.input(InputClass.TypeVariable.String)).toString());

        System.out.print("\t\t\t        Age: ");
        newStudent.setAge((int) InputClass.input(InputClass.TypeVariable.Int));

        System.out.print("\t\t\t     Height: ");
        newStudent.setHeight((double) InputClass.input(InputClass.TypeVariable.Double));

        System.out.print("\t\t\t     Weight: ");
        newStudent.setWeight((double) InputClass.input(InputClass.TypeVariable.Double));

        System.out.print("\t\t\tScholarship: ");
        newStudent.setScholarship((double) InputClass.input(InputClass.TypeVariable.Double));
        System.out.println();

        return newStudent;
    }
}
