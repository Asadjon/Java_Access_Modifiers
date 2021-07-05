package com.company;

import java.util.List;

import static com.company.InputClass.input;

public class University extends MainClass<Faculty>{

    University(String mName, int mRating, List<Faculty> mObjects) {
        super(mName, mRating, mObjects);
    }

    University() {
        super();
    }

    @Override
    public String getChildrenTypeName() {
        return "Faculty";
    }

    @Override
    public String getTypeName() {
        return "University";
    }

    @Override
    int getTabCount() {
        return 0;
    }

    @Override
    Faculty createNewObject() {
        Faculty newFaculty = new Faculty();

        System.out.print(tab + getChildrenTypeName() + " name: ");
        newFaculty.setName(input(String.class));

        System.out.print(tab + getChildrenTypeName() + " rating: ");
        newFaculty.setRating(input(Integer.class));

        newFaculty.Add();

        return newFaculty;
    }
}
