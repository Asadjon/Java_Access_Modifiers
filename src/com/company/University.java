package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.company.InputClass.TypeVariable;

public class University implements Shower, Action {

    private String mUniversityName;

    private int mUniversityRating;

    private List<Faculty> mFaculties;

    University(String mUniversityName, int mUniversityRating, List<Faculty> mFaculties) {
        this.mUniversityName = mUniversityName;
        this.mUniversityRating = mUniversityRating;
        this.mFaculties = mFaculties;
    }

    University() {this.mFaculties = new ArrayList<>();}

    String getUniversityName() {
        return mUniversityName;
    }

    void setUniversityName(String mUniversityName) {
        this.mUniversityName = mUniversityName;
    }

    int getUniversityRating() {
        return mUniversityRating;
    }

    void setUniversityRating(int mUniversityRating) {
        this.mUniversityRating = mUniversityRating;
    }

    List<Faculty> getFaculties() {
        return mFaculties;
    }

    public void setFaculties(List<Faculty> mFaculties) {
        this.mFaculties = mFaculties;
    }

    @Override
    public void show(int id) {
        String builder =
                "University name: " + mUniversityName +
                ", University rating: " + mUniversityRating;

        System.out.println(builder);

        for (int i = 0; i < mFaculties.size(); i++) {
            Shower shower = mFaculties.get(i);

            shower.show(i+1);
        }
    }

    @Override
    public String getClassName() {
        return "Faculty";
    }

    @Override
    public void Add() {
        System.out.print(Color.RED);
        System.out.print("\tInsert faculty number: ");
        int facultySize = (int) InputClass.input(InputClass.TypeVariable.Int);

        for (int i = 0; i < facultySize; i++) {
            System.out.println("\tFaculty: " + (i+1));

            Faculty newFaculty = new Faculty();

            System.out.print("\tFaculty name: ");
            newFaculty.setFacultyName(Objects.requireNonNull(InputClass.input(TypeVariable.String)).toString());

            System.out.print("\tFaculty rating: ");
            newFaculty.setFacultyRating((int) InputClass.input(TypeVariable.Int));

            newFaculty.Add();

            mFaculties.add(newFaculty);
        }
    }

    @Override
    public void Delete() {
        int deletedId;
        do {
            System.out.print("Enter the Faculty ID to be deleted: ");
            deletedId = (int) InputClass.input(TypeVariable.Int);
            if (deletedId < mFaculties.size()+1 && deletedId > 0){
                break;
            }
            System.out.println("This id was not found");
        }while (true);

        mFaculties.remove(deletedId-1);
        System.out.println("Faculty data has been deleted");
    }

    @Override
    public void Update() {

    }

    @Override
    public void Search() {
        int id;
        do {
            System.out.print("Enter the Faculty id: ");
            id = (int) InputClass.input(TypeVariable.Int);
            if (id < mFaculties.size()+1 && id > 0){
                break;
            }
            System.out.println("This id was not found");
        }while (true);

        Faculty faculty = mFaculties.get(id-1);
        faculty.show(id);
        Commands<Faculty> commands = new Commands<>();
        commands.commandLine(faculty, id);
    }
}
