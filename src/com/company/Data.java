package com.company;

import java.util.List;
import java.util.Objects;

public class Data extends MainClass {

    Data(String mName, int mRating, List<Object> mObjects) {
        super(mName, mRating, mObjects);
    }

    Data() {
        super();
    }

    @Override
    String getThisClassName() {
        return "Data";
    }

    @Override
    public String getChildrenClassName() {
        return "University";
    }

    @Override
    int getTabCount() {
        return 0;
    }

    @Override
    Object createNewObject() {
        University newUniversity = new University();

        System.out.print(tab + getChildrenClassName() + " name: ");
        newUniversity.setName(Objects.requireNonNull(InputClass.input(InputClass.TypeVariable.String)).toString());

        System.out.print(tab + getChildrenClassName() + " rating: ");
        newUniversity.setRating((Integer) InputClass.input(InputClass.TypeVariable.Int));

        newUniversity.Add();

        return newUniversity;
    }
}
