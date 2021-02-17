package com.company;

public class Main {

    public static void main(String[] args) {
        new Commands<Database>().commandLine(Database.initDatabase(), 0);
    }
}
