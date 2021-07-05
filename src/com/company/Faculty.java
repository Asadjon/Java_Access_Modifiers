package com.company;

import java.util.List;

import static com.company.InputClass.input;

public class Faculty extends MainClass<Group>{

    Faculty(String mName, int mRating, List<Group> mObjects) {
        super(mName, mRating, mObjects);
    }

    Faculty() {
        super();
    }

    @Override
    public String getChildrenTypeName() {
        return "Group";
    }

    @Override
    public String getTypeName() {
        return "Faculty";
    }

    @Override
    int getTabCount() {
        return 1;
    }

    @Override
    Group createNewObject() {
        Group newGroup = new Group();

        System.out.print(tab + getChildrenTypeName() + " name: ");
        newGroup.setName(input(String.class));

        System.out.print(tab + getChildrenTypeName() + " rating: ");
        newGroup.setRating(input(Integer.class));

        newGroup.Add();

        return newGroup;
    }
}
