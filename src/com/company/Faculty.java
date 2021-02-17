package com.company;

import java.util.List;
import java.util.Objects;

public class Faculty extends MainClass{

    Faculty(String mName, int mRating, List<Object> mObjects) {
        super(mName, mRating, mObjects);
    }

    Faculty() {
        super();
    }

    @Override
    public String getChildrenClassName() {
        return new Group().toString();
    }

    @Override
    int getTabCount() {
        return 1;
    }

    @Override
    Object createNewObject() {
        Group newGroup = new Group();

        System.out.print(tab + getChildrenClassName() + " name: ");
        newGroup.setName(Objects.requireNonNull(InputClass.input(InputClass.TypeVariable.String)).toString());

        System.out.print(tab + getChildrenClassName() + " rating: ");
        newGroup.setRating((int) InputClass.input(InputClass.TypeVariable.Int));

        newGroup.Add();

        return newGroup;
    }

    @Override
    public String toString() {
        return "Faculty";
    }
}
