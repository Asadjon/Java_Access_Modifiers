package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Faculty implements Shower, Action {

    private String mFacultyName;
    
    private int mFacultyRating;
    
    private List<Group> mGroups;

    Faculty(String mFacultyName, int mFacultyRating, List<Group> mGroups) {
        this.mFacultyName = mFacultyName;
        this.mFacultyRating = mFacultyRating;
        this.mGroups = mGroups;
    }

    Faculty() {this.mGroups = new ArrayList<>();}

    String getFacultyName() {
        return mFacultyName;
    }

    void setFacultyName(String mFacultyName) {
        this.mFacultyName = mFacultyName;
    }

    int getFacultyRating() {
        return mFacultyRating;
    }

    void setFacultyRating(int mFacultyRating) {
        this.mFacultyRating = mFacultyRating;
    }

    List<Group> getGroups() {
        return mGroups;
    }

    public void setGroups(List<Group> mGroups) {
        this.mGroups = mGroups;
    }

    @Override
    public void show(int id) {
        String builder =
                "\tFaculty: " + id +
                ",\tFaculty name: " + mFacultyName +
                ", Faculty rating: " + mFacultyRating;

        System.out.println(builder);

        for (int i = 0; i < mGroups.size(); i++) {
            Shower shower = mGroups.get(i);

            shower.show(i+1);
        }
    }

    @Override
    public String getClassName() {
        return "Group";
    }

    @Override
    public void Add() {

        System.out.print("\t\tInsert groups number: ");
        int groupsSize = (int) InputClass.input(InputClass.TypeVariable.Int);

        for (int i = 0; i < groupsSize; i++) {
            System.out.println("\t\tGroup: " + (i+1));

            Group newFaculty = new Group();

            System.out.print("\t\tGroup name: ");
            newFaculty.setGroupName(Objects.requireNonNull(InputClass.input(InputClass.TypeVariable.String)).toString());

            System.out.print("\t\tGroup rating: ");
            newFaculty.setGroupRating((int) InputClass.input(InputClass.TypeVariable.Int));

            newFaculty.Add();

            mGroups.add(newFaculty);
        }
    }

    @Override
    public void Delete() {
        int deletedId;
        do {
            System.out.print("Enter the Group ID to be deleted: ");
            deletedId = (int) InputClass.input(InputClass.TypeVariable.Int);
            if (deletedId < mGroups.size()+1 && deletedId > 0){
                break;
            }
            System.out.println("This id was not found");
        }while (true);

        mGroups.remove(deletedId-1);
        System.out.println("Group data has been deleted");
    }

    @Override
    public void Update() {

    }

    @Override
    public void Search() {
        int id;
        do {
            System.out.print("Enter the Group id: ");
            id = (int) InputClass.input(InputClass.TypeVariable.Int);
            if (id < mGroups.size()+1 && id > 0){
                break;
            }
            System.out.println("This id was not found");
        }while (true);

        Group group = mGroups.get(id-1);
        group.show(id);
        Commands<Group> commands = new Commands<>();
        commands.commandLine(group, id);
    }
}
