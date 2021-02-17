package com.company;

import java.util.List;
import java.util.Objects;

public class University extends MainClass{

    University(String mName, int mRating, List<Object> mObjects) {
        super(mName, mRating, mObjects);
    }

    University() {
        super();
    }

    @Override
    String getThisClassName() {
        return "University";
    }

    @Override
    public String getChildrenClassName() {
        return "Faculty";
    }

    @Override
    int getTabCount() {
        return 0;
    }

    @Override
    Object createNewObject() {
        Faculty newFaculty = new Faculty();

        System.out.print(tab + getChildrenClassName() + " name: ");
        newFaculty.setName(Objects.requireNonNull(InputClass.input(InputClass.TypeVariable.String)).toString());

        System.out.print(tab + getChildrenClassName() + " rating: ");
        newFaculty.setRating((int) InputClass.input(InputClass.TypeVariable.Int));

        newFaculty.Add();

        return newFaculty;
    }

}
