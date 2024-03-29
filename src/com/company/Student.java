package com.company;

import static com.company.InputClass.input;

public class Student implements Shower{

    private String mName;

    private String mFamily;

    private String mLastName;

    private String mBirthday;

    private int mAge;

    private double mWeight;

    private double mHeight;

    private double mScholarship;

    Student(String mName, String mFamily, String mLastName, String mBirthday, int mAge, double mHeight, double mWeight, double mScholarship) {
        this.mName = mName;
        this.mFamily = mFamily;
        this.mLastName = mLastName;
        this.mBirthday = mBirthday;
        this.mAge = mAge;
        this.mHeight = mHeight;
        this.mWeight = mWeight;
        this.mScholarship = mScholarship;
    }

    Student() {}

    String getName() {
        return mName;
    }

    void setName(String name) {
        mName = name;
    }

    String getFamily() {
        return mFamily;
    }

    void setFamily(String family) {
        mFamily = family;
    }

    String getLastName() {
        return mLastName;
    }

    void setLastName(String lastName) {
        mLastName = lastName;
    }

    String getBirthday() {
        return mBirthday;
    }

    void setBirthday(String birthday) {
        mBirthday = birthday;
    }

    int getAge() {
        return mAge;
    }

    void setAge(int age) {
        mAge = age;
    }

    double getHeight() {
        return mHeight;
    }

    void setHeight(double height) {
        mHeight = height;
    }

    double getWeight() {
        return mWeight;
    }

    void setWeight(double weight) {
        mWeight = weight;
    }

    double getScholarship() {
        return mScholarship;
    }

    void setScholarship(double scholarship) {
        mScholarship = scholarship;
    }

    @Override
    public void show(int id) {
        String builder = "|\t|\t|\t Student: " + id + ",\t" + toString();
        System.out.println(builder);
    }

    @Override
    public String getChildrenTypeName() { return ""; }

    @Override
    public String getTypeName() {
        return "Student";
    }

    @Override
    public void UpdateTheChildren() {

        System.out.println("Now name of Student: " + mName);
        System.out.print("Enter new Student name: ");
        mName = input(String.class);

        System.out.println("Now family of Student: " + mFamily);
        System.out.print("Enter new Student family: ");
        mFamily = input(String.class);

        System.out.println("Now last name of Student: " + mLastName);
        System.out.print("Enter new Student last name: ");
        mLastName = input(String.class);

        System.out.println("Now birthday of Student: " + mBirthday);
        System.out.print("Enter new Student birthday: ");
        mBirthday = input(String.class);

        System.out.println("Now age of Student: " + mAge);
        System.out.print("Enter new Student age: ");
        mAge = input(Integer.class);

        System.out.println("Now height of Student: " + mHeight);
        System.out.print("Enter new Student height: ");
        mHeight = input(Double.class);

        System.out.println("Now weight of Student: " + mWeight);
        System.out.print("Enter new Student weight: ");
        mWeight = input(Double.class);

        System.out.println("Now scholarship of Student: " + mScholarship);
        System.out.print("Enter new Student scholarship: ");
        mScholarship = input(Double.class);
    }

    @Override
    public String toString() {
        String builder =
                        "Name: " + getName() +
                        ", Family: " + getFamily() +
                        ", Last name: " + getLastName() +
                        ", Birthday: " + getBirthday() +
                        ", Age: " + getAge() +
                        ", Height: " + getHeight() + " m" +
                        ", Weight: " + getWeight() + " kg" +
                        ", Scholarship: " + getScholarship() + " so'm";
        return builder;
    }
}
