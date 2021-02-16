package com.company;

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

        String builder =
                "\t\t\tStudent: " + id +
                ",\tName: " + getName() +
                ", Family: " + getFamily() +
                ", Last name: " + getLastName() +
                ", Birthday: " + getBirthday() +
                ", Age: " + getAge() +
                ", Height: " + getHeight() + " m" +
                ", Weight: " + getWeight() + " kg" +
                ", Scholarship: " + getScholarship() + " so'm";
        System.out.println(builder);
    }

    @Override
    public String getClassName() {
        return "";
    }
}
