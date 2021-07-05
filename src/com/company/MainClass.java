package com.company;

import java.util.ArrayList;
import java.util.List;

import static com.company.InputClass.input;

public abstract class MainClass <T> implements Shower, Action{

    private String mName;

    private int mRating;

    private List<T> mObjects;

    String tab = "";

    MainClass(String mName, int mRating, List<T> mObjects) {
        this();
        this.mName = mName;
        this.mRating = mRating;
        this.mObjects = mObjects;
    }

    MainClass() {
        this.mObjects = new ArrayList<>();

        StringBuilder tab = new StringBuilder();
        for (int j = 0; j < getTabCount(); j++) {
            tab.append("\t");
        }
    }

    String getName() {
        return mName;
    }

    void setName(String mName) {
        this.mName = mName;
    }

    int getRating() {
        return mRating;
    }

    void setRating(int mRating) {
        this.mRating = mRating;
    }

    List<T> getObjects() {
        return mObjects;
    }

    void setObjects(List<T> mObjects) {
        this.mObjects = mObjects;
    }

    abstract int getTabCount();

    abstract T createNewObject();

    @Override
    public void Add() {
        System.out.print(tab + "Insert " + getChildrenTypeName() + " number: ");
        int studentsSize = input(Integer.class);

        for (int i = 0; i < studentsSize; i++) {

            System.out.println(tab + getChildrenTypeName() + ": " + (i+1));

            T newObject = createNewObject();

            mObjects.add(newObject);
        }
    }

    @Override
    public void Delete() {
        int deletedId;
        do {
            System.out.print("Enter the " + getChildrenTypeName() + " ID to be deleted: ");
            deletedId = input(Integer.class);
            if (deletedId < mObjects.size()+1 && deletedId > 0){
                deletedId--;
                break;
            }
            System.out.println("This id was not found");
        }while (true);

        mObjects.remove(deletedId);
        System.out.println(toString() + " data has been deleted");
    }

    @Override
    public void Update() {
        int updateId;
        do {
            System.out.print("Enter the " + getChildrenTypeName() + " ID to be update: ");
            updateId = input(Integer.class);
            if (updateId < mObjects.size()+1 && updateId > 0){
                updateId--;
                break;
            }
            System.out.println("This id was not found");
        }while (true);

        Object object = mObjects.get(updateId);
        ((Shower) object).UpdateTheChildren();
    }

    @Override
    public void UpdateTheChildren() {
        System.out.println("Now name of " + toString() + ": " + mName);
        System.out.print("Enter new " + toString() + " name: ");
        mName = input(String.class);

        System.out.println("Now rating of " + toString() + ": " + mRating);
        System.out.print("Enter new " + toString() + " rating: ");
        mRating = input(Integer.class);

        System.out.print("Do you want to change " + getChildrenTypeName() + " as well? (1-yes, 0-no): ");
        boolean groupChanging = input(Boolean.class);

        if (groupChanging) {
            mObjects.forEach(object -> {
                ((Shower) object).UpdateTheChildren();
            });
        }
    }

    @Override
    public void Search() {
        int searchId;
        do {
            System.out.print("Enter the " + getChildrenTypeName() + " id: ");
            searchId = input(Integer.class);
            if (searchId < mObjects.size()+1 && searchId > 0){
                searchId--;
                break;
            }
            System.out.println("This id was not found");
        }while (true);

        T object = mObjects.get(searchId);
        ((Shower)object).show(searchId+1);

        Commands<T> commands = new Commands();
        commands.commandLine(object, searchId);
    }

    @Override
    public void show(int id) {
        StringBuilder tab = new StringBuilder();
        for (int i = 0; i < getTabCount(); i++) tab.append("|\t");

        tab.append(getTypeName()).append(": ").append(id).append(",\t").append(toString());

        System.out.println(tab);

        for (int i = 0; i < mObjects.size(); i++) {
            Object object = mObjects.get(i);
            if (object instanceof Shower) {
                Shower shower = (Shower) mObjects.get(i);
                shower.show(i + 1);
            }
        }
    }

    @Override
    public String toString() {
        return getTypeName() + " name: " + mName + ", " +
                getTypeName() + " rating: " + mRating + ", " +
                getChildrenTypeName() + " data list size: " + mObjects.size();
    }
}
