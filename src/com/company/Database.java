package com.company;

import java.util.ArrayList;

import static com.company.InputClass.input;

public class Database extends MainClass<University>{

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
    public String getChildrenTypeName() {
        return "University";
    }

    @Override
    public String getTypeName() { return "Database"; }

    @Override
    int getTabCount() {
        return 0;
    }

    @Override
    University createNewObject() {
        University newUniversity = new University();

        System.out.print(tab + getChildrenTypeName() + " name: ");
        newUniversity.setName(input(String.class));

        System.out.print(tab + getChildrenTypeName() + " rating: ");
        newUniversity.setRating(input(Integer.class));

        newUniversity.Add();

        return newUniversity;
    }
}
