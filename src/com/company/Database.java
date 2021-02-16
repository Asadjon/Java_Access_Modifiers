package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.company.InputClass.TypeVariable;

public class Database implements Shower, Action{

    private static Database mDatabase;

    private List<University> mUniversities;

    static Database initDatabase(){
        return mDatabase != null ? mDatabase : (mDatabase = new Database());
    }

    private Database() {
        List<University> universities = JsonController.initJsonController().getUniversities();
        this.mUniversities = universities != null ? universities : new ArrayList<>();
    }

    List<University> getUniversities() {
        return mUniversities;
    }

    @Override
    public void show(int id) {
        for (int i = 0; i < mUniversities.size(); i++) {
            mUniversities.get(i).show(i);
        }
    }

    @Override
    public String getClassName() {
        return "University";
    }

    @Override
    public void Add() {
        System.out.print("Insert universities number: ");
        int universitySize = (int) InputClass.input(TypeVariable.Int);

        for (int i = 0; i < universitySize; i++) {
            System.out.println("University: " + (i+1));

            University newUniversity = new University();

            System.out.print("University name: ");
            newUniversity.setUniversityName(Objects.requireNonNull(InputClass.input(TypeVariable.String)).toString());

            System.out.print("University rating: ");
            newUniversity.setUniversityRating((Integer) InputClass.input(TypeVariable.Int));

            newUniversity.Add();

            mUniversities.add(newUniversity);
        }

    }

    @Override
    public void Delete() {
        int deletedId;
        do {
            System.out.print("Enter the University ID to be deleted: ");
            deletedId = (int) InputClass.input(TypeVariable.Int);
            if (deletedId < mUniversities.size()+1 && deletedId > 0){
                break;
            }
            System.out.println("This id was not found");
        }while (true);

        mUniversities.remove(deletedId-1);
        System.out.println("University data has been deleted");
    }

    @Override
    public void Update() {

    }

    @Override
    public void Search() {
        int id;
        do {
            System.out.print("Enter the University id: ");
            id = (int) InputClass.input(TypeVariable.Int);
            if (id < mUniversities.size()+1 && id > 0){
                break;
            }
            System.out.println("This id was not found");
        }while (true);

        University university = mUniversities.get(id-1);
        university.show(id);
        Commands<University> commands = new Commands<>();
        commands.commandLine(university, id);
    }
}
