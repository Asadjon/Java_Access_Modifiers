package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.company.InputClass.TypeVariable;

public class Database extends MainClass{

    private static Database mDatabase;

    static Database initDatabase(){
        return mDatabase != null ? mDatabase : (mDatabase = new Database());
    }

    private Database() {
        setObjects(JsonController.initJsonController().getUniversities());
        this.setObjects(getObjects() != null ? getObjects() : new ArrayList<>());
    }

    @Override
    public void show(int id) {
        for (int i = 0; i < getObjects().size(); i++) {
            ((Shower) getObjects().get(i)).show(i+1);
        }
    }

    @Override
    public String getChildrenClassName() {
        return new University().toString();
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
