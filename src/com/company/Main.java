package com.company;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    private Main(){
        Commands<Database> commands = new Commands<>();
        commands.commandLine(Database.initDatabase(), 0);
    }
}
